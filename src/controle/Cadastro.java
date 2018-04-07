package controle;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Pessoa;

@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Cadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String tipo = "cliente";
		String senha = request.getParameter("senha");
		
		// Criando um ArrayList com as pessoas já existentes no sistema
		
		ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) getServletContext().getAttribute("pessoas");
		
		//ArrayList<Pessoa> pessoasNovas = 
		
		Pessoa p = new Pessoa(nome, email, senha, tipo);	
		
		pessoas.add(p);
		
		getServletContext().setAttribute("pessoas", pessoas);
		RequestDispatcher rs = request.getRequestDispatcher("/PaginaCliente");
		rs.forward(request, response);
		/*
		ArrayList<Pessoa> pessoas2 = (ArrayList<Pessoa>) getServletContext().getAttribute("pessoas");
		
		PrintWriter out = response.getWriter();
		for(int x = 0; x < pessoas2.size(); x++){
			out.println(pessoas2.get(x).getNome()+""+pessoas2.get(x).getEmail()+""+pessoas2.get(x).getSenha());
		}
		*/
	}

}
