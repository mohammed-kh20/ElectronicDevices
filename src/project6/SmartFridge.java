package project6;
import java.time.LocalDate;
public class SmartFridge extends Electronic_Device implements Cloneable{
    private static int totalFridgesMade=0;
    private int capacity;
    private int noOfDoors;
    private Engine engine;
    public SmartFridge(String name, double price,LocalDate dateOfManufacturing,int capacity,int noOfDoors,Engine engine){
        super(name,price,dateOfManufacturing);
        this.capacity=capacity;
        this.noOfDoors=noOfDoors;
        this.engine=engine;
        totalFridgesMade++;
    }
    public void setCapacity(int capacity){
        this.capacity=capacity;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setNoOfDoors(int noOfDoors){
        this.noOfDoors=noOfDoors;
    }
    public int getNoOfDoors(){
        return noOfDoors;
    }
    public void setEngine(String engineName,String engineModel){
        this.engine.setEngineName(engineName);
        this.engine.setEngineModel(engineModel);
    }
    public Engine getEngine(){
        return engine;
    }
    public int getTotalFridgesMade(){
        return totalFridgesMade;
    }
    public SmartFridge getFridgeWithMaxCapacity(SmartFridge ...fridges){
        int max=Integer.MIN_VALUE;
        SmartFridge maxFridge=null;
        for(int i=0;i<fridges.length;i++){
            if(fridges[i].getCapacity()>max){
                max=fridges[i].getCapacity();
                maxFridge=fridges[i];
            }
        }
        return maxFridge;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        ((SmartFridge)super.clone()).engine=(Engine)getEngine().clone();
        return super.clone();
    }
    public boolean equals(SmartFridge fridge){
        return (getName().equals(fridge.getName())&&getPrice()==fridge.getPrice()&&getDateOfManufacturing().equals(fridge.getDateOfManufacturing())&&getCapacity()==fridge.getCapacity()&&getNoOfDoors()==fridge.getNoOfDoors()&&getEngine().equals(fridge.getEngine()));
    }
    @Override
    public String toString(){
        return "Name: "+getName()+"  Price: "+getPrice()+"  DateOfManufacutring: "+getDateOfManufacturing()+"  ID: "+getEDeviceID()+super.toString()+"  Capacity: "+capacity+"  Number of Doors: "+noOfDoors;
    }
    @Override
    public String getDeviceSpecifications(){
        return "Capacity: "+capacity+"\nNumber of Doors: "+noOfDoors;
    }
}
