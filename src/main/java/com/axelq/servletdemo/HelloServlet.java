package com.axelq.servletdemo;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message1, message2;

    public void init() {
        message1 = "Hola Mundo desde un Servlet";
        message2 = "Mi primer servlet, manda un saludo";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message1 + "</h1>");
        out.println("<h4>" + message2 + "</h4");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}