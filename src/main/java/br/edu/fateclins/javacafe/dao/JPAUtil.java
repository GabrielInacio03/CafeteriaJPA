package br.edu.fateclins.javacafe.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author apazi
 */
public class JPAUtil {
    private static final EntityManagerFactory emf;
    static{
        emf = Persistence.createEntityManagerFactory("cafe_fatec-PU");
    }
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
