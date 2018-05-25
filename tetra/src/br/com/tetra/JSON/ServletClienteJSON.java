package br.com.tetra.JSON;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

/**
 * Servlet implementation class GetDetails
 */
@WebServlet("/ServletClienteJSON")
public class ServletClienteJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletClienteJSON() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8"); 
		response.setHeader("Cache-Control", "no-cache"); 

		PrintWriter out = response.getWriter();
		
		ClienteJSON clienteJSON = new ClienteJSON();		
		String jsonData = "";
		String nome = request.getParameter("filtroNome");
		String email = request.getParameter("filtroEmail");
		
		if((request.getParameter("filtroNome") == null || nome.equals("")) && (request.getParameter("filtroEndereco") == null) || email.equals("")) {				
			try {
				jsonData = clienteJSON.getClientes();
			} catch (JSONException | SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				jsonData = clienteJSON.getClientes(nome, email);
			} catch (JSONException | SQLException e) {
				e.printStackTrace();
			}
		}
		out.print(jsonData);	
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
