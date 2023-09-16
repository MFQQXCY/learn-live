package animal;

public class TestInherite {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.eat();


        Feline b = new Cat();
        b.eat();

        Cat c = new Cat();
        c.eat();

        testCast();


    }


    public static void  testCast(){
        Animal a = new Cat();
        System.out.println(a.getClass()+"------"+a.toString());
        Cat c = new Cat();
        System.out.println(c.getClass()+"------"+c.toString());
        Animal b = c;
        System.out.println(b.getClass()+"------"+b.toString());


    }
    
}
