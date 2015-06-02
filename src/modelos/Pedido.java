package modelos;

import java.sql.Date;
import java.util.ArrayList;

public class Pedido {

	private String cliente;

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public int getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(int nroPedido) {
		this.nroPedido = nroPedido;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public ArrayList<Articulo> getDetalleArticulos() {
		return detalleArticulos;
	}

	public void setDetalleArticulos(ArrayList<Articulo> detalleArticulos) {
		this.detalleArticulos = detalleArticulos;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getIVA() {
		return IVA;
	}

	public void setIVA(float iVA) {
		IVA = iVA;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	private Date fechaPedido;
	
	private int nroPedido;
	
	private Date fechaEntrega;
	
	private ArrayList<Articulo> detalleArticulos;
	
	private float subTotal;
	
	private float IVA;
	
	private float total;
	
	
	
}
