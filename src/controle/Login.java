package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Pessoa;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		// Criando atributos que vão receber o retorno do getParameter com email e senha

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		// Criando um ArrayList de pessoa porque é o tipo de retorno que  o getAtribute irá retornar
		// Fazendo um cast pois o obeto a ser retornadado a principio é um Object
		// Pegando um objeto com o nome "pessoas" que retorna um ArrayList
		
		ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) getServletContext().getAttribute("pessoas");
		
		// Percorrendo o  ArrayList já retornado
		
		if(!email.isEmpty()){
			System.out.println("Email não está vazio");
		}

		for (int x = 0; x < pessoas.size(); x++) {
			// println(pessoas.get(x).nome);
			//System.out.println(pessoas.get(x).email + " " + pessoas.get(x).senha);
		
			// Comparando se a senha e o email são iguais a senha e o email que foram preenchidos no formulário

			if (pessoas.get(x).getEmail().equals(email) && pessoas.get(x).getSenha().equals(senha)) {
				 System.out.println("nome e email corretos \n");
				 
				 // Se for do tipo lojista, cria a sessão e encaminha para outro servlet
				
				if(pessoas.get(x).getTipo().equals("lojista")){
					System.out.println("tipo lojista \n");
					HttpSession hs = request.getSession();
					//hs.setAttribute("tipo", "lojista");
					hs.setAttribute("usuario", pessoas.get(x));
					
					RequestDispatcher rs = request.getRequestDispatcher("/PaginaLogista");
					rs.forward(request, response);
				}else{
					
					// Se for do tipo cliente, cria a sessão e encaminha para outro servlet
					
					System.out.println("tipo cliente \n");
					HttpSession hs = request.getSession();

					//hs.setAttribute("tipo", "cliente");
					hs.setAttribute("usuario", pessoas.get(x));
					
					RequestDispatcher rs = request.getRequestDispatcher("/PaginaCliente");
					rs.forward(request, response);
				}		
			} else{
				//response.sendRedirect("/Loja");
				
				/*RequestDispatcher rs = request.getRequestDispatcher("/Login");
				rs.forward(request, response);*/
			}
		}
		
//		for (Pessoa p : pessoas) {
//			if(p.getEmail()!= email || p.getSenha()!=senha){
//				response.sendRedirect("/Loja");
//			}else{
//				System.out.println("Login correto!");
//			}
//		}

		/*
		 * for (Pessoa p : pessoas) { if (p.email == email && p.senha == senha
		 * && p.tipo.equals("cliente")) { HttpSession hs = request.getSession();
		 * 
		 * RequestDispatcher rs =
		 * request.getRequestDispatcher("/ListaProdutos"); rs.forward(request,
		 * response); } else if (p.email == email && p.senha == senha &&
		 * p.tipo.equals("lojista")) {
		 * 
		 * HttpSession hs = request.getSession();
		 * 
		 * RequestDispatcher rs =
		 * request.getRequestDispatcher("/ExibeProdutos"); rs.forward(request,
		 * response); } else{ //response.sendRedirect("/Loja");
		 * System.out.println("Caiu aqui"); } }
		 */
	}

}
