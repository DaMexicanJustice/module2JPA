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
public class PersonCreator {
    
    Person person;
    
    public PersonCreator() {
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
}
