package com.productmanagement;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	
	ProductDAO dao = new ProductDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Product p = new Product(name, category, price);
		dao.addProduct(p);
		
		response.sendRedirect("index.html");
	}
}
