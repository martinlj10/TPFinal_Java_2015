package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.ControladorUsuario;
import negocio.Usuario;

public class ServletBajaLineaPedido extends HttpServlet {

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");				
        String idUser = request.getParameter("inputEmail");		
        String pass = request.getParameter("inputPassword");	

        HttpSession sessionUsu = request.getSession();		
            		
            ControladorUsuario c = new ControladorUsuario();			
                Usuario usuario = (Usuario) request.getSession().getAttribute("oLogin");
                //c.log(usuario.getidUsuario(), usuario.getNombre(), usuario.getApellido());
                if(request.getParameter("signed-in")!= null){
                Cookie cookieUsuario = new Cookie("cookieUsuario", idUser);
                cookieUsuario.setPath("/");
                cookieUsuario.setMaxAge(60*60*24*31);
                response.addCookie(cookieUsuario);

             request.getSession().setAttribute("validaLogin", 1);
            request.getSession().setAttribute("chequeado", "login");
            response.sendRedirect("inicio.jsp");
        }
		
		
		// TODO Auto-generated method stub
}
}

	

