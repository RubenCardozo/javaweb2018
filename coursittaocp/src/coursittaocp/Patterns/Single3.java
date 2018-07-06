package coursittaocp.Patterns;

class Single3 {

    private Single3() {
    }

    private volatile static Single3 INSTANCE;

    synchronized static Single3 getInstance() {
        
        if (INSTANCE == null) {
            synchronized (Single3.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Single3();
                }
            }
        }
      
        return INSTANCE;
       
    }
}
