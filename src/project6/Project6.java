package project6;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
public class Project6 { 
    public static void main(String[] args) {
       
        Scanner sc=new Scanner(System.in);
        MainProgram mainprogram=new MainProgram();
        ArrayList<String>infoFromFile=mainprogram.readFile("C:\\Users\\LENOVO\\OneDrive - Arab American University\\سطح المكتب\\Extra\\javapro2\\eDevices.txt");
        int eDevice=0;
        while(true){
            System.out.print("***Choose a way to get eDevice info***\n1.from user\n2.from a File\nEnter your choice: ");
            int choice=Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:{
                    System.out.print("Enter Number Of eDevices: ");
                    int n=Integer.parseInt(sc.nextLine());
                    mainprogram.creatEDevices(n);
                }break;
                case 2:{
                    String info[]=infoFromFile.get(eDevice++).split(" ");
                    if(info.length==6){
                        String date[]=info[2].split("-");
                        MobilePhone m=new MobilePhone(info[0],Double.parseDouble(info[1]),LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])),info[3],Integer.parseInt(info[4]),Double.parseDouble(info[5]));
                        mainprogram.addeDevice(m);
                    }
                    else if(info.length==7){
                        String date[]=info[2].split("-");
                        Engine engine=new Engine();
                        engine.setEngineName(info[5]);
                        engine.setEngineModel(info[6]);
                        SmartFridge s=new SmartFridge(info[0], Double.parseDouble(info[1]), LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])), Integer.parseInt(info[3]), Integer.parseInt(info[4]), engine);
                        mainprogram.addeDevice(s);
                    }
                }break;
                case 3:{
                    mainprogram.printContent(mainprogram.getElectronicDevices());
                    mainprogram.saveFile(mainprogram.getElectronicDevices(), "C:\\Users\\LENOVO\\OneDrive - Arab American University\\سطح المكتب\\Extra\\javapro2\\eDevicesSpecifications.txt");
                    sc.close();
                    System.exit(0);
                }break;
            }
    }
}
}
