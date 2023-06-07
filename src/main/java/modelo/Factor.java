package modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Factor {

	private double factor1;
	private double factor2;
	private double resultado;
	private String auxFactor1;
	private String auxFactor2;
	private String auxResultado;
	
	public Factor(double factor1, double factor2, double resultado, String auxFactor1, String auxFactor2,
			String auxResultado) {
		super();
		this.factor1 = factor1;
		this.factor2 = factor2;
		this.resultado = resultado;
		this.auxFactor1 = auxFactor1;
		this.auxFactor2 = auxFactor2;
		this.auxResultado = auxResultado;
	}

	public double getFactor1() {
		return factor1;
	}

	public void setFactor1(double factor1) {
		this.factor1 = factor1;
	}

	public double getFactor2() {
		return factor2;
	}

	public void setFactor2(double factor2) {
		this.factor2 = factor2;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	public String getAuxFactor1() {
		return auxFactor1;
	}

	public void setAuxFactor1(String auxFactor1) {
		this.auxFactor1 = auxFactor1;
	}

	public String getAuxFactor2() {
		return auxFactor2;
	}

	public void setAuxFactor2(String auxFactor2) {
		this.auxFactor2 = auxFactor2;
	}

	public String getAuxResultado() {
		return auxResultado;
	}

	public void setAuxResultado(String auxResultado) {
		this.auxResultado = auxResultado;
	}

	public void borrarTodo() {
		// TODO Auto-generated method stub
		
		factor1 = 0;
		factor2 = 0;
		resultado = 0;
		auxFactor1 = "";
		auxFactor2 = "";
		auxResultado = "";
		
	}

	public void borrarUnDigitoFactor1() {
		// TODO Auto-generated method stub
		
		if(!auxFactor1.equals("")) {
			auxFactor1 = auxFactor1.substring(0, auxFactor1.length() - 1);
		}
		
	}
		

	public void borrarUnDigitoFactor2() {
		// TODO Auto-generated method stub

		auxFactor2 = auxFactor2.substring(0, auxFactor2.length() - 1);
	}

	public void comaFactor2() {
		// TODO Auto-generated method stub
		
		auxFactor2 += ".";
		
	}

	public void comaFactor1() {
		// TODO Auto-generated method stub

		auxFactor1 += ".";
		
	}

	public void operar(int operacionEscojida) {
		// TODO Auto-generated method stub
		
		// Convierto los digitos de los factores a numero manejables 
		factor1 = Double.parseDouble(auxFactor1);
		factor2 = Double.parseDouble(auxFactor2);
		
		// Dependiendo de que tipo se haya guardado realiza una u otra operacion
		switch (operacionEscojida) {

		case 1:
			resultado = factor1 * factor2;
			break;

		case 2:
			resultado = factor1/factor2;
			break;

		case 3:
			resultado = factor1-factor2;
			break;

		case 4:
			resultado = factor1+factor2;
			break;

		case 5:
			resultado = (factor2*factor1)/100;
			break;

		}
		
		// Covierto el resultado en un String, usando propiedades de BigDecimal, para darle un formato adecuado al numero 
		auxFactor1 = String.valueOf(BigDecimal.valueOf(resultado).setScale(5, RoundingMode.CEILING).stripTrailingZeros().toPlainString());
		
	}

	public void borrarOperacion() {
		// TODO Auto-generated method stub
		
		factor1 = 0;
		factor2 = 0;
		resultado = 0;
		auxFactor2 = "";
		auxResultado = "";
		
	}
	
}
