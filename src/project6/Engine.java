package project6;
public class Engine implements Cloneable{
    private static int c=0;
    private  int engineId=assignID();
    private String engineName,engineModel;
    private int assignID(){
        return ++c;
    }
    public void setEngineName(String engineName){
        this.engineName = engineName;
    }
    public String getEngineName(){
        return engineName;
    }
    public void setEngineModel(String engineModel){
        this.engineModel = engineModel;
    }
    public String getEngineModel(){
        return engineModel;
    }
    public int getEngineId(){
        return engineId;
    }
    public String toString(){
        return "Engine Name: "+engineName+"  Engine Model: "+engineModel+"  Engine ID: "+engineId;
    }
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    public boolean equals(Engine engine){
        return (engineName.equals(engine.getEngineName())&&engineModel.equals(engine.getEngineModel()));
    }  
}
