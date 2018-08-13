
package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


//@WebServlet(name = "UploadServlet",
//        urlPatterns = {"/files/upload"},
//        initParams = {
//            @WebInitParam(name = "dirname", value = "data")
//        }
//)
//@MultipartConfig(location = "",
//        maxFileSize = 1000_000L, 
//        fileSizeThreshold = 500_000, 
//        maxRequestSize = 1000_000L
//)

public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Part p = request.getPart("file1");
        if (p == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "pas de fichier envoyé");
        }
        String filename = Paths.get(p.getSubmittedFileName()).getFileName().toString();
        
        String initParameter = getInitParameter("dirname");
        
        Path dirname = Paths.get("C:/", initParameter);
        Path fullname = Paths.get("C:/", initParameter,filename);
        
        if (Files.exists(fullname)|| p.getSize()>1000_000L){
            //rediriger vers upload avec msg
            p.delete();
            response.sendRedirect("../upload.jsp?msg=fichier existe deja ou est très gros");
            return;
        }
        if (!Files.exists(dirname)){
            //test du repertoire ou sinon le creer
            Files.createDirectory(dirname);
        }
        try (InputStream input= p.getInputStream()){
        Files.copy(input, fullname);
        //rediriger vers upload avec message success
        }
        response.sendRedirect("../upload.jsp?msg=fichier sauve");
        
        //creer le fichier mais pas de l'écraser(sinon rediriger vers upload avec message d'erreur) 
    }
}