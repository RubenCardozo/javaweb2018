/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bundles;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 *
 * @author Administrator
 */
public class traduction_de extends ResourceBundle{

    @Override
    protected Object handleGetObject(String key) {
        switch(key){
            case "file":
                return "Datei";
            
            case "open":
                return "Offnen";
            
            case "close":
                return "Schliessen";
            
            case "quit":
                return "Shuss";
            
            default:
                return "Not traduction";
        }
    }

    @Override
    public Enumeration<String> getKeys() {
        return null;
    }
    
}
