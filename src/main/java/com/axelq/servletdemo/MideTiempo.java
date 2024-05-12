package com.axelq.servletdemo;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Logger;
/*import java.util.looging;
import jakarta.servlet.annotation.WebServlet;
import javax.servlet.*;*/

@WebFilter("/calculaedad")
public class MideTiempo implements Filter {
    private static final Logger logger = Logger.getLogger(MideTiempo.class.getName());
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        long tiempoInicio = System.currentTimeMillis();

        chain.doFilter(request, response);

        long tiempoFin = System.currentTimeMillis();
        long tiempoTranscurrido = tiempoFin - tiempoInicio;
        logger.info("Tiempo transcurrido en el servlet: " + tiempoTranscurrido + " milisegundos");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
