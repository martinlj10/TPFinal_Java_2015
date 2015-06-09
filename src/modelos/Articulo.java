package modelos;

import java.sql.Date;

public class Articulo {
	
	private int codigo_articulo;

	public int getCodigo_articulo() {
		return codigo_articulo;
	}

	public void setCodigo_articulo(int codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}
	
	private String descripcionArticulo;
	
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	
	private float precio;
	
	public float getPrecio() {
		return precio;
	}
	
	private Date fechaDesde_precio;

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	private int stock;
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getFechaDesde_precio() {
		return fechaDesde_precio;
	}

	public void setFechaDesde_precio(Date fechaDesde_precio) {
		this.fechaDesde_precio = fechaDesde_precio;
	}

		

	
}
