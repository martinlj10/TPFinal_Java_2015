package modelos;

public class LineaPedido {

	
	public Articulo getArt() {
		return art;
	}
	public void setArt(Articulo art) {
		this.art = art;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getSub_total() {
		return sub_total;
	}
	public void setSub_total(float sub_total) {
		this.sub_total = sub_total;
	}
	private Articulo art;
	private int cantidad;
	private float sub_total;
}
