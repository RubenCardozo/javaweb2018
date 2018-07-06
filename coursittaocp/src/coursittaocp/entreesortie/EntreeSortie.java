package coursittaocp.entreesortie;

import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.attribute.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyFileVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.size() > 100) {
            System.out.println("\t" + file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (dir.toString().contains(".class")) {
            return FileVisitResult.SKIP_SUBTREE;
        }

        System.out.println(dir);

        if (dir.endsWith("empty")) {
            throw new IOException("c'est vide");
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if (dir.toString().contains(".java")) {
            System.out.println("fin de " + dir);
        }
        return FileVisitResult.CONTINUE;
    }
}

public class EntreeSortie {

    public static void main(String[] args) {
        

        

        
    }

    private static void myWriteStreamSerialisation(String p) {
        Path myPath = Paths.get(p);
        try (
                OutputStream fos = Files.newOutputStream(myPath);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
                ) 
        {
            Personne jean = new Personne("Jean", 12, 5, 1980, 5000f);
            Personne paul = new Personne("Paul", 11, 6, 1970, 6000f);
            oos.writeObject(jean);
            oos.writeObject(paul);
            
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static void myReadStreamSerialisation(Path myPath) {
        try (
                InputStream fis = Files.newInputStream(myPath);
                ObjectInputStream ois = new ObjectInputStream(fis)
                ) 
        {
            
            Object o=ois.readObject();
            if(o instanceof Personne){
                Personne p1 =(Personne)o ;
                System.out.println(p1.getNom()+" est né le "+ p1.getNaissence()+" Salaire= "+p1.getSalaire());
            }
            
            Object o2=ois.readObject();
            if(o instanceof Personne){
                Personne p1 =(Personne)o2 ;
                System.out.println(p1.getNom()+" est né le "+ p1.getNaissence()+" Salaire= "+p1.getSalaire());
            }
               
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    private static void Services() {
        String myPath = "C:\\Users\\Administrator\\Documents\\NetBeansProjects\\coursittaocp";

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(myPath), "[ts]*")) {
            for (Path p : ds) {
                System.out.println(p);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

        try {
            Files.walkFileTree(
                    Paths.get(myPath),
                    new MyFileVisitor());
        } catch (IOException ex) {
            System.out.println(ex);
        }

        Path p = Paths.get("/titi/toto.txt");
        Path p2 = Paths.get("/titi/toto.pdf");
        Path p3 = Paths.get("toto.pdf");
        //PathMatcher pm = FileSystems.getDefault().getPathMatcher("glob:{**/*,*}.pdf");
        //PathMatcher pm = FileSystems.getDefault().getPathMatcher("regex:.+?\\.pdf");
        PathMatcher pm = FileSystems.getDefault().getPathMatcher("regex:[\\w/\\\\]+?\\.pdf");
        System.out.println("pm.matches(p): " + pm.matches(p));
        System.out.println("pm.matches(p2): " + pm.matches(p2));
        System.out.println("pm.matches(p3): " + pm.matches(p3));//mais match "glob:*.txt"

        p = Paths.get("titi\\toto.txt");
        p2 = Paths.get("titi\\toto.pdf");
        System.out.println("pm.matches(p): " + pm.matches(p));
        System.out.println("pm.matches(p2): " + pm.matches(p2));

        Path asurveiller = Paths.get("c:/");

        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            asurveiller.register(watcher,
                    ENTRY_CREATE,
                    ENTRY_DELETE,
                    ENTRY_MODIFY
            );
            while (true) {
                WatchKey key = null;
                //key = watcher.take();
                key = watcher.poll(10, TimeUnit.SECONDS);

                if (key != null) {
                    DisplayAndResetEvent(key);
                } else {// Sans enevement
                    System.out.println("Trop tard! pas d'evenement");
                    break;
                }

            }

        } catch (IOException | InterruptedException ex) {
            System.out.println(ex);
        }
    }

    private static void DisplayAndResetEvent(WatchKey key) {
        List<WatchEvent<?>> events = key.pollEvents();
        for (WatchEvent<?> event : events) {
            WatchEvent.Kind<?> type = event.kind();
            switch (type.name()) {
                case "ENTRY_DELETE":
                    System.out.println("suppression de " + event.context());
                    break;
                case "ENTRY_CREATE":
                    System.out.println("creation de " + event.context());
                    break;
                case "ENTRY_MODIFY":
                    System.out.println("modification de " + event.context());
                    break;
                default:
                    break;
            }
        }
        key.reset();
    }

    private static void pathManage() {
        Path f1 = Paths.get("c:/titi/tutu/toto.txt");
        System.out.println(f1.getNameCount());
        System.out.println(f1.getRoot());
        for (int i = 0; i < f1.getNameCount(); i++) {
            System.out.println(f1.getName(i).toString());
        }
        File ff = f1.toFile();
        Path f2 = Paths.get("c:\\", "titi", "tutu", "toto.txt");
        System.out.println(f2.getRoot());
        for (Path p : f2) {
            System.out.println(p.toString());
        }
        System.out.println("f2.equals(f1): " + f2.equals(f1));//true
        Path f3 = Paths.get("c:/titi/tutu/tata/../toto.txt");
        System.out.println("f2.equals(f3): " + f2.equals(f3));//false
        System.out.println("f3.normalize(): " + f3.normalize());
        System.out.println("f2.equals(f3.normalize()): " + f2.equals(f3.normalize()));//true

        System.out.println("------------------------------------");
        Path rep = Paths.get("/titi/toto");
        Path file = Paths.get("../tata/toto.txt");
        Path f4 = rep.resolve(file);
        System.out.println("resolve (concatenation): " + f4);
        System.out.println("normalize (canonise): " + f4.normalize());

        rep = Paths.get("/titi/tutu");
        file = Paths.get("/titi/toto.txt");
        System.out.println("relativaze (nous passe de un chemin à l'autre si sont reletives ou absolutes): " + rep.relativize(file));
    }

    private static void FilesApi() {
        Path f1 = Paths.get("c:/titi/tutu/toto.txt");
        System.out.println(f1.getNameCount());
        System.out.println(f1.getRoot());
        for (int i = 0; i < f1.getNameCount(); i++) {
            System.out.println(f1.getName(i).toString());
        }
        File ff = f1.toFile();
        Path f2 = Paths.get("c:/toto3.txt");
        if (Files.exists(f2)) {
            System.out.println("is Readable: " + Files.isReadable(f2));
            System.out.println("is Regular File: " + Files.isRegularFile(f2));
            System.out.println("is Writable File: " + Files.isWritable(f2));

            try {
                System.out.println("Last Modified Time: " + Files.getLastModifiedTime(f2).toInstant());
                BasicFileAttributes bfa = Files.readAttributes(f2, BasicFileAttributes.class);
                System.out.println("Creation time: " + bfa.creationTime().toInstant());

                if (f2.getFileSystem().getClass().getSimpleName().equals("WindowsFileSystem")) {
                    DosFileAttributes das = Files.readAttributes(f2, DosFileAttributes.class);
                    System.out.println("is ReadOnly: " + das.isReadOnly());
                    System.out.println("is System: " + das.isSystem());
                    Files.setAttribute(f2, "dos:readonly", true);
                    //System.out.println("is ReadOnly: "+das.isReadOnly());
                }

                List<String> ls = Files.readAllLines(f2);
                ls.forEach(System.out::println);
                Files.copy(f2, Paths.get("c:/toto2.txt"), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
                //Files.deleteIfExists(Paths.get("c:/toto2.txt"));
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } else // File n'existe pas File.exist = false
        {
            try {
                Files.createFile(f2);
                FileWriter fw = new FileWriter(f2.toFile());
                fw.write("Hi my world " + "Salut tout le monde" + " Good bye not so bad world");
            } catch (Exception e) {
            }
        }
    }

    private static void maConsole() {
        System.console().format("Bonjour\n ");
        String nom = System.console().readLine("Entrez votre nom: ");
        char[] tc = System.console().readPassword("Entrez password: ");
        System.console().writer().println("Bienvenue " + nom + " pw= " + new String(tc));

        System.console().readLine("Fin");
    }

    private static void readFiles() {
        //Premier façon de lire de fichier
//        try (FileReader fr = new FileReader("c:/toto.txt")){
//            int c= -1;
//            while ((c=fr.read())!=-1){
//                System.out.print((char)c);
//            }
//        }catch (IOException ex){
//            System.out.println(ex);
//        }
        //Seconde façon de lire de fichier
//        try (FileReader fr = new FileReader("c:/toto.txt")){
//            int c= -1;
//            char[] tchar = new char[13];
//            while ((c=fr.read(tchar))!=-1){
//                if(c!=tchar.length)
//                    System.out.print(Arrays.copyOf(tchar, c));
//                else
//                    System.out.print(tchar);
//            } 
//        }
//        catch (IOException ex){
//            System.out.println(ex);
//        }
        //Troixième façon de lire de fichier
        try (
                BufferedReader br = new BufferedReader(new FileReader("c:/toto.txt"))) {
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    private static void closeables() {
        try (
                MyAutoClose mac = new MyAutoClose("Salut tout le monde!");
                PrintWriter fw = new PrintWriter("c:/toto.txt");
                BufferedWriter bw = new BufferedWriter(fw, 128)) {
            fw.println("Hello beautiful world! ");
            fw.println(4.5);
            fw.println(mac.data);
            fw.print("Good bye ugly world!");
            //bw.newLine();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        MyAutoClose s = null;
        try (MyAutoClose mac = new MyAutoClose("Salut tout le monde!")) {
            s = mac;
            System.out.println(s.data);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println(s.data);

        try (MyAutoClose mac = new MyAutoClose("Exception's Hell")) {
            mac.enfer();
        } catch (Exception ex) {
            System.out.println(ex);//v1
            Throwable[] sups = ex.getSuppressed();
            if (sups.length > 0) {
                System.out.println(sups[0].getMessage());//v2
            }
        }
    }

    private static void WriteTexteOld() {
        File f = new File("c:/toto.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            fw.append("Hello world! ");
            fw.append("\n");
            fw.append("Good bye world!");

        } catch (Exception ex) {
            System.out.println(ex);

        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    private static void Folders() {
        //Creation de un repertoire

        File l = new File("C:\\Users\\ADMINI~1\\AppData\\Local\\Temp");
        //String[] filesTemp = l.list();
        String[] filesTemp = l.list((dir, name) -> name.endsWith("*.tmp"));
        for (String file : filesTemp) {
            System.out.println(file);
        }
        try {
            File g = File.createTempFile("toto", ".txt");
            System.out.println(g.getAbsolutePath());
        } catch (IOException ex) {
            System.out.println(ex);
            //return true;
        }
        File f = new File("titi/../toto");
        if (f.exists()) {
            try {
                System.out.println(f.getPath());
                System.out.println(f.getAbsolutePath());
                System.out.println(f.getCanonicalPath());
            } catch (IOException ex) {
                System.out.println(ex);
            }

            System.out.println(f.isDirectory());
            System.out.println("Le repertoire à été effacé: " + f.delete());
        } else {
            try {
                f.mkdir();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        //return false;
    }

    private static void CreateFile() {

        //Creation de un fichier 
        File f = new File("c:/toto.txt");
        File f2 = new File("c:/toto2.txt");
        if (f.exists()) {
            System.out.println(f.getAbsolutePath());
            System.out.println(f.renameTo(f2));
        } else {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
}

class MyAutoClose implements AutoCloseable {

    String data;

    public MyAutoClose(String data) {
        this.data = data;
    }

    void enfer() {
        if (data.contains("Hell")) {
            throw new RuntimeException("l'enfer v1");
        }
    }

    @Override
    public void close() throws Exception {
        if (data.contains("Hell")) {
            throw new Exception("l'enfer v2");
        }
        data += "<br>";
    }
}
