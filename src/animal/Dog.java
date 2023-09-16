package animal;

public class Dog extends Canine implements Pet{

    @Override
    public void beFriendly() {
        System.out.println("Dog is Friendly");
    }

    @Override
    public void play() {
       System.out.println("Dog is playing");
    }
    
}
