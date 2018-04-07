package controle;


import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import modelo.Pessoa;


@WebListener
public class CarregaUsuarios implements ServletContextListener {

    public CarregaUsuarios() {
        // TODO Auto-generated constructor stub
    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent ctx)  { 
         // TODO Auto-generated method stub
    	
    	Pessoa p1 = new Pessoa("João Pedro", "jp2017@uol.com.br", "12345jaum", "cliente");
    	Pessoa p2 = new Pessoa("Amara Silva", "amarasil@bol.com.br", "amara82", "cliente");
    	
    	Pessoa p3 = new Pessoa("Lorena Silva", "lore_sil@yahoo.com", "12uhuuu@", "lojista");
    	Pessoa p4 = new Pessoa("Taniro Rodrigues", "tanirocr@gmail.com", "123456abc", "lojista");
    	
    	ArrayList<Pessoa> pessoas = new ArrayList<>();
    	pessoas.add(p1);
    	pessoas.add(p2);
    	
    	pessoas.add(p3);
    	pessoas.add(p4);
    	//pessoas.add(p4);
    	ctx.getServletContext().setAttribute("pessoas", pessoas);
    }
	
}
