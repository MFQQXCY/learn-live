package generic;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
    public void go() {

        List<Animal> as = new ArrayList<>();
        as.add(new Animal());
        as.add(new Animal());
        takeAnimals(as);
        System.out.println(as);

        // List<Dog> ds = List.of(new Dog(), new Dog());
        // takeAnimals(ds);


    }

    // 假设此处可以传，List<Dog>, 
    public void takeAnimals(List<Animal> annimals) {
        // 则此处就可以在原来的Dog列表中添加Cat元素
        // 此时就会出现风险。
        annimals.add(new Cat());
        for (Animal animal : annimals) {
            animal.eat();
        }
    }

    // 通配符模式，
    public void takeAllAnimal(List<? extends Animal> animals){
        // 使用泛型时，编译器不允许你新增元素
        // animals.add(new Cat());
        animals.remove(1);
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    // 使用泛型类型参数，你还可以声明返回值也是同样的泛型类型，
    // 方法返回的数组类型总是和传入类型的是一致的
    public <T extends Animal> List<T> takeTheAnimal(List<T> list){
        // 同样不能新增元素
        // list.add(new Cat());
        list.remove(1);
        for (Animal animal : list) {
            animal.eat();
        }
        return list;
    }

    public static void main(String[] args) {
        new TestGeneric().go();
    }
}
