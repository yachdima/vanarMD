package main;

   import javax.persistence.EntityManager;
   import javax.persistence.EntityManagerFactory;
   import javax.persistence.Persistence;

   import entities.Student;

   public class Application {
       public static void main(String[] args) {
           check();
          // install();
           addOneStudent(new Student(567L, "fullname3"));
           Student s = findOneStudent(123L);
           System.out.println(s.toString());
       }
       
       public static void check() {
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("sqlite-database");
           EntityManager em = factory.createEntityManager();
       }
       
       public static void install() {
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("sqlite-database");
           EntityManager em = factory.createEntityManager();
           
           em.getTransaction().begin();

           em
             .createNativeQuery("Create table Student(id INTEGER PRIMARY KEY, fullName VARCHAR(30));")
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