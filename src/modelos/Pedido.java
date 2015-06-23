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
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArrayList<LineaPedido>  getDetalles() {
		return detalles;
	}

	public void setDetalles(ArrayList<LineaPedido> detalles) {
		this.detalles = detalles;
	}

	private Date fechaPedido;
	
	private int nroPedido;
	
	private Date fechaEntrega;
	
	private String estado;
	
	private ArrayList<LineaPedido> detalles;
	
	private float IVA;
	
	private float total;
	
	
	
}
