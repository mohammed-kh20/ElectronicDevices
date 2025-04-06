package project6;
import java.time.LocalDate;
public class MobilePhone extends Electronic_Device implements Cloneable,Comparable<MobilePhone>{
    private static int totalMobilePhonesinstantiated=0;
    private String osType;
    private int ramSize;
    private double cpuSpeed;
    public MobilePhone(String name, double price,LocalDate dateOfManufacturing,String osType,int ramSize,double cpuSpeed){
        super(name,price,dateOfManufacturing);
        this.osType=osType;
        this.ramSize=ramSize;
        this.cpuSpeed=cpuSpeed;
        totalMobilePhonesinstantiated++;
    }
    public void setOsType(String osType){
        this.osType=osType;
    }
    public String getOsType(){
        return osType;
    }
    public void setRamSize(int ramSize){
        this.ramSize=ramSize;
    }
    public int getRamSize(){
        return ramSize;
    }
    public void setCpuSpeed(double cpuSpeed){
        this.cpuSpeed=cpuSpeed;
    }
    public double getCpuSpeed(){
        return cpuSpeed;
    }
    public int getTotalMobilesMade(){
        return totalMobilePhonesinstantiated;
    }
    public int compareTo(MobilePhone other){
        return Double.compare(getPrice(), other.getPrice());
    }
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    public boolean equals(MobilePhone other){
        return osType.equals(other.osType)&&ramSize==other.ramSize&&cpuSpeed==other.cpuSpeed;
    }
    @Override
    public String toString(){
        return "Name: "+getName()+"  Price: "+getPrice()+"  DateOfManufacutring: "+getDateOfManufacturing()+"  ID: "+getEDeviceID()+"  OS Type: "+osType+"  RAM Size: "+ramSize+"  CPU Speed: "+cpuSpeed;
    }
    @Override
    public String getDeviceSpecifications(){
        return "OS Type: "+osType+"\nRAM Size: "+ramSize+"\nCPU Speed: "+cpuSpeed;
    }
}
