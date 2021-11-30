package br.edu.fateclins.javacafe.controle;

import br.edu.fateclins.javacafe.dao.MesaDao;
import br.edu.fateclins.javacafe.modelo.Mesa;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Inacio
 */
@ManagedBean
@ViewScoped
public class MesaBean {
    private Mesa mesa;
    private int idTab;
    private int quantidadePessoas;
    private List<Mesa> listamesas;

    public MesaBean() {
        prepararTela();
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setUsuario(Mesa mesa) {
        this.mesa = mesa;
    }

    public int getIdTab() {
        return idTab;
    }

    public void setIdTab(int idTab) {
        this.idTab = idTab;
    }

    public List<Mesa> getListaMesas() {
        if (listamesas == null) {
            MesaDao dao = new MesaDao();
            listamesas = dao.listarTodos();
        }
        return listamesas;
    }

    public void setListaMesas(List<Mesa> listamesas) {
        this.listamesas = listamesas;
    }
   
    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    private void prepararTela() {
        mesa = new Mesa();        
        listamesas = null;
        idTab = 0;
        quantidadePessoas = 0;
    }

    public void limpar() {
        prepararTela();
        idTab = 1;
    }

    public void editar(Mesa mesa) {
        this.mesa = mesa;
        idTab = 1;
    }

    public void excluir(Mesa mesa) {
        MesaDao dao = new MesaDao();
        String msg = dao.delete(mesa);
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Sucesso ao Excluir", msg);
        fc.addMessage(null, fm);
        prepararTela();
    }

    public void salvar() {
        FacesMessage fm;
        String msg = "";
        if (mesa.getQuantidadePessoas() >= 0) {            
            MesaDao dao = new MesaDao();
            msg = dao.salvar(mesa);
            fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Sucesso ao Salvar", msg);                       
        } else {
             msg = "Valor Inválido";
            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Preencha Corretamente! ", msg);
        }
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, fm);
        prepararTela();
        idTab = 1;
    }

}
