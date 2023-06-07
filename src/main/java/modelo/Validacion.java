package modelo;

public class Validacion {
	
	
	private boolean inicioCon0Factor1;
	private boolean inicioCon0Factor2;
	private boolean iniciaNegativo;
	
	
	public Validacion(boolean inicioCon0Factor1, boolean inicioCon0Factor2, boolean iniciaNegativo) {
		super();
		this.inicioCon0Factor1 = inicioCon0Factor1;
		this.inicioCon0Factor2 = inicioCon0Factor2;
		this.iniciaNegativo = iniciaNegativo;
	}


	public boolean isInicioCon0Factor1() {
		return inicioCon0Factor1;
	}

	public void setInicioCon0Factor1(boolean inicioCon0Factor1) {
		this.inicioCon0Factor1 = inicioCon0Factor1;
	}

	public boolean isInicioCon0Factor2() {
		return inicioCon0Factor2;
	}

	public void setInicioCon0Factor2(boolean inicioCon0Factor2) {
		this.inicioCon0Factor2 = inicioCon0Factor2;
	}

	public boolean isIniciaNegativo() {
		return iniciaNegativo;
	}

	public void setIniciaNegativo(boolean iniciaNegativo) {
		this.iniciaNegativo = iniciaNegativo;
	}

	
	public boolean comaCorrecta (String auxFactor1, String auxFactor2, boolean operacionPulsada) {
		
		boolean comaCorrecta=false;
		
		if (validarOperacion(auxFactor1, auxFactor2, operacionPulsada)) {
			
			if (!iniciaNegativo) {
				
				if (operacionPulsada) {
					
					// La coma estara correctamente seleccionada cuando no haya ya una coma en el mismo factor ni tampoco se quiera poner sobre el operador
					if (!auxFactor2.equals("") && auxFactor2.indexOf(".")==-1) {
						
						comaCorrecta=true;
						
					}
					
				}else {
					
					if (auxFactor1.indexOf(".")==-1 && !auxFactor1.equals("")) {
						
						comaCorrecta=true;
						
					}
					
				}
				
			}
			
		}
		
		return comaCorrecta;
		
	}

	public boolean validarDobleCero(boolean operacionPulsada, String auxFactor1, String auxFactor2) {
		// TODO Auto-generated method stub
		boolean esPosible=false;
		
		if (validarOperacion(auxFactor1, auxFactor2, operacionPulsada)) {
			
			if (operacionPulsada) {
				
				if (!auxFactor2.equals("")&&!auxFactor2.equals("0")) {
					
					auxFactor2 += "00";
					esPosible=true;
					
				}
				
			}else {
				
				if (!auxFactor1.equals("")&&!auxFactor1.equals("-")&&!auxFactor1.equals("0")) {
					
					auxFactor1 += "00";
					esPosible=true;
					
				}
				
			}
			
		}
		
		return esPosible;
	}

	public boolean validarOperacion(String auxFactor1, String auxFactor2, boolean operacionPulsada) {
		// TODO Auto-generated method stub
		
		boolean esPosible=false;
		
		if (operacionPulsada) {
		
			if (!iniciaNegativo && auxFactor2!="") {
				
				if (auxFactor2.length() < 9) {
					
					esPosible=true;
					
				}
				
			}
		
		}else {
			
			if (!iniciaNegativo && !auxFactor1.equals("")) {
				
				if (auxFactor1.length() < 9) {
					
					esPosible=true;
					
				}
				
			}
			
		}
		
		return esPosible;
	}


	public void borrarTodo() {
		// TODO Auto-generated method stub
		
		inicioCon0Factor1=false;
		inicioCon0Factor2=false;
		iniciaNegativo=false;
		
	}


	public boolean validarInsercionNuevoDigito(String factor, String textoBoton, boolean operacionPulsada) {
		// TODO Auto-generated method stub
		boolean esPosibleInsertarNuevoDigito=false;
		
		if (operacionPulsada) {
			
			if (factor.length() < 9 && !inicioCon0Factor2) {

				if (textoBoton.equals("0") && (factor.equals(""))) {
					inicioCon0Factor2=true;
				}
				
				esPosibleInsertarNuevoDigito=true;
				
			}
		}else {
			
			if (factor.length() < 9 && !inicioCon0Factor1) {

				if (textoBoton.equals("0") && (factor.equals("")||factor.equals("-"))) {
					inicioCon0Factor1=true;
				}

				iniciaNegativo=false;
				
				esPosibleInsertarNuevoDigito=true;
				
			}
			
		}
		
		
		return esPosibleInsertarNuevoDigito;
		
	}


	public void seBorroUnDigitoFactor1(String factor) {
		// TODO Auto-generated method stub

		if (factor.equals("-")) {
			inicioCon0Factor1=false;
			iniciaNegativo=true;
		}else {
			iniciaNegativo=false;
		}
		
		if (factor.equals("0")) {
			inicioCon0Factor1=true;		
		}else {
			inicioCon0Factor1=false;
		}
		
	}
	
	public void seBorroUnDigitoFactor2(String factor) {
		// TODO Auto-generated method stub
		
		if(!factor.equals("0")) {
			inicioCon0Factor2=false;
		}else {
			inicioCon0Factor2=true;
		}
		
	}


	public void hayComaFactor2() {
		// TODO Auto-generated method stub

		inicioCon0Factor2=false;
		
	}


	public void hayComaFactor1() {
		// TODO Auto-generated method stub

		inicioCon0Factor1=false;
		
	}


	public boolean divisionCero(String operacion, String auxFactor2) {
		// TODO Auto-generated method stub
		
		boolean quiereDividirEntreCero=false;
		double factor2 = Double.parseDouble(auxFactor2);
		
		if (operacion.equals("÷") && factor2==0) {
			
			quiereDividirEntreCero=true;
			
		}
		
		return quiereDividirEntreCero;
	}
	
}
