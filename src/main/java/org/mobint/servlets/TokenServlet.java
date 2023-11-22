package org.mobint.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mobint.models.Token;
import org.mobint.utils.TokenUtil;

import java.io.IOException;

@WebServlet("/token")
public class TokenServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Token token = new TokenUtil().getToken();
        response.getWriter().println(token);
    }
}
