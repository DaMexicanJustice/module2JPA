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
public class PersonHandler {
    
    private Person person;
    
    public PersonHandler() {
    
    }
    
    public Person createNew(String name, int age) {
         person = new Person();
         person.setName(name);
         person.setAge(age);
         return person;
    }
    
    public void persist(Person person) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADemo1PU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        person.setName(person.getName());
        person.setAge(person.getAge());

        entitymanager.persist(person);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
    }
    
    public boolean deletePerson(int id) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPADemo1PU" );
      EntityManager entitymanager = emfactory.createEntityManager( );
      entitymanager.getTransaction( ).begin( );
      
      Person person = entitymanager.find( Person.class, id );
      entitymanager.remove( person );
      entitymanager.getTransaction( ).commit( );
      entitymanager.close( );
      emfactory.close( );
      return person != null;
    }
    
    public Person findPerson(int id) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADemo1PU");
        EntityManager entitymanager = emfactory.createEntityManager();
        Person foundPerson = entitymanager.find(Person.class, id);
        return foundPerson;
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
