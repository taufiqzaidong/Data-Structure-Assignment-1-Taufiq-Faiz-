
public class SimulateServer extends Simulate {
	private Client client;
	private int id, meanServiceTime, stopTime=-1;
	private java.util.Random random;
  
  public SimulateServer(int id) {
	  this.id = id;
	  this.meanServiceTime = 120 + (int)(Math.random()*480);
  }
  public SimulateServer(int id, int meanServiceTime) {
    this.id = id;
    this.meanServiceTime = meanServiceTime;
    this.random = new ExponentialRandom(meanServiceTime);
  }
  
  public int getMeanServiceTime() {
    return meanServiceTime;
  }
  
  public int getStopTime() {
    return stopTime;
  }
  
  public boolean isIdle() {
    return client==null; 
    }

  public void startServing(Client client, int t) {
    this.client = client;
    this.stopTime = currentTime+ getMeanServiceTime();
    System.out.println(this + " started serving " + client + " at time " + currentTime + " and will finish at time " + stopTime);
    currentTime=stopTime;
    }    
  
  public void stopServing(int t) {
    client.setStopTime(t);
    System.out.println(this + " stopped serving " + client + " at time " + t);
    client = null;
  	}
  
  public String toString() {
    String s="ABCDEFGHIJ";

    return "Counter " + s.charAt(id);
    }
}
