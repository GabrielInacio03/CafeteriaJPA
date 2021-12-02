package br.edu.fateclins.javacafe.controle;
import br.edu.fateclins.javacafe.dao.MesaDao;
import br.edu.fateclins.javacafe.dao.PedidoDao;
import br.edu.fateclins.javacafe.modelo.Mesa;
import br.edu.fateclins.javacafe.modelo.Pedido;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class PedidoBean {
    private Pedido pedido;
    private int idTab;
    private List<Pedido> listaPedidos;
    private List<Mesa> listaMesas;
    private Date dataHorario;
    private String status;

     public PedidoBean() {
        prepararTela();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
     public int getIdTab() {
        return idTab;
    }

    public void setIdTab(int idTab) {
        this.idTab = idTab;
    }
    
    public Date getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(Date dataHorario) {
        this.dataHorario = dataHorario;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<Pedido> getListaPedidos() {
        if (listaPedidos == null) {
            PedidoDao dao = new PedidoDao();
            listaPedidos = dao.listarTodos();
        }
        return listaPedidos;
    }
    
    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
    
    public List<Mesa> getListaMesas() {
        if (listaMesas == null) {
            MesaDao dao = new MesaDao();
            listaMesas = dao.listarTodos();
        }
        return listaMesas;
    }

    public void setListaMesas(List<Mesa> listaMesas) {
        this.listaMesas = listaMesas;
    }
    
     private void prepararTela() {
        pedido = new Pedido();
        listaPedidos = null;
        listaMesas = null;        
        idTab = 0;
        dataHorario = null;
        status = "";
    }

    public void limpar() {
        prepararTela();
        idTab = 1;
    }

    public void editar(Pedido pedido) {
        this.pedido = pedido;
        idTab = 1;
    }

    public void excluir(Pedido pedido) {
        PedidoDao dao = new PedidoDao();
        String msg = dao.delete(pedido);
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Sucesso ao Excluir", msg);
        fc.addMessage(null, fm);
        prepararTela();
    }

    public void salvar() {
        FacesMessage fm;
        String msg = "";
        if (pedido.getStatus().isEmpty()) {
            msg = "Campos: status são obrigatórios";
            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Campos sem Preencher", msg);
        } else {            
            PedidoDao dao = new PedidoDao();            
            msg = dao.salvar(pedido);
            fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Sucesso ao Salvar", msg);
        }
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, fm);
        prepararTela();
        idTab = 1;
    }

}
