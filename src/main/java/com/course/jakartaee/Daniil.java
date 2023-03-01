package com.course.jakartaee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 

/**
 * Servlet implementation class Daniil
 */
@WebServlet("/Daniil")
public class Daniil extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Daniil() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		
        InputStream resourceStream = Daniil.class.getResourceAsStream("/resources/Daniil.html");
        
        // Create a BufferedReader to read the contents of the file
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceStream));
        
        // Create a PrintWriter to write the contents of the file to the response
        PrintWriter out = response.getWriter();
        
        // Write each line of the file to the response
        String line;
        while ((line = reader.readLine()) != null) {
            out.println(line);
        }
        
        // Close the reader and writer
        reader.close();
        resourceStream.close();
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
