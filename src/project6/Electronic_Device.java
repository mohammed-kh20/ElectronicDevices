package project6;
import java.time.LocalDate;
abstract class Electronic_Device{
    private static int totalNumberOfDevicesInstantiated=0;
    private String name;
    private double price;
    private LocalDate dateOfManufacturing;
    private int id;
    public Electronic_Device(String name, double price,LocalDate dateOfManufacturing){
        this.name=name;
        this.price=price;
        this.dateOfManufacturing=dateOfManufacturing;
        id=assignID();
    }
    private int assignID(){
        return ++totalNumberOfDevicesInstantiated;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public Double getPrice(){
        return price;
    }
    public void setDateOfManufacturing(LocalDate dateOfManufacturing){
        this.dateOfManufacturing=dateOfManufacturing;
    }
    public LocalDate getDateOfManufacturing(){
        return dateOfManufacturing;
    }
    public int getEDeviceID(){
        return id;
    }
    public int getTotalNumberOfEDevicesCreated(){
        return totalNumberOfDevicesInstantiated;
    }
    public String toString(){
        return "Name: "+name+"\tPrice: "+price+"\tDate of Manufacturing: "+dateOfManufacturing+"\tID: "+id;
    }
    public abstract String getDeviceSpecifications();
}