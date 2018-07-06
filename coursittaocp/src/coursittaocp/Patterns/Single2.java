package coursittaocp.Patterns;

public class Single2 {
    
    private Single2(){
    }
    private static final Single2 INSTANCE = new Single2();
    
    static Single2 getInstance(){
        
        return INSTANCE;
        
    }
}
