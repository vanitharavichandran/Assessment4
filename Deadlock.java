package test;

class Clg{
Object clg, dept;
Clg(Object clg, Object dept)
{
this.clg=clg;
this.dept=dept;
}
}
class Resource_1 extends Thread
{
	Clg c;
	Resource_1(Clg c)
	{
		this.c=c;
	}
	public void run()
	{
	synchronized(c.clg){
	System.out.println("New College");
	try{
		Thread.sleep(1000);
		}
	catch(Exception e){
		}
	synchronized(c.dept){
		System.out.println("New Department");
		}
	}
}
}
class Resource_2 extends Thread
{
	Clg c;
	Resource_2(Clg c)
	{
		this.c=c;
	}
	public void run()
	{
	synchronized(c.clg){
	System.out.println("College");
	try{
		Thread.sleep(1000);
		}
	catch (Exception e){}
		}
		synchronized(c.dept){
		System.out.println("Department");
		}
	}	
}

class DeadLock{
	public static void main(String... args)
	{
	    Object clg=new Object();
	    Object dept=new Object();
	    Clg c=new Clg(clg, dept);
	    Resource_1 r1=new Resource_1(c);
	    Resource_2 r2=new Resource_2(c);
	   Thread t1=new Thread(r1);
	   Thread t2=new Thread(r2);
	   t1.start();
	   t2.start();
	}
}