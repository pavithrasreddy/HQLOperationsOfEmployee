package com.edu;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainAPP {

	public static void main(String[] args) {
		Configuration con=new Configuration().configure().addAnnotatedClass(EmployeeHQL.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
	/*	EmployeeHQL e1=new EmployeeHQL(1,"shipra",4576,"Bokaro",100);
		ses.save(e1);
	    EmployeeHQL e2=new EmployeeHQL(2,"Pavithra",4506,"Bangalore",100);
		ses.save(e2);
		EmployeeHQL e3=new EmployeeHQL(3,"Chaithra",4006,"Mangalore",100);
		ses.save(e3);
		EmployeeHQL e4=new EmployeeHQL(4,"Rajesh",4500,"Chennai",100);
		ses.save(e4);
		EmployeeHQL e5=new EmployeeHQL(5,"Lokesh",4555,"Kolkata",100);
		ses.save(e5);
		tx.commit(); 
*/
		/*
		//get record based on id
		   EmployeeHQL r=(EmployeeHQL) ses.get(EmployeeHQL.class,2);
		             
		   System.out.println(r); //it calls toString method
		   
		   System.out.println();
		System.out.println("emp id="+r.getEid()+" name="+r.getEname()+" Salary="+r.getEsalary()+" address="+r.getAddress()+" deptno="+r.getDeptno());
           
		*/
		
	/*	//Retrieve all records
		Query q=ses.createQuery("from EmployeeHQL");  //select * from tablename
		 
		//from nameoftheclass
           
        List l=q.list();  
        System.out.println(l);
        Iterator<EmployeeHQL> it=l.iterator();
        while(it.hasNext()) {
     	 EmployeeHQL r=it.next();
    System.out.println("emp id="+r.getEid()+" name="+r.getEname()+" Salary="+r.getEsalary()+" address="+r.getAddress()+" deptno="+r.getDeptno());
     	
        }
	*/	
		//update record change name
	/*Query q=ses.createQuery("update EmployeeHQL set ename=:n where eid=:i");
		q.setParameter("n", "Prashanth");
		q.setParameter("i", 4);
		
		int i=q.executeUpdate();
		if(i>0) {
			System.out.println("Record is updated");
		}
		else {
			 System.out.println("Not updated");
		}
	*/
		
	/* Query d=ses.createQuery("delete from EmployeeHQL where eid=:i");
				d.setParameter("i", 5);
			int i=d.executeUpdate();
			if(i>0) {
				System.out.println("Record is deleted");
			}
			else {
				 System.out.println("Not deleted");
			}
	*/	
		//sum,max,min,avg
	/*	Query s=ses.createQuery("select sum(esalary) from EmployeeHQL");
		List sl=s.list();
		System.out.println("Total sal="+sl.get(0));
	*/
		Query s1=ses.createQuery("select min(esalary) from EmployeeHQL");
		List sl1=s1.list();
		System.out.println("Minimum sal="+sl1.get(0));
		
		Query s2=ses.createQuery("select avg(esalary) from EmployeeHQL");
		List sl2=s2.list();
		System.out.println("Average sal="+sl2.get(0));
		//total number of employees
		Query s3=ses.createQuery("select count(eid) from EmployeeHQL");
		List sl3=s3.list();
		System.out.println("Total number of employees="+sl3.get(0));
        tx.commit();
         ses.close();
        
	}
}