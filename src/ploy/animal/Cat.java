package ploy.animal;

public class Cat extends Feline implements Pet{

    @Override
    public void beFriendly() {
        System.out.println("Cat is Friendly");
        
    }

    @Override
    public void play() {
        System.out.println("Cat is playing");
    }

    
    
}
