package controle;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Produto;

/**
 * Servlet implementation class ExibeProdutos
 */
@WebServlet("/ExibeProdutos")
public class ExibeProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExibeProdutos() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		if(request.getSession(false) != null){
			ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");
			
			out.println("<html>");
			out.println("<body>");
			out.println("<table >");
			out.println("<tr>");
			out.println("<td> Nome </td> <td> Descrição </td> <td> Preço </td> <td> Estoque </td>");
			out.println("</tr>");
			
			for(int x = 0; x < produtos.size(); x++){
				out.println("<tr style='border:solid'>");
				out.println("<td >");
				out.println(produtos.get(x).getNome());
				out.println("</td>");
				out.println("<td>");
				out.println(produtos.get(x).getDescricao());
				out.println("</td>");
				out.println("<td>");
				out.println(produtos.get(x).getPreco());
				out.println("</td>");
				out.println("<td>");
				out.println(produtos.get(x).getEstoque());
				out.println("</td>");
				out.println("<td>");
			}
			//out.println("</tr>");
			out.println("</table>");
			out.println("</br>");
			//out.println("<a href='/Loja/PaginaCliente' method='post'> Pagina Cliente</a>");
			out.println("<form method='post' action='http://localhost:8080/Loja/PaginaLogista'>");
			out.println("<a>");
			out.println("<button type='submit'>Página Logista</button>");
			out.println("</a>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			
		} else{
			response.sendRedirect("/Loja");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
