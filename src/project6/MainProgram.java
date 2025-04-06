package project6;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JOptionPane;
interface FileOperator{
    default<T>void printContent(ArrayList<T>t){}
    ArrayList<String>readFile(String  path);
    default  void saveFile(ArrayList<Electronic_Device>eDevices,String path){};
}
public class MainProgram implements FileOperator{
    private ArrayList<Electronic_Device>eDevices=new ArrayList<>();
    public void creatEDevices(int noOfDevices){
        for(int i=0;i<noOfDevices;i++){
            Scanner sc=new Scanner(System.in);
            System.out.print("What kind of devices you want?\n1.MobilePhone\n2.SmartFridge\nEnter your Choice:");
            int choice=Integer.parseInt(sc.nextLine());
            if(choice==1){
                System.out.print("Enter the MobilePhone Name: ");
                String Name=sc.nextLine();
                System.out.print("Enter the MobilePhone Price: ");
                double Price=Double.parseDouble(sc.nextLine());
                System.out.print("Enter the ManufacturingDate: ");
                String ManufacturingDate=sc.nextLine();
                String arr[]=ManufacturingDate.split(" ");
                LocalDate DateOfManufacturing=LocalDate.of(Integer.parseInt(arr[2]),Integer.parseInt(arr[1]),Integer.parseInt(arr[0]));
                System.out.print("Enter the OS Type: ");
                String OS=sc.nextLine();
                System.out.print("Enter the RAM SIZE: ");
                int RAM=Integer.parseInt(sc.nextLine());
                System.out.print("Enter the CPU SPEED: ");
                double CPUSpeed=Double.parseDouble(sc.nextLine());
                eDevices.add(new MobilePhone(Name, Price, DateOfManufacturing, OS, RAM, CPUSpeed));
            }
            else if(choice==2){
                System.out.print("Enter the SmartFridge Name: ");
                String Name=sc.nextLine();
                System.out.print("Enter the SmartFridge Price: ");
                double Price=Double.parseDouble(sc.nextLine());
                System.out.print("Enter the ManufacturingDate: ");
                String ManufacturingDate=sc.nextLine();
                String arr[]=ManufacturingDate.split(" ");
                LocalDate DateOfManufacturing=LocalDate.of(Integer.parseInt(arr[2]),Integer.parseInt(arr[1]),Integer.parseInt(arr[0]));
                System.out.print("Enter the SmartFridge Capacity: ");
                int Capacity=Integer.parseInt(sc.nextLine());
                System.out.print("Enter the noOFDoors: ");
                int noOfDoors=Integer.parseInt(sc.nextLine());
                System.out.println("***Enter the Engine Specifications***\nEnter the Engine Name: ");
                String EngineName=sc.nextLine();
                System.out.println("Enter the Engine Model: ");
                String EngineModel=sc.nextLine();
                Engine engine=new Engine();
                engine.setEngineName(EngineName);
                engine.setEngineModel(EngineModel);
                eDevices.add(new SmartFridge(Name, Price, DateOfManufacturing, Capacity, noOfDoors, engine));
            }
        }
    }
    public void addeDevice(Electronic_Device eDevice){
        eDevices.add((eDevice instanceof MobilePhone)?(MobilePhone)eDevice:(SmartFridge)eDevice);
    }
    /*private FileOperator fileoperator=(path)->{
        try{
            ArrayList<String>content=new ArrayList<>();
            Scanner sc=new Scanner(new File(path));
            while(sc.hasNext())
            content.add(sc.nextLine());
            sc.close();
            return content;
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    };*/
    //with Timer
    private FileOperator fileoperator=(path)->{
        try{
            ArrayList<String>content=new ArrayList<>();
            Scanner sc=new Scanner(new File(path));
            ActionListener al=(ActionEvent e)->{
                
                    if(!sc.hasNextLine()){
                        ((Timer)e.getSource()).stop();
                    }else{
                    System.out.println("Added");
                    content.add(sc.nextLine());
                    } 
            };
            Timer t=new Timer(1000, al);
            t.start();
            JOptionPane.showMessageDialog(null, "Press OK to stop");
            return content;
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    };
    @Override
    public ArrayList<String>readFile(String path){
        return fileoperator.readFile(path);
    }
    @Override
    public void saveFile(ArrayList<Electronic_Device>eDevices, String path){
        try{
        PrintWriter writeToFile=new PrintWriter(new FileWriter(path,false));
        for(Electronic_Device e:eDevices)
            writeToFile.println(e.toString());
        writeToFile.flush();
        writeToFile.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public <T>void printContent(ArrayList<T>t){
        for(T e:t)
            System.out.println(e.toString());
    }
    public int compareMobiles(MobilePhone m1,MobilePhone m2){
        return m1.compareTo(m2);
    }
    public MobilePhone cloneMobile(MobilePhone m) throws CloneNotSupportedException{
        return (MobilePhone)m.clone();
    }
    public SmartFridge cloneSmartFridge(SmartFridge s) throws CloneNotSupportedException{
        return (SmartFridge)s.clone();
    }
    public ArrayList<SmartFridge>getSmartFridges(ArrayList<Electronic_Device>eDevices){
        ArrayList<SmartFridge>smartFridges=new ArrayList<>();
        for(int i=0;i<eDevices.size();i++){
            if(eDevices.get(i) instanceof SmartFridge)
                smartFridges.add((SmartFridge)eDevices.get(i));
        }
        return smartFridges;
    }
    public int getNumberOfSmartFridges(ArrayList<Electronic_Device>eDevices){
        int count=0;
        for(int i=0;i<eDevices.size();i++)
        if(eDevices.get(i) instanceof SmartFridge)
        count++;
        return count;
    }
    public ArrayList<Electronic_Device>getElectronicDevices(){
        return eDevices;
    }
}
