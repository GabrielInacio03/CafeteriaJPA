package br.edu.fateclins.javacafe.dao;

import br.edu.fateclins.javacafe.modelo.Pedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
 *
 * @author Inacio
 */
public class PedidoDao extends GenericDAO<Pedido>{
     public PedidoDao() {
        super();
    }
     
    @Override 
    public Pedido procurarPorId(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        Pedido obj = null;
        try {
            Query q = em.createQuery("select p from pedido p where p.id =:id", Pedido.class);
            q.setParameter("id", id);
            obj = (Pedido) q.getSingleResult();
            em.close();
            return obj;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }

    @Override
    public List<Pedido> listarTodos() {
        try {
            EntityManager em = JPAUtil.getEntityManager();
            Query q = em.createQuery("select p from Pedido p", Pedido.class);
            List<Pedido> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }

    @Override
    public String salvar(Pedido obj) {
        if (procurarPorId(obj.getId()) == null) {
            return this.add(obj);
        } else {
            return this.update(obj);
        }
    }   
}
