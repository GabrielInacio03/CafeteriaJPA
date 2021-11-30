/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fateclins.javacafe.conversor;

import br.edu.fateclins.javacafe.dao.TipoUsuarioDAO;
import br.edu.fateclins.javacafe.modelo.TipoUsuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author apazi
 */
@FacesConverter("TipoUsuarioConverter")
public class TipoUsuarioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        TipoUsuario obj = null;
        TipoUsuarioDAO dao = new TipoUsuarioDAO();
        try{
            obj = dao.procurarPorId(Integer.parseInt(value));
        } catch (Exception e){
            System.out.println("Erro no conversor Tipo Usuario - getAsObject");
        }
        return obj;
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        try{
            TipoUsuario obj = (TipoUsuario) o;
            return String.valueOf(obj.getId());
        } catch (Exception e){
            System.out.println("Erro no conversor Tipo Usuario - getAsString");
            return "";
        }
    }
    
}
