/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitymanager;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author xboxm
 */
public class PersonUpdater {

    public PersonUpdater() {
        
    }
    
    public void update(int id, String newname, int newage) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADemo1PU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        Person person = entitymanager.find(Person.class, id);
            System.out.println("Method returned null");
        
        try {
        //before update
        System.out.println(person);
        person.setName(newname);
        person.setAge(newage);
        entitymanager.getTransaction().commit();

        //after update
        System.out.println(person);
        entitymanager.close();
        emfactory.close();
        } catch (NullPointerException ex) {
            System.out.println("Method returned null." + ex.getMessage());
        }
    }
}
