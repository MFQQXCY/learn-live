package generic;

public class Animal {
    void eat(){
        System.out.println("annimal eat...");
    }

    @Override
    public String toString() {
        return "Animal []";
    }


}

class Dog extends Animal{
    void bark(){}

    @Override
    public String toString() {
        return "Dog []";
    }

    
}
class Cat extends Animal{
    void bark(){}

    @Override
    public String toString() {
        return "Cat []";
    }

    
}
