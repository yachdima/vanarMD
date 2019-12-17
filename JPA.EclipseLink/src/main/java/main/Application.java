package main;



import java.sql.Date;

import javax.persistence.EntityManager;
   import javax.persistence.EntityManagerFactory;
   import javax.persistence.Persistence;

import entities.MasterStudent;
import entities.Performance;
import entities.Student;

   public class Application {
       public static void main(String[] args) {
          // check();
    	 //  uninstall();
         //  install();
    	   testStudent();
//           addOneStudent(new Student(567L, "fullname3"));
//           Student s = findOneStudent(123L);
//           System.out.println(s.toString());
       }
       
       public static void testStudent(){
    	   Performance per = new Performance(5.5f,40,50,Performance.Behaviour.GOOD);
    	   Student s = new Student("First student",new Date(80,11,1), 9.5f,per); // transient
    	   MasterStudent s1 = new MasterStudent("MMMMFirst student",new Date(80,11,1), 9.5f,per,MasterStudent.DegreeLevel.NOOB); // transient
    	  // Student s;
    	   
    	   EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database"); // session start
           EntityManager em = factory.createEntityManager();
           
           em.getTransaction().begin();
   		
           // C
           em.persist(s1); // save -> //  persistent
           
           // R
        //   s = em.find(Student.class,1L);
       //    System.out.println(s);
           
           // U + transient / dirty
          // s.setDob(new Date(80,10,1));
          // em.persist(s);
           
           // D
       //   em.remove(s);
           
           em.getTransaction().commit();
           em.close(); // sesion end
    	   
    	   
    	   
       }
       
       public static void check() {
    	   EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database");
           EntityManager em = factory.createEntityManager();
           
           em.getTransaction().begin();
   		
           em.getTransaction().commit();
           em.close();
       }
       
       public static void install() {
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database");
           EntityManager em = factory.createEntityManager();
           
           em.getTransaction().begin();

           em
             .createNativeQuery("CREATE TABLE public.students ( 	id serial NOT NULL, 	fullname varchar(30) NULL, 	dob date NULL, 	mark numeric NULL, 	CONSTRAINT students_pkey PRIMARY KEY (id) );")
             .executeUpdate();

           em.getTransaction().commit();
           
       }
       
       public static void uninstall() {
    	   EntityManagerFactory factory = Persistence.createEntityManagerFactory("hb-database");
           EntityManager em = factory.createEntityManager();
           
           em.getTransaction().begin();

           em
             .createNativeQuery("DROP TABLE public.students;")
             .executeUpdate();

           em.getTransaction().commit();
       }
       
       public static void addOneStudent(Student s) {
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("sqlite-database");
           EntityManager em = factory.createEntityManager();
           
           em.getTransaction().begin();

           em.persist(s);

           em.getTransaction().commit();
       }
       
       public static Student findOneStudent(Long id) {
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("sqlite-database");
           EntityManager em = factory.createEntityManager();
           
           em.getTransaction().begin();

           Student s = em.find(Student.class,id);

           em.getTransaction().commit();
           return s;
       }
   }