package animal;

import java.util.ArrayList;
import java.util.List;

public class Animal {
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
}
