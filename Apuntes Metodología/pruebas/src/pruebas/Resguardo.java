package pruebas;

import java.util.Date;

public class Resguardo {
	private String Nombre;
	private String Apellidos;
	private String tipoTarjeta;
	private int cp; // Codigo postal
	private int nTarjeta;
	private double cantidadAbonada;


	public Resguardo(String nombre, String apellidos, String tipoTarjeta, int cp, int nTarjeta,
			double cantidadAbonada) {
		Nombre = nombre;
		Apellidos = apellidos;
		this.tipoTarjeta = tipoTarjeta;
		this.cp = cp;
		this.nTarjeta = nTarjeta;
		this.cantidadAbonada = cantidadAbonada;
		
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getnTarjeta() {
		return nTarjeta;
	}

	public void setnTarjeta(int nTarjeta) {
		this.nTarjeta = nTarjeta;
	}

	public double getCantidadAbonada() {
		return cantidadAbonada;
	}

	public void setCantidadAbonada(double cantidadAbonada) {
		this.cantidadAbonada = cantidadAbonada;
	}

	@Override
	public String toString() {
		return "[Nombre:" + Nombre + ", Apellidos:" + Apellidos + ", Tipo De Tarjeta:" + tipoTarjeta + ", cp=" + cp
				+ ", nTarjeta=" + nTarjeta + "]";
	}

}
