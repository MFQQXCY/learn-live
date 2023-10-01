package io;

import java.io.Serializable;

public class Foo implements Serializable{
    int weight;
    int height;

    Duck duck;

    transient Dog dog = new Dog();

}
