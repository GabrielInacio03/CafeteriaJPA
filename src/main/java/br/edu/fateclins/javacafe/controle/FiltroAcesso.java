package br.edu.fateclins.javacafe.controle;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FiltroAcesso", urlPatterns = {"/*"})
public class FiltroAcesso implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        HttpSession sessao = req.getSession();
        // verifico se existe o atributo userSessao na sessão

        if ((sessao.getAttribute("userSessao") != null)
                || (uri.contains("resource"))) {
            // permite seguir o fluxo previsto
            chain.doFilter(request, response);
        } else {
            // objeto responsavel por redirecionar o fluxo da navegação
            RequestDispatcher rd = req.getRequestDispatcher("index.xhtml");
            rd.forward(request, response);
        }

    }

    @Override
    public void destroy() {

    }

}
