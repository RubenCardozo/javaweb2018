package coursittaocp.assertions;

public class Assertions {
    
    public static void main(String[] args) {
        
        int x = 12;
        
        assert(x == 12);
       
        System.out.println("suite");
        
        x=13;
        
        switch(x){
            case 12:
                System.out.println("OK 12");
                break;
            case 13:
                System.out.println("OK 13");
                break;
            case 14:
                System.out.println("OK 14");
                break;
            default: assert false;
        }
    }
}
