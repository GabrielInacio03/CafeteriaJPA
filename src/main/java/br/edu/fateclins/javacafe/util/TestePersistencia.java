package br.edu.fateclins.javacafe.util;

import br.edu.fateclins.javacafe.dao.JPAUtil;
import br.edu.fateclins.javacafe.modelo.TipoUsuario;
import br.edu.fateclins.javacafe.modelo.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author apazi
 */
public class TestePersistencia {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        TipoUsuario tpUser = new TipoUsuario();
        tpUser.setTipo("ROOT");
        tpUser.setDescricao("ADMINISTRADOR PRINCIPAL");
        Usuario u1 = new Usuario("Anderson Pazin", "123456", "a.pazin@email.com");
        u1.setTipoUsuario(tpUser);
        Usuario u2 = new Usuario("Marcela", "654321", "marcela@email.com");
        u2.setTipoUsuario(tpUser);
        Usuario u3 = new Usuario("João", "135246", "joao@email.com");
        u3.setTipoUsuario(tpUser);
        em.getTransaction().begin();
        em.persist(tpUser);
        em.persist(u1);
        em.persist(u2);
        em.persist(u3);
        em.getTransaction().commit();
        em.close();
    }
}
