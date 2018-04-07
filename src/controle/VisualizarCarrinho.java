package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;
import modelo.Produto;

@WebServlet("/VisualizarCarrinho")
public class VisualizarCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizarCarrinho() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");

		Cookie vetorCookie[] = request.getCookies();
		String stringCarrinho = "";
		Boolean existe = false;
		Cookie carrinho = null;
		PrintWriter out = response.getWriter();

		ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");

		for (Cookie c : vetorCookie) {
			if (c.getName().equals("carrinho")) {
				stringCarrinho = c.getValue();

				existe = true;

				carrinho = c;

				System.out.println(stringCarrinho);
				if(c.getValue().equals("")){
					existe = false;
				}
			}
		}

		if (existe == false) {

			RequestDispatcher rs = request.getRequestDispatcher("/ListaProdutos");
			rs.forward(request, response);
			System.out.println("Carrinho Vazio");

		}

		String vetorProduto[] = stringCarrinho.split("z");

		out.println("<html>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td> Nome </td> <td> Descrição </td> <td> Preço </td> <td> Quantidade </td> <td> Remover </td>");
		out.println("</tr>");

		for (Produto p : produtos) {

			for (int x = 0; x < vetorProduto.length; x++) {
				String itemQuant[] = vetorProduto[x].split("q");
				if (itemQuant[0].equals(p.getId() + "")) {
					out.println("<tr style='border:solid'>");
					out.println("<td>");
					out.println(p.getNome());
					out.println("</td>");
					out.println("<td>");
					out.println(p.getDescricao());
					out.println("</td>");
					out.println("<td>");
					out.println(p.getPreco());
					out.println("</td>");
					out.println("<td>");
					out.println(itemQuant[1]);
					out.println("</td>");
					out.println("<td>");
					out.println("<a href='/Loja/Carrinho?id="+p.getId()+"&comando=remover'> Remover</a>");
					out.println("</td>");
					out.println("</tr>");
				}
			}
		}

		out.println("</table>");
		out.println("</br>");
		out.println("<a href='/Loja/FinalizaCarrinho'> Finalizar Carrinho </a>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("doPost");
	}
}
