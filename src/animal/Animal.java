package animal;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    private String name;

    public void setName(String name){
        this.name = name;
    }

    void eat(){
        System.out.println("animal eatting!");
    }


    List<String> testReturn(){
        List<String> a  = new ArrayList<>(null);
        return a;
    }

    void testArgs(int a){
        System.out.println(a+"");
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + "]";
    }

    
}
