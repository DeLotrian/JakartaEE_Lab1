package com.course.jakartaee;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 

/**
 * Servlet implementation class DisplayImage
 */
@WebServlet(name="DisplayImage", urlPatterns="/images/*")
public class DisplayImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String imagesBase = "/resources/images/";

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String URLAfterWebDomain = request.getRequestURI();

        if(URLAfterWebDomain.startsWith("/Lab_1/images/") == false)   
            return;

        String relativeImagePath = URLAfterWebDomain.substring("/Lab_1/images/".length());

        System.out.println("\nFetching image from "+imagesBase+relativeImagePath);
        
        response.setContentType("image/jpeg"); 

        ServletOutputStream outStream;
        outStream = response.getOutputStream();

        InputStream resourceStream = DisplayImage.class.getResourceAsStream(imagesBase+relativeImagePath);
        
        BufferedInputStream bin = new BufferedInputStream(resourceStream);
        BufferedOutputStream bout = new BufferedOutputStream(outStream);
        
        int ch =0; ;
        while((ch=bin.read())!=-1)
            bout.write(ch);

        bin.close();
        resourceStream.close();
        bout.close();
        outStream.close();
    }
}
