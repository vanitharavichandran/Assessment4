package test;
class Manager extends Thread
{
	StringBuffer s;
	Manager()
	{
		s = new StringBuffer();
	}
	public void run()
	{
		synchronized(s)
		{
			for(int i=0;i<=20;i++)
			{
				s.append(i+", ");
			}
			s.notify();
			System.out.println("Manager notifying Employee to start working");
		}
	}
}
class Employee extends Thread
{
	Manager mgr;
	Employee(Manager mgr)
	{
		this.mgr = mgr;
	}
	public void run()
	{
		synchronized(mgr.s)
		{
			try
			{
				System.out.println("Employee is waiting for Manager to notify the Message");
				mgr.s.wait();
			}
			catch(InterruptedException ie)
			{
			}
			System.out.println(mgr.s);
		}
	}
}
class ThreadEx 
{
	public static void main(String... args)
	{
		Manager mgr = new Manager();
		Employee emp = new Employee(mgr);
		Thread t1 = new Thread(mgr);
		Thread t2 = new Thread(emp);
		t2.start();
		t1.start();
	}
}
