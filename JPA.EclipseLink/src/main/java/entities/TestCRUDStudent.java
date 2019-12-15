package entities;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

public class TestCRUDStudent {
	private Long id_st;
	
	@Test
    public void test1() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        
        Student s = new Student("Test student",new Date(85,3,5), 5.5f); // transient
        em.persist(s);
        
        s = em.find(Student.class,s.getId());
        id_st = s.getId();
        System.out.println(id_st);
        
        em.getTransaction().commit();
        em.close(); // sesion end
        System.out.println("1 "+id_st);
    }
	
	@Test
    public void test2() {
		 System.out.println("2 "+id_st);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        
        System.out.println("3 "+id_st);
        Student s = em.find(Student.class,id_st);
        s.setMark(10f);
        em.persist(s);
        
        em.getTransaction().commit();
        em.close(); // sesion end
    }
	
	@Test
    public void test3() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        
        System.out.println("----"+id_st);
        Student s = em.find(Student.class,id_st);
        em.remove(s);
        
        em.getTransaction().commit();
        em.close(); // sesion end
    }
}
