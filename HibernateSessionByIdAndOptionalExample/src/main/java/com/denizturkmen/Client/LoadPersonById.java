package com.denizturkmen.Client;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.denizturkmen.Entity.Person;
import com.denizturkmen.Util.HibernateUtil;

public class LoadPersonById {

	public static void main(String[] args) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			long personId=1L;
			
			Optional<Person> optional = session.byId(Person.class).loadOptional(personId);
			//değer vara true yoksa false döndürür
			if(optional.isPresent()) {
				Person person = optional.get();
				System.out.println(person.getId()+"  "+ person.getName());
			}
			else {
				System.out.println("Person yok");
			}
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
