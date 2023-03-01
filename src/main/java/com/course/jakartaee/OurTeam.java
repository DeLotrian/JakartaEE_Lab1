package com.course.jakartaee; 

  

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException; 

import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 

  

@WebServlet("/OurTeam") 

public class OurTeam extends HttpServlet { 

    private static final long serialVersionUID = 1L; 

         

    public OurTeam() { 

        super(); 

        // TODO Auto-generated constructor stub 

    } 

  

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

  

        response.setContentType("text/html"); 

          

     // Get the file path of the HTML file
        String filePath = "C:\\Users\\bezot\\eclipse-workspace\\Lab_1\\src\\main\\java\\resources\\OurTeam.html";
        
        // Create a file object
        File file = new File(filePath);
        
        // Create a BufferedReader to read the contents of the file
        BufferedReader reader = new BufferedReader(new FileReader(file));
        
        // Create a PrintWriter to write the contents of the file to the response
        PrintWriter out = response.getWriter();
        
        // Write each line of the file to the response
        String line;
        while ((line = reader.readLine()) != null) {
            out.println(line);
        }
        
        // Close the reader and writer
        reader.close();
        out.close();

    } 
}