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
public class PersonDeleter {
    
    public PersonDeleter() {
    
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
    
}
