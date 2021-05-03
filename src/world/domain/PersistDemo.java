
package world.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PersistDemo {
    
    
    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        
        EntityManager em = factory.createEntityManager();
        
        Country JavaLand = new Country();
        City espresso = new City();
        espresso.setName("Espresso");
        
        
        em.getTransaction().begin();
        em.persist(JavaLand);
        JavaLand.setName("JavaLand");
        JavaLand.setCapital(espresso);
        JavaLand.setPopulation(1000000L);
        JavaLand.setCode("JAV");
        JavaLand.setContinent("South America");
        espresso.setPopulation(500000);
        espresso.setDistrict("Java-district");
        espresso.setCountry(JavaLand);
        JavaLand.setRegion("Java-Region");
        
        em.getTransaction().commit();
        em.close();
    }
}
