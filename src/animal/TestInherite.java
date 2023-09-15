package animal;

public class TestInherite {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.eat();


        Feline b = new Cat();
        b.eat();

        Cat c = new Cat();
        c.eat();
    }
    
}
