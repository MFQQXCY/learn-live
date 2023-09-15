package game.real;

import java.util.ArrayList;

/**
 * 需要被击沉的StartUp对象
 * 有名字，位置，以及检查是否被击沉
 */
public class StartUp {
    public String name;

    public StartUp(String name) {
        this.name = name;
    }


    private ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public String checkYourself(String guess) {
        String result = "miss";
        int index = locationCells.indexOf(guess);
        if(index >= 0){
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " : ( ");
            }else{
                result = "hit";
            }
        }
        return result;
    
      }
    

    


}
