/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creator;

import entity.Person;
import entitymanager.PersonHandler;
import javax.persistence.Persistence;

/**
 *
 * @author xboxm
 */
public class Creator {
    
    public static void main(String[] args) {
        // Create database
        Persistence.generateSchema("JPADemo1PU", null);
        
        /* Create a new handler that handles entities of type person using
         entity manager and factory */
        PersonHandler ph = new PersonHandler();
        
        // Create an entity and insert into table
        Person person = ph.createNew("Patrick", 25);
        ph.persist(person);
        ph.persist(ph.createNew("Imposter", 1));
        
        
        // Update an existing entity in table
        ph.update(person.getId(), "DaMexicanJutice", 25);
        
        // Lookup a person in the table 
        Person foundPerson = ph.findPerson(person.getId());
        System.out.println("Found: " + foundPerson.getId() + ":" + foundPerson.getName() + "," + foundPerson.getAge());
        
        // Delete a person from the table
        boolean deleted = ph.deletePerson(foundPerson.getId());
        System.out.println("Did we delete?" + deleted);
    }
    
}
