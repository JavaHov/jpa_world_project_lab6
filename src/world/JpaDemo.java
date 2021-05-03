
package world;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import world.domain.City;
import world.domain.Country;


public class JpaDemo {
    
    
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        

        boolean loop = true;
        
        while(loop) {
            
            String name = null;
            
            System.out.println("-------------------");
            System.out.println("1. Find City");
            System.out.println("2. Find Country");
            System.out.println("0. Exit");
            System.out.println("-------------------");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice) {
                
                case 0:
                    System.out.println("Exiting...");
                    loop = false;
                    break;
                case 1:
                    System.out.println("Name of City:");
                    name = scanner.nextLine();
                    findCity(name);
                    break;
                case 2:
                    System.out.println("Name of Country:");
                    name = scanner.nextLine();
                    findCountry(name);
                    break;
                default:
                    System.out.println("No such option, try again.");
                    break;
            }
            
        }
    }
    
    
    
    public static void findCity(String name) {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<City> query = em.createQuery("SELECT c FROM City c WHERE c.name=:name", City.class);
        query.setParameter("name", name);
        
        List<City> cities = query.getResultList();
        
        System.out.format("Found %d matches for %s:\n", cities.size(), name);
        cities.forEach(c -> System.out.println(c + " located in " + c.getCountry().getName()));
        
        
        em.close();
    }
    
    public static void findCountry(String name)  {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c WHERE c.name=:name", Country.class);
        query.setParameter("name", name);
        //Country country = query.getSingleResult();
        
        try {
            Country country = query.getSingleResult();
                System.out.println("Found:");
                System.out.println(country.getName() + " Capital: " + country.getCapital().getName());
                System.out.println("Cities in " + country.getName() + ":");
                
                country.getCities().stream().map(c -> c.getName()).forEach(System.out::println);
        }
        catch(NoResultException e) {
            
            System.out.println("No result...");
        }
    }
    
}
