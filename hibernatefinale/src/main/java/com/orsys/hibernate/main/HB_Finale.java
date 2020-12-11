package com.orsys.hibernate.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.orsys.hibernate.model.Etudiant;
import com.orsys.hibernate.model.Note;
import com.orsys.hibernate.util.HibernateUtil;


public class HB_Finale {
	@SuppressWarnings("unchecked")

public static void main(String[] args)
{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction tx = session.beginTransaction();
	Query query ;
Note n=new Note();
n.setMoyenne(15);

Etudiant et=new Etudiant();
et.setFirstname("adan");
et.setLastname("teste");
n.setId(2);
et.setId(2);
et.setNote(n);
n.setEtudiant(et);
	try
{
session.save(n);	
session.save(et);

session.getTransaction().commit();
//sessionFactory.close();
}
catch(Exception ex)
{
	System.out.println(ex);

}
/* query= session.createQuery("from Employee");
	Query query = session.createQuery("from Employee");
	List<Employee> empList = query.list();
	for(Employee emp : empList){
		System.out.println("List of Employees::"+emp.getId()+","+emp.getName()+","+emp.getAddress().getCity());
	}
	
	
	query = session.createQuery("from Employee where id= :id");
	query.setLong("id", 1);
	Employee emp = (Employee) query.uniqueResult(); // on récupére une seule ligne 
	System.out.println("Employée ="+emp.getName()+", Cité="+emp.getAddress().getCity()); // accés directe

	
	query = session.createQuery("update Employee set name= :name where id= :id");
	query.setParameter("name", "Khalil Lakhdhar");
	query.setLong("id", 1);
	int result = query.executeUpdate();
	System.out.println("Employee mis à jour="+result);
	
	
	
	query = session.createQuery("delete from Address where id= :id");
	query.setLong("id", 4);
	 result = query.executeUpdate();
	System.out.println("Address supprimé="+result);
	query = session.createQuery("delete from Employee where id= :id");
	query.setLong("id", 4);
	result = query.executeUpdate();
	System.out.println("Employee supprimé Status="+result);
	
	query = session.createQuery("select sum(salary) from Employee");
	double sumSalary = (Double) query.uniqueResult();
	System.out.println("Sum of all Salaries= "+sumSalary);
	
	query = session.createQuery("select e.name, a.city from Employee e "
			+ "INNER JOIN e.address a");
	List<Object[]> list = query.list();
	for(Object[] arr : list){
		System.out.println(Arrays.toString(arr));
		
	}	*/
	//tx.rollback();
	sessionFactory.close();

}
}
