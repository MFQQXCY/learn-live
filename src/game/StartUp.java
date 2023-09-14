package game;

import java.util.ArrayList;

public class StartUp {
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
            }else{
                result = "hit";
            }
        }
        return result;
    
      }
    
}
