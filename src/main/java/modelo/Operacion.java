package modelo;

import javafx.scene.control.Button;

public class Operacion {
	
	private String operacion;
	private int operacionEscojida;
	private boolean operacionPulsada;
	private boolean inicioCon0Factor1;
	private boolean inicioCon0Factor2;
	private boolean iniciaNegativo;
	
	
	public Operacion(String operacion, int operacionEscojida, boolean operacionPulsada) {
		super();
		this.operacion = operacion;
		this.operacionEscojida = operacionEscojida;
		this.operacionPulsada = operacionPulsada;
	}


	public String getOperacion() {
		return operacion;
	}


	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}


	public int getOperacionEscojida() {
		return operacionEscojida;
	}


	public void setOperacionEscojida(int operacionEscojida) {
		this.operacionEscojida = operacionEscojida;
	}


	public boolean isOperacionPulsada() {
		return operacionPulsada;
	}


	public void setOperacionPulsada(boolean operacionPulsada) {
		this.operacionPulsada = operacionPulsada;
	}


	public void guardarDividir() {
		// TODO Auto-generated method stub
		
		operacionEscojida = 2;
		operacion = "÷";
		operacionPulsada = true;
		
	}
	
	public void guardarSumar() {
		// TODO Auto-generated method stub
		operacionEscojida = 4;
		operacion = "+";
		operacionPulsada = true;
	}
	
	public void guardarPorcentaje() {
		// TODO Auto-generated method stub
		
		operacionEscojida = 5;
		operacion = "%";
		operacionPulsada = true;
		
	}

	public void guardarRestar() {
		// TODO Auto-generated method stub
		
		operacionEscojida = 3;
		operacion = "-";
		operacionPulsada = true;
		
	}
	
	public void guardarMultiplicar() {
		// TODO Auto-generated method stub
		
		operacionEscojida = 1;
		operacion = "×";
		operacionPulsada = true;
		
	}
	
	public void borrarTodo() {
		// TODO Auto-generated method stub
		
		operacion = "";
		operacionEscojida = 0;
		operacionPulsada = false;
		inicioCon0Factor1=false;
		inicioCon0Factor2=false;
		iniciaNegativo=false;
		
	}


	public void seBorroUnDigitoFactor2() {
		// TODO Auto-generated method stub

		operacion = "";
		operacionPulsada = false;
		
	}


	public void borrarOperador() {
		// TODO Auto-generated method stub

		operacion = "";
		operacionEscojida = 0;
		operacionPulsada = false;
		
	}
	
}
