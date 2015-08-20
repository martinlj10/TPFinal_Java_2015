package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelos.Auto;
import modelos.Marca;
import negocio.ControladorAuto;
import negocio.ControladorMarca;


/**
 * Servlet implementation class ServletSeleccionaAuto
 */
@WebServlet("/ServletSeleccionaAuto")
public class ServletSeleccionaAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSeleccionaAuto() {
        super();
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
		HttpSession session=request.getSession();
		ControladorAuto controlador =(ControladorAuto)session.getAttribute("controladorAuto");
		ControladorMarca controladorMarca = (ControladorMarca)session.getAttribute("controladorMarca");
		Auto nuevoAuto = new Auto();
		Marca nuevaMarca = new Marca();
		int cod_auto = Integer.getInteger(request.getParameter("cod_auto"));
				
		try{
		nuevoAuto = ControladorAuto.getOne(cod_auto);
		nuevaMarca = ControladorMarca.getOne(nuevoAuto.getCod_marca());
		
		session.setAttribute("codAuto",nuevoAuto.getCod_auto());
		session.setAttribute("descripcionAuto", nuevoAuto.getDescripcionAuto());
		session.setAttribute("precio", nuevoAuto.getPrecio());
		session.setAttribute("valoracion", nuevoAuto.getValoracion());
		session.setAttribute("anoFabric", nuevoAuto.getAnoFabricacion());
		session.setAttribute("nombreAuto", nuevoAuto.getNombre_auto());
		session.setAttribute("nombreMarca", nuevaMarca.getDescrip_marca());
		
		response.sendRedirect("/selectOne.jsp");/*Redirige al Auto seleccionado*/
		}
		catch(Exception e)
		{
			response.sendRedirect("/ErrorEleccionAuto.html"); //No está creada esta vista1.
		}
		// TODO Auto-generated method stub
	}

		
		
	}


