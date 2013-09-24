package com.uade.seminario.tpo.view.objectView;
public class ItemReparacionView {
	private PiezaView pieza;
	int cantidad;
	public ItemReparacionView() {

	}
	public ItemReparacionView(PiezaView pieza, int cantidad) {
		this.pieza = pieza;
		this.cantidad = cantidad;
	}
	public PiezaView getPieza() {
		return pieza;
	}
	public void setPieza(PiezaView pieza) {
		this.pieza = pieza;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
