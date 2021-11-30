/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fateclins.javacafe.controle;

import br.edu.fateclins.javacafe.dao.TipoUsuarioDAO;
import br.edu.fateclins.javacafe.modelo.TipoUsuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author apazi
 */
@ManagedBean
@ViewScoped
public class TipoUsuarioBean {

    private TipoUsuario tipoUsuario;
    private int idTab;
    private List<TipoUsuario> listaTipos;

    public TipoUsuarioBean() {
        prepararTela();
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdTab() {
        return idTab;
    }

    public void setIdTab(int idTab) {
        this.idTab = idTab;
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

    private void prepararTela() {
        tipoUsuario = new TipoUsuario();
        listaTipos = null;
        idTab = 0;
    }
    
    public void limpar() {
        prepararTela();
        idTab = 1;
    }

    public void editar(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        idTab = 1;
    }

    public void excluir(TipoUsuario obj) {
        TipoUsuarioDAO dao = new TipoUsuarioDAO();
        String msg = dao.delete(obj);
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Sucesso ao Excluir", msg);
        fc.addMessage(null, fm);
        prepararTela();
    }

    public void salvar() {
        FacesMessage fm;
        String msg = "";
        if (tipoUsuario.getTipo().isEmpty()) {
            msg = "Campos: tipo é obrigatório";
            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Campos sem Preencher", msg);
        } else {
            TipoUsuarioDAO dao = new TipoUsuarioDAO();
            msg = dao.salvar(tipoUsuario);
            fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Sucesso ao Salvar", msg);
        }
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, fm);
        prepararTela();
        idTab = 1;
    }

}
