package controle;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaginaCliente")
public class PaginaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaginaCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<a href='/Loja/cadastro.html'>Realizar um novo cadastro</a> </br>");
		out.println("<a href='/Loja/ListaProdutos'>Listar os produtos</a> </br>");
		out.println("<a href='/Loja/Deslogar'>Deslogar</a>");
		out.println("</body>");
		out.println("</html>");
		/*
		RequestDispatcher rs = request.getRequestDispatcher("/ListaProdutos");
		rs.forward(request, response);
		*/
	}

}
