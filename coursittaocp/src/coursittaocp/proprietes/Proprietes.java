package coursittaocp.proprietes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;


public class Proprietes {
    public static void main(String[] args) {
        
        Locale loc = new Locale("DE");
        Locale.setDefault(loc);
        
        ResourceBundle rb = ResourceBundle.getBundle("Bundles.traduction");
        System.out.println(rb.getString("help"));
        
    }
    
    private static void systemProp(){
        Properties prop = System.getProperties();
            //System.out.println(prop.getProperty("java.class.path"));
            try {
                prop.load(new FileInputStream(prop.getProperty("java.class.path")+"/resources/Itta.properties"));
            } catch (IOException ex) {
                System.out.println(ex);
            }

            System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());

            System.out.println(prop.getProperty("nom"));
            System.out.println(prop.getProperty("prenom"));
            System.out.println(prop.getProperty("cours"));

            prop.list((System.out));
            
    }
    
}
