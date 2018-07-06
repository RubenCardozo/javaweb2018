package coursittaocp.multicatche;

import java.io.File;
import java.io.IOException;

public class MultiCatche {

    public static void main(String[] args) {
        
        //Premier version
        try {
            CreeFichier(null);

        } catch (Exception ex) {
            if (ex instanceof NullPointerException) {
                System.out.println("c'est grave null");
            } else if (ex instanceof IOException) {
                System.out.println("IO problème");
            } else if (ex instanceof IllegalArgumentException) {
                System.out.println(1 + "- c'est illegal, mauvaise paramètre");
            } else if (ex instanceof Exception) {
                System.out.println("autre " + ex.getClass().getSimpleName());
            }
        }

        //deuxième version
        try {
            CreeFichier(null);
        } catch (IOException ioe) {
            System.out.println("IO problème");
        } catch (NullPointerException npe) {
            System.out.println("c'est grave null");
        } catch (IllegalArgumentException iae) {
            System.out.println(2 + "- c'est illegal, mauvaise paramètre");
        } catch (Exception ex) {
            System.out.println("autre " + ex.getClass().getSimpleName());
        }

        //troisième version
        try {
            CreeFichier(null);
        } catch (IOException ioe) {
            System.out.println("IO problème");
        } catch (NullPointerException | IllegalArgumentException npe) {
            System.out.println(3 + "- mauvaise paramètre ou null (" + npe.getClass().getSimpleName()+")" );
        } catch (Exception ex) {
            System.out.println("autre " + ex.getClass().getSimpleName());
        }

        System.out.println("Fin");
    }

    static void CreeFichier(int ti[]) throws IOException {
        try {
            System.out.println(ti[1]);
        } catch (Exception e) {
        }

        File.createTempFile("", "");

    }

    static void LitTableau(int ti[]) {

        System.out.println(ti[1]);

    }
}
