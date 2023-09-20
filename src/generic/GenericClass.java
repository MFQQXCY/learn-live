package generic;

import java.util.ArrayList;
import java.util.List;

import ploy.animal.Animal;
import ploy.animal.Dog;

public class GenericClass<E> {
    // 可以使用定义在类上的泛型
    public E e;


    // 此处使用泛型T是因为我们方法声明的开始声明了T。
    // 此处可以传ArrayList<Dog>, ArrayList<Animal>,ArrayList<Cat>等
    public <T extends Animal> void takeThings(ArrayList<T> things){}
     
    // 此处只可以传ArrayList<Animal>
    public void takeThingsTwo(ArrayList<Animal> thing){}

    public static void testGenerics(){
        // List<Animal> b = new ArrayList<Dog>();
        List<Animal> a = new ArrayList<Animal>();
        
        a.add(new Dog());
        
    }


}
