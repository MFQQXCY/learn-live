package animal;


/**
 *  构建一个数组，可以在里面放置5个狗，超过就无法放置
 *  如果想要放置猫，就可以改成MyAnimalList
 */
public class MyDogList {
    private Dog[] dogs  = new Dog[5];
    private int nextDogIndex = 0;

    void add(Dog dog){
        if(nextDogIndex < 5){
            dogs[nextDogIndex] = dog;
            nextDogIndex ++;

        }
    }

}

class MyAnimalList{

    private Animal[] animals  = new Animal[5];
    private int nextAnimalIndex = 0;

    void add(Animal animal){
        if(nextAnimalIndex < 5){
            animals[nextAnimalIndex] = animal;
            nextAnimalIndex ++;

        }
    }
    
}
