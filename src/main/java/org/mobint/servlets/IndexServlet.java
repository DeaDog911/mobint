package org.mobint.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mobint.dao.PositionCardDAO;

import java.io.IOException;

@WebServlet("/positionCardName")
public class IndexServlet extends HttpServlet {
    private final PositionCardDAO positionCardDAO;

    public IndexServlet() {
        this.positionCardDAO = new PositionCardDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String groupId = request.getParameter("groupId");
        if (groupId != null) {
            String positionCardName = positionCardDAO.getNameByGroupId(groupId);
            response.setContentType("text/plain");
            response.getWriter().print(positionCardName);
        }
    }
}