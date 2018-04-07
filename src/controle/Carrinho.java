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

@WebServlet("/Carrinho")
public class Carrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Pegando todos os produtos que estão no contexto da aplicação.
		
		ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");
		
		String id = request.getParameter("id");
		String comando = request.getParameter("comando");
		//String valor;
		//String quantidade = "1";
		String stringCarrinho = "";
		Boolean existeCookie = false;
		Cookie carrinho = null;
		
		//Pega todos os cookies que existe e coloca em um vetor de Cookies
		Cookie[] vetorCookie = request.getCookies();
		
		//Percorre esse vetor
		for ( int i = 0; i < vetorCookie.length ; i ++) {
			
			//Se o nome desse vetor for igual a "carrinho", a stringCarrinho recebe o valor que há nessa posição
			if (vetorCookie[i].getName().equals("carrinho")) {
				stringCarrinho = vetorCookie[i].getValue();
				//Marca o booleano com true informando que existe carrinho
				existeCookie = true;
				//O cookie vazio que foi criado recebe o cookie que tem o nome "carrinho" para posteriormente trabalhar com ele.
				carrinho = vetorCookie[i];
				//carrinho.setValue(Integer.parseInt(carrinho.getValue())+1 + "");
				//carrinho.setValue("bananinha");
				/*System.out.println(stringCarrinho);
				System.out.println(carrinho.getValue());*/
			}
		}
		
		//Se não existir cookie, crie um cookie vazio
		if(!existeCookie){
			carrinho = new Cookie("carrinho", "");
		}

		//response.addCookie(carrinho);
		
		
		// Se o comando recebido for o de adicionar
		if(comando.equals("add")){
			
			System.out.println("adicionou");			
			
			//Percorrer todos os produtos existentes
			for (Produto p : produtos) {
				//Se o id desse produto for igual ao id recebido
				//Ele entra no produto certo
				if(p.getId()== Integer.parseInt(id)){
					
					// Se a stringCarrihnho estiver vazia, ela é preenchida com o id do produto mais a quantidade 1
					if(stringCarrinho.equals("")){
						stringCarrinho = p.getId()+"q"+1;					
						stringCarrinho += "z";
						break;
					}
					
					
					// Se já existir produtos no carrihnho, eu quebro a stringCarrinho e coloco todas as partes antes 
					// do "Z" em um vetor de String
					String arrayProdutos[] = stringCarrinho.split("z");
					/*if(arrayProdutos.length > 1){
						System.out.println(arrayProdutos[0]+""+arrayProdutos[1]);
					}*/
					
					// A string restore guarda tudo que já havia na stringCarrinho, ou seja, tudo que tinha no carrinho
					String restore = stringCarrinho;
					// stringCarrinho é esvaziada para depois ser acrescentada com o restore
					stringCarrinho = "";
					
					Boolean passou = false;
					
					for(int x = 0; x < arrayProdutos.length; x++){
						String jaexiste = "";
						String arrayQuantProduto[] = arrayProdutos[x].split("q");

						// Se já existir um produto com o id recebido no carrinho
						if(arrayQuantProduto[0].equals(p.getId()+"")){
							arrayQuantProduto[1] = Integer.parseInt(arrayQuantProduto[1])+1 +"";
							//Erro de lógica.
							//Estou perdendo quem eu tenho depois do produto que já existe. 
							stringCarrinho += arrayQuantProduto[0]+"q"+arrayQuantProduto[1]+"z";
							passou = true;
								
						}else{
							jaexiste += arrayQuantProduto[0] + "q" + arrayQuantProduto[1]+"z";
							stringCarrinho += jaexiste;
						}
					}
					
					// Se não existir um produto com o mesmo id no carrinho
					if(!passou){
						stringCarrinho = restore + p.getId()+"q"+1+"z";
					}
								
					
				}
			}
			carrinho.setValue(stringCarrinho);
			response.addCookie(carrinho);
			
			RequestDispatcher rs = request.getRequestDispatcher("/ListaProdutos");
			rs.forward(request, response);
			
		} else if (comando.equals("remover")){
			
			/*if(!existeCookie){
				RequestDispatcher rs = request.getRequestDispatcher("/ListaProdutos");
				rs.forward(request, response);
			}*/
			
			System.out.println("Comando remover");
			
			for (Produto p : produtos) {
				if(p.getId() == Integer.parseInt(id)){
					
					String vetorProdutos[] = stringCarrinho.split("z");
					
					for(int x = 0; x < vetorProdutos.length; x++){
						String existe = "";
						String itemQuant[] = vetorProdutos[x].split("q");
						if(itemQuant[0].equals(id+"")){
							itemQuant[1] = Integer.parseInt(itemQuant[1]) - 1+"";
							stringCarrinho = itemQuant[0]+"q"+itemQuant[1]+"z";
						} else{
							existe += itemQuant[0] + "q" + itemQuant[1]+"z";
							stringCarrinho += existe;
						}
					}
				}
			}
			
			carrinho.setValue(stringCarrinho);
			response.addCookie(carrinho);
			
			RequestDispatcher rs = request.getRequestDispatcher("/ListaProdutos");
			rs.forward(request, response);
			
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
