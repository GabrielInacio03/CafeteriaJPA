/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fateclins.javacafe.dao;

import br.edu.fateclins.javacafe.modelo.TipoUsuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author apazi
 */
public class TipoUsuarioDAO extends GenericDAO<TipoUsuario> {

    @Override
    public TipoUsuario procurarPorId(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        TipoUsuario obj = null;
        try {
            Query q = em.createQuery("select t from TipoUsuario t where t.id =:id", TipoUsuario.class);
            q.setParameter("id", id);
            obj = (TipoUsuario) q.getSingleResult();
            em.close();
            return obj;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }

    @Override
    public List<TipoUsuario> listarTodos() {
        try {
            EntityManager em = JPAUtil.getEntityManager();
            Query q = em.createQuery("select t from TipoUsuario t", TipoUsuario.class);
            List<TipoUsuario> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }

    @Override
    public String salvar(TipoUsuario obj) {
        if (procurarPorId(obj.getId()) == null) {
            return this.add(obj);
        } else {
            return this.update(obj);
        }
    }

}
