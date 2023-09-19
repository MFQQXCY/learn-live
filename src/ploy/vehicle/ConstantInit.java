package ploy.vehicle;

public class ConstantInit {
    // final static 修饰的变量必须初始化
    // public static final double VAL;
    public static final double VAL = 1.1;


    int x = 12;

    // 非静态的final实例变量可以在定义时初始化，
    // 也可以在构造方法上初始化
    final int size = 3;
    final int whuffie;
    ConstantInit(){
        whuffie = 2;
    }



    public static void go(final int x){
        System.out.println(x);
    }




}
