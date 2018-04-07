package controle;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaginaLogista")
public class PaginaLogista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PaginaLogista() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<a href='/Loja/cadastroProduto.html'>Cadastrar Produto</a> </br>");
		out.println("<a href='/Loja/ExibeProdutos'>Exibir Produtos</a> </br>");
		out.println("<a href='/Loja/Deslogar'>Deslogar</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
