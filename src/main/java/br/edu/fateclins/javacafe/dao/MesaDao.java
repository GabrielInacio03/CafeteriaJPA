package br.edu.fateclins.javacafe.dao;

import br.edu.fateclins.javacafe.modelo.Mesa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
 *
 * @author Inacio
 */
public class MesaDao extends GenericDAO<Mesa>{
    @Override
    public Mesa procurarPorId(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        Mesa obj = null;
        try {
            Query q = em.createQuery("select m from Mesa m where m.id =:id", Mesa.class);
            q.setParameter("id", id);
            obj = (Mesa) q.getSingleResult();
            em.close();
            return obj;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }

    @Override
    public List<Mesa> listarTodos() {
        try {
            EntityManager em = JPAUtil.getEntityManager();
            Query q = em.createQuery("select m from Mesa m", Mesa.class);
            List<Mesa> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }

    @Override
    public String salvar(Mesa obj) {
        if (procurarPorId(obj.getId()) == null) {
            return this.add(obj);
        } else {
            return this.update(obj);
        }
    }   
}
