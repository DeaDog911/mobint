package org.mobint.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/getCustomers")
public class CustomersServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = """ 
                select *
                from customer c
                	left join table_1 t1 on t1.customerId = c.customerId
                	...
                	left join table_N tN on tN.customerId = c.customerId
                                
                	left join table_many tm on c.customerId = tm.customerId
                order by c.customerId
                offset offset_value limit 5000
                """;
    }
}
