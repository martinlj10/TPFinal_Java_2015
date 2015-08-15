package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*import negocio.ControladorElectrodomesticoNegocio;*/ //importar controlador de los elementos a manejar
import negocio.ControladorUsuario;
import negocio.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		ControladorUsuario controladorUsuario = new ControladorUsuario();
				
		Usuario vUsuario;
		HttpSession session= request.getSession(true);
		
	    
		String vUsername =request.getParameter("inputEmail");
	    
		String vPassword =request.getParameter("inputPassword");
	    try{
	    	
	    if(controladorUsuario.validarUsuario(vUsername,vPassword))
	    {
	    	Cookie cookieUsuario = new Cookie("cookieUsuario", vUsername);
            cookieUsuario.setPath("/");
            cookieUsuario.setMaxAge(60*60*24*31);
            response.addCookie(cookieUsuario);
            
	    	session.setAttribute("usuario",vUsername);
	    	session.setAttribute("controladorUsuario",controladorUsuario);
	    	
	    	session.setAttribute("pass", vPassword);
	    	request.getRequestDispatcher("/inicio.jsp").forward(request, response);/*redirige a la pagina principal*/
	    }
	    else
	    	{
	    		throw new Exception("Ingreso incorrecto");
	    	}
	  	
	    }catch(Exception e){
		   session.setAttribute("error", e);
		   response.sendRedirect("/nuevologin.jsp");/*Redirige a la pagina Login*/  
	   }
	    	
		
	    }

}
