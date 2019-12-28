package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

//import com.carrotsearch.junitbenchmarks.BenchmarkOptions;


public class JMHTest {
	Long id1;
	Long id2;
	
	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@Test
	public void test1(){
		Student s = new Student();
		StudentProvider sp = new StudentProvider();
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
         EntityManager em = factory.createEntityManager();
         
         em.getTransaction().begin();
 		
         for(int i=0;i<10000;i++) {
        	 s = sp.provideOneStudent();
        	 em.persist(s);
        	 if (i==0) id1 = s.getId();
         }
         
         em.getTransaction().commit();
         em.close(); // sesion end
  	
	}
	
	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@Test
	public void test2(){
		Student s = new Student();
		StudentProvider sp = new StudentProvider();
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
         EntityManager em = factory.createEntityManager();
         
         		
         for(int i=0;i<10000;i++) {
        	 em.getTransaction().begin();
        	 s = sp.provideOneStudent();
        	 em.persist(s);
        	 em.getTransaction().commit();
        	 
         }
         
         em.close(); // sesion end
         
        
         
  	
	}
	
	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@Test
	public void test3(){
		JMHJoinStudent s = new JMHJoinStudent();
		StudentProvider sp = new StudentProvider();
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
         EntityManager em = factory.createEntityManager();
         
         em.getTransaction().begin();
 		
         for(int i=0;i<10000;i++) {
        	 s = sp.provideOneStudentJoin();
        	 em.persist(s);
         }
         
         em.getTransaction().commit();
         em.close(); // sesion end
  	
	}
	
	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@Test
	public void test4(){
		JMHJoinStudent s = new JMHJoinStudent();
		StudentProvider sp = new StudentProvider();
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
         EntityManager em = factory.createEntityManager();
         
         		
         for(int i=0;i<10000;i++) {
        	 em.getTransaction().begin();
        	 s = sp.provideOneStudentJoin();
        	 em.persist(s);
        	 em.getTransaction().commit();
        	 
         }
         id2 = s.getId();
         em.close(); // sesion end

	}
	
	
}
