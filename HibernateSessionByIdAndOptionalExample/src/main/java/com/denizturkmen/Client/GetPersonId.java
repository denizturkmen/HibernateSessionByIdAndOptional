package com.denizturkmen.Client;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.denizturkmen.Entity.Person;
import com.denizturkmen.Util.HibernateUtil;

public class GetPersonId {

	public static void main(String[] args) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Person person = session.byId(Person.class).load(2L);
			if(person != null) {
				System.out.println(person.getId()+"  "+person.getName());
			}
			else {
				System.out.println("Person Yok");
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
}
