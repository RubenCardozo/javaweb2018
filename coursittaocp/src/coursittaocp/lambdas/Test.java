
package coursittaocp.lambdas;


class Test {
    static void imprime(Object o){
        System.out.println(o);
    }
    static Object imprime(){
        return "toto";
    }
    
    Integer calc(Integer i){
        return i*10;
    }

    Test() {
        System.out.println("je suis construit");
    }
    
    
}
