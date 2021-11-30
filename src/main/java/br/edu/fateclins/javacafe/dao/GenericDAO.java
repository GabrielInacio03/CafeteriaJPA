package br.edu.fateclins.javacafe.dao;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class GenericDAO<T> {

    public GenericDAO() {

    }

    public String add(T obj) {
        try {
            EntityManager em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            em.close();
            return "Inserido com sucesso!";
        } catch (Exception ex) {
            return "add: " + ex.getMessage();
        }
    }

    public String update(T obj) {
        try {
            EntityManager em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            em.close();
            return "Atualizado com sucesso!";
        } catch (Exception ex) {
            return "update " + ex.getMessage();
        }
    }

    public String delete(T obj) {
        try {
            EntityManager em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            obj = em.merge(obj);
            em.remove(obj);
            em.getTransaction().commit();
            em.close();
            return "Removido com sucesso!";
        } catch (Exception ex) {
            return "delete " + ex.getMessage();
        }
    }

    public abstract T procurarPorId(Integer id);

    public abstract List<T> listarTodos();

    public abstract String salvar(T obj);

}
