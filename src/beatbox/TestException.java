package beatbox;

import java.io.IOException;

public class TestException {
    
    public static void main(String[] args) throws Exception{
        new TestException().go("b");
    }

    private void go(String a ) throws IOException{
        if("a".equals(a)){
            // 
            throw new NullPointerException();
        }
        if("b".equals(a)){
            // 非runtime exception,都会被编译器检查，需要手动处理异常
            throw new IOException(a, null);
        }
        System.out.println(a);
        
        
    }

    


}
