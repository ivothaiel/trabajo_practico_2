package ar.edu.unju.fi.ejercicio5.model;
import java.time.LocalDate;
import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
public class PagoEfectivo implements Pago {

	private double montoPagado;
	private LocalDate fechaPago;
	
	
	
	
	
	public PagoEfectivo() {
		super();
		
	}
	
	

	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		super();
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}



	public double getMontoPagado() {
		return montoPagado;
	}



	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}



	public LocalDate getFechaPago() {
		return fechaPago;
	}



	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}



	@Override
	public void realizarPago(double monto) {
		this.montoPagado+=monto*0.9;
		
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
		
	}

}
