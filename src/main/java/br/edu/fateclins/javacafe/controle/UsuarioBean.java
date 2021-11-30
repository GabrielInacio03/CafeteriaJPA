package br.edu.fateclins.javacafe.controle;

import br.edu.fateclins.javacafe.dao.TipoUsuarioDAO;
import br.edu.fateclins.javacafe.dao.UsuarioDAO;
import br.edu.fateclins.javacafe.modelo.TipoUsuario;
import br.edu.fateclins.javacafe.modelo.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class UsuarioBean {

    private Usuario usuario;
    private int idTab;
    private List<Usuario> listaUsuarios;
    private List<TipoUsuario> listaTipos;
    private String senha;

    public UsuarioBean() {
        prepararTela();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdTab() {
        return idTab;
    }

    public void setIdTab(int idTab) {
        this.idTab = idTab;
    }

    public List<Usuario> getListaUsuarios() {
        if (listaUsuarios == null) {
            UsuarioDAO dao = new UsuarioDAO();
            listaUsuarios = dao.listarTodos();
        }
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<TipoUsuario> getListaTipos() {
        if (listaTipos == null) {
            TipoUsuarioDAO dao = new TipoUsuarioDAO();
            listaTipos = dao.listarTodos();
        }
        return listaTipos;
    }

    public void setListaTipos(List<TipoUsuario> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private void prepararTela() {
        usuario = new Usuario();
        listaTipos = null;
        listaUsuarios = null;
        idTab = 0;
        senha = "";
    }

    public void limpar() {
        prepararTela();
        idTab = 1;
    }

    public void editar(Usuario usuario) {
        this.usuario = usuario;
        idTab = 1;
    }

    public void excluir(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO();
        String msg = dao.delete(usuario);
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Sucesso ao Excluir", msg);
        fc.addMessage(null, fm);
        prepararTela();
    }

    public void salvar() {
        FacesMessage fm;
        String msg = "";
        if (usuario.getNome().isEmpty() || usuario.getEmail().isEmpty()) {
            msg = "Campos: nome e e-mail são obrigatórios";
            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Campos sem Preencher", msg);
        } else {
            if (!this.senha.equals("")){
                usuario.setSenha(senha);
            }
            UsuarioDAO dao = new UsuarioDAO();
            msg = dao.salvar(usuario);
            fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Sucesso ao Salvar", msg);
        }
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, fm);
        prepararTela();
        idTab = 1;
    }

}
