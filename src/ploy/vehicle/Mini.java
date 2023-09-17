package ploy.vehicle;


/*

 */
import java.awt.Color;

public class Mini extends Car{
    
    private Color color;

    public Mini(Color c){
        super("Mini");
        color = c;
    }

    public Mini(){
        this(Color.RED);
    }

    
    /*  
     * 由于super和this都必须定义在构造函数的第一行，因此下面写法不合法，可以改成：
    public Mini(String size){
         this(Color.RED);
         super(size);
    }
    */

    public Mini(String size){
        super(size);
        color = Color.RED;
    }

    

    
    
}
