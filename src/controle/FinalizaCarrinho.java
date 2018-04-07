package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pessoa;
import modelo.Produto;

@WebServlet("/FinalizaCarrinho")
public class FinalizaCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie vetorCookie[] = request.getCookies();
		Cookie carrinho = null;
		String stringCarrinho = "";
		Double precoTotal = 0.0;

		ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");

		for (Cookie c : vetorCookie) {
			if (c.getName().equals("carrinho")) {
				stringCarrinho = c.getValue();
				carrinho = c;
			}
		}

		String vetorProdutos[] = stringCarrinho.split("z");

		for (Produto p : produtos) {
			for (int x = 0; x < vetorProdutos.length; x++) {
				String itemQuant[] = vetorProdutos[x].split("q");
				if(itemQuant[0].equals(p.getId()+"")){
					p.decrementaEstoque(Integer.parseInt(itemQuant[1]));
					precoTotal += p.getPreco();
				}
			}
		}
		System.out.println(precoTotal);
		carrinho.setValue("");
		response.addCookie(carrinho);
		
		RequestDispatcher rs = request.getRequestDispatcher("/ListaProdutos");
		rs.forward(request, response);
	}

}
