package ploy.animal;

public class Duck {

    // 所有duck的实例都会有一份duckCount的备份
    private static int duckCount=0;
    
    private static Duck duck;

    private Duck(){
        duckCount ++;
    }


    // 
    public Duck getIntance(){
        if(duck == null){
            duck = new Duck();
        }
        return duck;
    }


    
}
