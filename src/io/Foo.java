package io;

import java.io.Serializable;

public class Foo implements Serializable{

    public static final long serialVersionUID = 1L;

    int weight;
    int height;

    Duck duck;
    String able;
    String ablec;

    transient Dog dog = new Dog();

}
