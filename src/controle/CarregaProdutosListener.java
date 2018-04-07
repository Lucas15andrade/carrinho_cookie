package controle;


import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.Cookie;

import modelo.Produto;

@WebListener
public class CarregaProdutosListener implements ServletContextListener {

    public CarregaProdutosListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent ctx)  { 
         // TODO Auto-generated method stub
    	
    	// Criando atributos (objetos) que devem ser inicializados junto com a aplicação.
    	
    	Produto p1 = new Produto(1, 500, "Mesa", "Uma mesa de computador", 10 );
    	Produto p2 = new Produto(2, 2, "Lápis", "Lápis B2 grafite", 50 );
    	Produto p3 = new Produto(3, 2000, "Computador", "Computadtor 16gb de ram", 2 );
    	
    	// Adicionando os produtos a uma ArrayList
    	
    	ArrayList<Produto> produtos = new ArrayList<>();
    	produtos.add(p1);
    	produtos.add(p2);
    	produtos.add(p3);
    	
    	
    	
    	// Adicionando o ArrayList a o contexto de aplicação.
    	
    	ctx.getServletContext().setAttribute("produtos", produtos);
    }
	
}
