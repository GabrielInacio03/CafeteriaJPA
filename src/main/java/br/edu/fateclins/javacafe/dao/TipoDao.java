
package br.edu.fateclins.javacafe.dao;
import br.edu.fateclins.javacafe.modelo.Tipo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
 *
 * @author Inacio
 */
public class TipoDao extends GenericDAO<Tipo>{
    public TipoDao() {
        super();
    }
    
    public Tipo buscarTipo(String descricao) {
        EntityManager em = JPAUtil.getEntityManager();
        Tipo tipo = null;
        try {
            Query q = em.createQuery("select t from Tipo t where t.descricao =:descricao", Tipo.class);
            q.setParameter("descricao", descricao);

            tipo = (Tipo) q.getSingleResult();
            em.close();
            return tipo;
        } catch (Exception ex) {
            return null;
        }
    }
    @Override
    public Tipo procurarPorId(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        Tipo tipo = null;
        try {
            Query q = em.createQuery("select t from Tipo t where t.id =:id", Tipo.class);
            q.setParameter("id", id);
            tipo = (Tipo) q.getSingleResult();
            em.close();
            return tipo;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }
    
    @Override
    public List<Tipo> listarTodos() {
        try {
            EntityManager em = JPAUtil.getEntityManager();
            Query q = em.createQuery("select t from Tipo t", Tipo.class);
            List<Tipo> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }
    
    @Override
    public String salvar(Tipo obj) {
        if(procurarPorId(obj.getId())==null){
            return this.add(obj);
        } else {
            return this.update(obj);
        }
    }
}
