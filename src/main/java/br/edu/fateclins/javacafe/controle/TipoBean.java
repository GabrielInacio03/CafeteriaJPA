package br.edu.fateclins.javacafe.controle;
import br.edu.fateclins.javacafe.dao.TipoDao;
import br.edu.fateclins.javacafe.modelo.Tipo;
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
public class TipoBean {
    private Tipo tipo;
    private int idTab;
    private List<Tipo> listaTipos;
    private String descricao;
    
    public TipoBean() {
        prepararTela();
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getIdTab() {
        return idTab;
    }

    public void setIdTab(int idTab) {
        this.idTab = idTab;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public List<Tipo> getListaTipos() {
        if (listaTipos == null) {
            TipoDao dao = new TipoDao();
            listaTipos = dao.listarTodos();
        }
        return listaTipos;
    }

    public void setListaTipos(List<Tipo> listaTipos) {
        this.listaTipos = listaTipos;
    }
    
    private void prepararTela() {
        tipo = new Tipo();
        listaTipos = null;       
        idTab = 0;
        descricao = "";
    }

    public void limpar() {
        prepararTela();
        idTab = 1;
    }

    public void editar(Tipo tipo) {
        this.tipo = tipo;
        idTab = 1;
    }

    public void excluir(Tipo tipo) {
        TipoDao dao = new TipoDao();
        String msg = dao.delete(tipo);
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Sucesso ao Excluir", msg);
        fc.addMessage(null, fm);
        prepararTela();
    }

    public void salvar() {
        FacesMessage fm;
        String msg = "";
                  
        TipoDao dao = new TipoDao();
        msg = dao.salvar(tipo);
        fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Sucesso ao Salvar", msg);
        
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, fm);
        prepararTela();
        idTab = 1;
    }
}
