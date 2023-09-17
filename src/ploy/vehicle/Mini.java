package ploy.vehicle;


/*

 */
public class Mini extends Car{
    
    private int color;

    public Mini(int c){
        super("Mini");
        color = c;
    }

    public Mini(){
        // 暂时110表示红色
        this(110);
    }

    
    /*  
     * 由于super和this都必须定义在构造函数的第一行，因此下面写法不合法，可以改成：
    public Mini(String size){
         this(110);
         super(size);
    }
    */

    public Mini(String size){
        super(size);
        color = 110;
    }

    

    
    
}
