package ploy.animal;

import java.util.ArrayList;

public class Feline extends Animal{

    public Feline(){
    }

    @Override
    void eat() {
        super.eat();
        System.out.println("Feline eatting");
    }

    @Override
    ArrayList<String> testReturn(){
        ArrayList<String> a  = new ArrayList<>(null);
        return a;
    }

    @Override
    public String toString() {
        
        return super.toString() + "Feline []";
    }

    // @Override
    // void testArgs(Integer a){
    //     System.out.println(a+"");
    // }
    
}
