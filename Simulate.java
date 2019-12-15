import java.io.*;
import java.util.Scanner;

public class Simulate {
	
	static int meanServiceTime;
	static int meanInterarrivalTime;
	static SimulateServer[] servers;
	static SimulateClient[] clients;
	static Queue queue = new ArrayQueue();
	static java.util.Random randomArrival;
	static java.util.Random randomService;
	public static int currentTime=0;
	//static int numServer,numClient;
	
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		//System.out.print("Enter number of server: ");
		//numServer=input.nextInt();
		//System.out.print("Enter number of client: ");
		//numClient=input.nextInt();
		System.out.print("Question 1 or 2?: ");
		int question=input.nextInt();
		
		if(question==1)
			init1();
		else if(question==2)
			init2();
	}
	
	public static void init1() {
		
	    meanServiceTime = 120 + (int)(Math.random()*480);
		meanInterarrivalTime = 30 + (int)(Math.random()*15);
		
	    servers = new SimulateServer[10];
	    clients = new SimulateClient[100];
	    
	    randomService = new ExponentialRandom(meanServiceTime);
	    randomArrival = new ExponentialRandom(meanInterarrivalTime);
	    queue = new ArrayQueue();

	   
	      System.out.println("Number of counter = " + 10); 
	      System.out.println("Number of customer = " + 100); 
	      System.out.println("Mean service time = " + (int)meanServiceTime); 
	      System.out.println("Mean interval time = " + (int)meanInterarrivalTime); 
	      System.out.println();
	      
	      for (int j=0; j<10; j++) 
	 		 servers[j] = new SimulateServer(j);
	      
	     for(int i=0;i<100;i++) {
	    	 for (int j=0; j<10; j++) {
		    	if(i<100) {
		    		clients[i]=new SimulateClient(i,(int)System.currentTimeMillis());
		    		servers[j].startServing(clients[i], randomService.nextInt());
		    		System.out.println("Mean service time for " + servers[j] + " = "+ servers[j].getMeanServiceTime());
		    		System.out.println();
		    		i+=1;
		    	}
		    	
		      }
	     }	      
	}
	
	public static void init2(){
		
		meanServiceTime = 120 + (int)(Math.random()*480);
		meanInterarrivalTime = 30 + (int)(Math.random()*15);
		
	    servers = new SimulateServer[5];
	    clients = new SimulateClient[50];
	    
	    randomService = new ExponentialRandom(meanServiceTime);
	    randomArrival = new ExponentialRandom(meanInterarrivalTime);
	    queue = new ArrayQueue();

	   
	      System.out.println("Number of counter = " + 5); 
	      System.out.println("Number of customer = " + 50); 
	      System.out.println("Mean service time = " + (int)meanServiceTime); 
	      System.out.println("Mean interval time = " + (int)meanInterarrivalTime); 
	      System.out.println();
	      
	      for (int j=0; j<5; j++) 
	 		 servers[j] = new SimulateServer(j);
	      
	     for(int i=0;i<50;i++) {
	    	 for (int j=0; j<5; j++) {
		    	if(i<50) {
		    		clients[i]=new SimulateClient(i,(int)System.currentTimeMillis());
		    		servers[j].startServing(clients[i], randomService.nextInt());
		    		System.out.println("Mean service time for " + servers[j] + " = "+ servers[j].getMeanServiceTime());
		    		System.out.println();
		    		i+=1;
		    	}
		    	
		      }
	     }
	}
}
