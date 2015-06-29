package modelos;

import java.sql.Date;

public class Venta {

	private Date fecha_Venta;
	private String medio_pago;
	private int codigo_pedido;
	private Cliente cli;
	
	
	public Cliente getCli() {
		return cli;
	}
	public void setCli(Cliente cli) {
		this.cli = cli;
	}
	public Date getFecha_Venta() {
		return fecha_Venta;
	}
	public void setFecha_Venta(Date fecha_Venta) {
		this.fecha_Venta = fecha_Venta;
	}
	public String getMedio_pago() {
		return medio_pago;
	}
	public void setMedio_pago(String medio_pago) {
		this.medio_pago = medio_pago;
	}
	public int getCodigo_pedido() {
		return codigo_pedido;
	}
	public void setCodigo_pedido(int codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}
	
	
	
}
