package virusSimulation;

public interface Virus {


    
    public boolean setProbability(double d);
    
    
    public double getProbability();


    public void setVirusName(String name);


    public double mutateToStrong();
    
    public double mutateToWeak();
}
