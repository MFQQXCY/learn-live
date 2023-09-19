package ploy.vehicle;

public class TestBox {
    private Integer i;
    private int j;

    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();
        
    }

    public void go(){
        // 相当于 j= i.intValue(); 
        // 由于i默认值为null,此处出现空指针异常。
        j = i;
        System.out.println(j);
        System.out.println(i);
    }
}
