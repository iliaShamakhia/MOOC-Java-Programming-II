package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor(){
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }
            
    @Override
    public boolean isOn() {
        for(Sensor sens : sensors){
            if(!sens.isOn()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for(Sensor sens : sensors){
            sens.setOn();
        }
    }

    @Override
    public void setOff() {
        if(sensors.size() > 0){
            for(Sensor sens : sensors){
                sens.setOff();
            }
        }
    }

    @Override
    public int read() {
        if(!this.isOn() || sensors.size() == 0){
            throw new IllegalStateException();
        }else{
            int sum = 0;
            for(Sensor sens : sensors){
                sum += sens.read();
            }
            int average = sum / sensors.size();
            readings.add(average);
            return average;
        }
    }
    
    public void addSensor(Sensor toAdd){
        this.sensors.add(toAdd);
    }
    
    public List<Integer> readings(){
        return readings;
    }
    
}
