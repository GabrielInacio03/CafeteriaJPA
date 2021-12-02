package br.edu.fateclins.javacafe.conversor;
import br.edu.fateclins.javacafe.dao.MesaDao;
import br.edu.fateclins.javacafe.modelo.Mesa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author Inacio
 */
@FacesConverter("MesaConverter")
public class MesaConverter implements Converter{
     @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Mesa obj = null;
        MesaDao dao = new MesaDao();
        try{
            obj = dao.procurarPorId(Integer.parseInt(value));
        } catch (Exception e){
            System.out.println("Erro no conversor Mesa - getAsObject");
        }
        return obj;
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        try{
            Mesa obj = (Mesa) o;
            return String.valueOf(obj.getId());
        } catch (Exception e){
            System.out.println("Erro no conversor Mesa - getAsString");
            return "";
        }
    }
    
}
