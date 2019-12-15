
public class SimulateClient extends Simulate implements Client{
	int id, arrivalTime, startTime, stopTime;
	 
	public SimulateClient(int id, int t) {
	    this.id = id;
	    arrivalTime = Simulate.currentTime;
	    System.out.println(this + " arrived at time " + Simulate.currentTime);
	}
	
	  public int getStartTime() {
	    return startTime;  
	    }
	  
	  public int getStopTime() {
	    return stopTime;  
	    }
	  
	  public void setStartTime(int t) {
	    startTime = t; 
	    }
	  
	  public void setStopTime(int t) {
	    stopTime = t;  
	    }
	  
	  public String toString() {
	    return "Client " + (id+1);  
	  } 
}
