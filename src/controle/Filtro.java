package controle;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class Filtro implements Filter {

    public Filtro() {
        
    }

	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession hs = ((HttpServletRequest) request).getSession(false);
		
		/*if(hs!= null){
			if((boolean) hs.getAttribute("usuario")){
				chain.doFilter(request, response);
			} else{
				((HttpServletResponse)response).sendRedirect("/Loja");
			}
		} else{
			((HttpServletResponse)response).sendRedirect("/Loja");
		}*/
		
		//((HttpServletResponse)response).sendRedirect("/Revisao/login.jsp");
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
