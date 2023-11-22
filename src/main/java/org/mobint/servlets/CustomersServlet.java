package org.mobint.servlets;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mobint.dao.CustomerDAO;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@WebServlet("/getCustomers")
public class CustomersServlet extends HttpServlet {
    private final CustomerDAO customerDAO = new CustomerDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        Type requestType = new TypeToken<Map<String, Integer>>(){}.getType();
        Map<String, Integer> map = gson.fromJson(request.getReader(), requestType);
        int offset = map.get("offset");
        List<Map<String, String>> customers = customerDAO.getCustomers(offset);
        Type resultType = new TypeToken<List<Map<String, Integer>>>(){}.getType();
        String json = gson.toJson(customers, resultType);
        response.setContentType("application/json;charset=UTF-8");
        response.getOutputStream().print(json);
    }
}
