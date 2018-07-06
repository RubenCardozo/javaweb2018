package coursittaocp.Patterns;

class Single {
    
    private Single(){
    }
    
    private static Single INSTANCE;
    
    static Single getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Single();
        return INSTANCE;
    }
}
