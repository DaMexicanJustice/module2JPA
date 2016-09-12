/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creator;

import entity.Person;
import entitymanager.PersonCreator;
import entitymanager.PersonDeleter;
import entitymanager.PersonFinder;
import entitymanager.PersonUpdater;
import javax.persistence.Persistence;

/**
 *
 * @author xboxm
 */
public class Creator {
    
    public static void main(String[] args) {
        // Create database
        Persistence.generateSchema("JPADemo1PU", null);
        
        // Create an entity and insert into table
        PersonCreator cp = new PersonCreator();
        Person person = cp.createNew("Patrick", 25);
        cp.persist(person);
        cp.persist(cp.createNew("Imposter", 1));
        
        
        // Update an existing entity in table
        PersonUpdater up = new PersonUpdater();
        up.update(person.getId(), "DaMexicanJutice", 25);
        
        // Lookup a person in the table 
        PersonFinder pf = new PersonFinder();
        Person foundPerson = pf.findPerson(person.getId());
        System.out.println("Found: " + foundPerson.getId() + ":" + foundPerson.getName() + "," + foundPerson.getAge());
        
        // Delete a person from the table
        PersonDeleter pd = new PersonDeleter();
        boolean deleted = pd.deletePerson(foundPerson.getId());
        System.out.println("Did we delete?" + deleted);
    }
    
}
