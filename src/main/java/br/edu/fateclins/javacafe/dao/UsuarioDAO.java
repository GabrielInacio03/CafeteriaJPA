package br.edu.fateclins.javacafe.dao;

import br.edu.fateclins.javacafe.modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author apazi
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO() {
        super();
    }

    public Usuario buscarUsuario(String email) {
        EntityManager em = JPAUtil.getEntityManager();
        Usuario user = null;
        try {
            Query q = em.createQuery("select u from Usuario u where u.email =:email", Usuario.class);
            q.setParameter("email", email);

            user = (Usuario) q.getSingleResult();
            em.close();
            return user;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Usuario procurarPorId(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        Usuario user = null;
        try {
            Query q = em.createQuery("select u from Usuario u where u.id =:id", Usuario.class);
            q.setParameter("id", id);
            user = (Usuario) q.getSingleResult();
            em.close();
            return user;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }

    @Override
    public List<Usuario> listarTodos() {
        try {
            EntityManager em = JPAUtil.getEntityManager();
            Query q = em.createQuery("select u from Usuario u", Usuario.class);
            List<Usuario> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }

    @Override
    public String salvar(Usuario obj) {
        if(procurarPorId(obj.getId())==null){
            return this.add(obj);
        } else {
            return this.update(obj);
        }
    }
}
