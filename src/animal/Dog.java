package animal;

public class Dog extends Canine implements Pet{

    public Dog(){
        System.out.println("Dog without name");
    }

    public Dog(String name) {
        // Constructor call must be the first statement in a constructorJava(1207959691)
        //System.out.println("");
        super(name);
        System.out.println("dog is " + name);
    }

    @Override
    public void beFriendly() {
        System.out.println("Dog is Friendly");
    }

    @Override
    public void play() {
       System.out.println("Dog is playing");
    }
    
}
