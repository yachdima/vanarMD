package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

public class TestCRUDFaculty {
private static Long id_f;
	
	@Test
    public void test1() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        
        Faculty s = new Faculty("Test Faculty"); // transient
        em.persist(s);
        
        s = em.find(Faculty.class,s.getId());
        id_f = s.getId();
        System.out.println(id_f);
        
        em.getTransaction().commit();
        em.close(); // sesion end
        System.out.println("1 "+id_f);
    }
	
	
	@Test
    public void test2() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        
        Faculty s = em.find(Faculty.class,id_f);
        s.setName("Test2 Faculty");
        em.persist(s);
        
        em.getTransaction().commit();
        em.close(); // sesion end
    }
	
	@Test
    public void test3() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        
        Faculty s = em.find(Faculty.class,id_f);
        em.remove(s);
        
        em.getTransaction().commit();
        em.close(); // sesion end
    }

}
