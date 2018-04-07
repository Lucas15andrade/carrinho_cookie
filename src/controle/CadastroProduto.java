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

import modelo.Produto;

@WebServlet("/CadastroProduto")
public class CadastroProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Falta implementar o cadastro de produtos.
		
		//int id = Integer.parseInt(request.getParameter("idProduto"));
		double preco = Double.parseDouble(request.getParameter("precoProduto"));
		String nome = request.getParameter("nomeProduto");
		String descricao = request.getParameter("descricaoProduto");
		int estoque = Integer.parseInt(request.getParameter("estoqueProduto"));
		Cookie vetorCookie[] = request.getCookies();
		Cookie carrinho = null;
		String stringCarrinho = "";
		
		ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");
		
		int lastId = 0;
		
		/*for (Cookie c : vetorCookie) {
			if (c.getName().equals("carrinho")) {
				stringCarrinho = c.getValue();
				carrinho = c;
			}
		}

		String vetorProdutos[] = stringCarrinho.split("z");

		for (Produto p : produtos) {
			for (int x = 0; x < vetorProdutos.length; x++) {
				String itemQuant[] = vetorProdutos[x].split("q");
				lastId = Integer.parseInt(itemQuant[1]);
			}
		}*/
		
		for (Produto p : produtos) {
			lastId = p.getId();
		}
		
		
		Produto p = new Produto(++lastId, preco, nome, descricao, estoque);
		
		produtos.add(p);
		
		getServletContext().setAttribute("produtos", produtos);
		
		RequestDispatcher rs = request.getRequestDispatcher("/PaginaLogista");
		rs.forward(request, response);
		
	}

}
