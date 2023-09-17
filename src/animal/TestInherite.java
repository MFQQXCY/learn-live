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

        tsetConstructor();

        testAbstructConstructor();


    }


    public static void  testCast(){
        Animal a = new Cat();
        System.out.println(a.getClass()+"------"+a.toString());
        Cat c = new Cat();
        System.out.println(c.getClass()+"------"+c.toString());
        Animal b = c;
        System.out.println(b.getClass()+"------"+b.toString());


    }

    /**
     * 当父类的实例变量是私有的，提供一个public set方法来设置这个私有的实例变量
     * 那么当这个子类在创建对象时，在堆中的这个子类对象是否有这个实例变量呢？
     * 
     * 
     * 换句话说，子类对象在创建后，在堆中的这个子类对象是否会为父类的所有（包括私有）实例变量分配空间呢？
     */
    public static void tsetConstructor(){
        Feline f = new Feline();
        f.setName("animal");
        System.out.println(f);
    }

    /**
     *  抽象类有构造函数，当子类创建对象时，先执行父类的构造方法
     */
    public static void testAbstructConstructor(){
        Dog a = new Dog("jingdong");
        Dog b = new Dog();
    }

    
}
