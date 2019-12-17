package entities;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

public class TestCRUDGroup {
private static Long id_gr;
	
	@Test
    public void test1() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        
        Groups s = new Groups("Test group"); // transient
        em.persist(s);
        
        s = em.find(Groups.class,s.getId());
        id_gr = s.getId();
        System.out.println(id_gr);
        
        em.getTransaction().commit();
        em.close(); // sesion end
        System.out.println("1 "+id_gr);
    }
	
	
	@Test
    public void test2() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        
        Groups s = em.find(Groups.class,id_gr);
        s.setName("Test2 Group");
        em.persist(s);
        
        em.getTransaction().commit();
        em.close(); // sesion end
    }
	
	@Test
    public void test3() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        
        Groups s = em.find(Groups.class,id_gr);
        em.remove(s);
        
        em.getTransaction().commit();
        em.close(); // sesion end
    }
}
