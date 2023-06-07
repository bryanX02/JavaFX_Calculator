package controlador.vista;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import modelo.Validacion;
import modelo.Factor;
import modelo.Operacion;

public class PrimaryController implements Initializable {

	@FXML
    private Button btnN7;

    @FXML
    private Button btnN9;

    @FXML
    private Button btnN8;

    @FXML
    private Button btnMultiplicar;

    @FXML
    private Button btnN4;

    @FXML
    private Button btnN5;

    @FXML
    private Button btnN6;

    @FXML
    private Button btnRestar;

    @FXML
    private Button btnN1;

    @FXML
    private Button btnN2;

    @FXML
    private Button btnN3;

    @FXML
    private Button btnSumar;

    @FXML
    private Button btnComa;

    @FXML
    private Button btnN0;

    @FXML
    private Button btnDobleCero;

    @FXML
    private Button btnIgual;

    @FXML
    private Button btnDividir;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnPorcentaje;

    @FXML
    private Button btnBorrarTodo;

    @FXML
    private TextArea txtArea;

    @FXML
    private Label lblMemoria;

    @FXML
    private Label lblOperacion;

	// En las clases de estos 3 objetos estan los atributos y metodos que empleo en el mecanismo de la calcularo
	Operacion op = new Operacion("", 0, false);
	Factor fa = new Factor(0, 0, 0, "", "", "");
	Validacion va = new Validacion(false, false, false);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Aqui declaros ids a los botones que luego personalizare con css 
		
		btnMultiplicar.setId("Operadores");
		btnDividir.setId("Operadores");
		btnPorcentaje.setId("Operadores");
		btnSumar.setId("Operadores");
		btnRestar.setId("Operadores");
		btnIgual.setId("Ejecutadores");
		btnBorrar.setId("Ejecutadores");
		btnBorrarTodo.setId("Ejecutadores");
		
	}

	// Metodo que se ejecuta cada vez que se presiona un digito numerico
	@FXML
	void pulsarNumero(ActionEvent event) {

		// Obtengo el boton que se ha pulsado mediante el metodo getSource del event
		Button btnPrueba = (Button) event.getSource();

		// Si ya se ha pulsado algun tipo de operacion relleno el factor 2
		if (op.isOperacionPulsada()) {

			// Antes de rellenar los factores compruebo el numero de digitos existente, estableciendo un limite de 9 digitos en cada factor
			if (va.validarInsercionNuevoDigito(fa.getAuxFactor2(), btnPrueba.getText(), op.isOperacionPulsada())) {
				
				fa.setAuxFactor2(fa.getAuxFactor2() + btnPrueba.getText());
				lblOperacion.setText(fa.getAuxFactor1() + op.getOperacion() + fa.getAuxFactor2());

			}else if (va.isInicioCon0Factor2()){

				lblMemoria.setText("Borra ese 0 o introduce una coma para insertar mas digitos");

			}else {

				lblMemoria.setText("No se pueden introducir mas de 9 digitos");
			}


		// Si no, esque aun estamos con el factor 1
		}else {

			// Antes de rellenar los factores compruebo el numero de digitos existente, estableciendo un limite de 9 digitos en cada factor
			if (va.validarInsercionNuevoDigito(fa.getAuxFactor1(), btnPrueba.getText(), op.isOperacionPulsada())) {
				
				fa.setAuxFactor1(fa.getAuxFactor1() + btnPrueba.getText());
				lblOperacion.setText(fa.getAuxFactor1());

			}else if (va.isInicioCon0Factor1()){

				lblMemoria.setText("Borra ese 0 o introduce una coma para insertar mas digitos");

			}else {

				lblMemoria.setText("No se pueden introducir mas de 9 digitos");
			}

		}

	}

	// Metodo que se ejecuta cuando se pulsa el boton multiplicar
	@FXML
	void multiplicar(ActionEvent event) {

		// Valido que se pueda establecer el operador
		if (va.validarOperacion(fa.getAuxFactor1(), fa.getAuxFactor2(), op.isOperacionPulsada())) {

			// Si ya hay un numero en el factor 2 realizo la operacion para guardar
			// el resultado en factor 1 y poder asi introducir un nuevo operador
			if (!fa.getAuxFactor2().equals("")) {
				operar(event);
			}

			// Guardo el tipo de operacion
			op.guardarMultiplicar();
			lblOperacion.setText(fa.getAuxFactor1() + op.getOperacion());

		}else {

			lblMemoria.setText("Debe haber de 1 a 9 digitos para operar");

		}

	}

	// Metodo que se ejecuta cuando se pulsa el boton dividir
	@FXML
	void dividir(ActionEvent event) {

		// Valido que se pueda establecer el operador
		if (va.validarOperacion(fa.getAuxFactor1(), fa.getAuxFactor2(), op.isOperacionPulsada())) {

			// Si ya hay un numero en el factor 2 realizo la operacion para guardar
			// el resultado en factor 1 y poder asi introducir un nuevo operador
			if (!fa.getAuxFactor2().equals("")) {
				operar(event);
			}

			// Guardo el tipo de operacion
			op.guardarDividir();
			lblOperacion.setText(fa.getAuxFactor1() + op.getOperacion());

		}else {

			lblMemoria.setText("Debe haber de 1 a 9 digitos para operar");

		}

	}

	// Metodo que se ejecuta cuando se pulsa el boton restar
	@FXML
	void restar(ActionEvent event) {

		// Compruebo si es el primer digito para guardarlo sin considerarlo una operacion
		if (fa.getAuxFactor1().equals("")){
			
			fa.setAuxFactor1("-");
			va.setIniciaNegativo(true);
			lblOperacion.setText(fa.getAuxFactor1());
			
		}else {
			
			// Valido que se pueda establecer el operador
			if (va.validarOperacion(fa.getAuxFactor1(), fa.getAuxFactor2(), op.isOperacionPulsada())) {

				// Si ya hay un numero en el factor 2 realizo la operacion para guardar
				// el resultado en factor 1 y poder asi introducir un nuevo operador
				if (!fa.getAuxFactor2().equals("")) {
					operar(event);
				}

				// Guardo el tipo de operacion
				op.guardarRestar();
				lblOperacion.setText(fa.getAuxFactor1() + op.getOperacion());

			}else {

				lblMemoria.setText("Debe haber de 1 a 9 digitos para operar");

			}
			
		}

	}

	// Metodo que se ejecuta cuando se pulsa el boton sumar
	@FXML
	void sumar(ActionEvent event) {

		// Valido que se pueda establecer el operador
		if (va.validarOperacion(fa.getAuxFactor1(), fa.getAuxFactor2(), op.isOperacionPulsada())) {

			// Si ya hay un numero en el factor 2 realizo la operacion para guardar
			// el resultado en factor 1 y poder asi introducir un nuevo operador
			if (!fa.getAuxFactor2().equals("")) {
				operar(event);
			}

			// Guardo el tipo de operacion
			op.guardarSumar();
			lblOperacion.setText(fa.getAuxFactor1() + op.getOperacion());

		}else {

			lblMemoria.setText("Debe haber de 1 a 9 digitos para operar");

		}

	}

	// Metodo que se ejecuta cuando se pulsa el boton porcentaje
	@FXML
	void porcentaje(ActionEvent event) {

		// Valido que se pueda establecer el operador
		if (va.validarOperacion(fa.getAuxFactor1(), fa.getAuxFactor2(), op.isOperacionPulsada())) {

			// Si ya hay un numero en el factor 2 realizo la operacion para guardar
			// el resultado en factor 1 y poder asi introducir un nuevo operador
			if (!fa.getAuxFactor2().equals("")) {
				operar(event);
			}

			// Guardo el tipo de operacion
			op.guardarPorcentaje();
			lblOperacion.setText(fa.getAuxFactor1() + op.getOperacion());

		}else {

			lblMemoria.setText("Debe haber de 1 a 9 digitos para operar");

		}

	}

	// Metodo que se ejecuta cuando se pulsa el boton dobleCero
	@FXML
	void dobleCero(ActionEvent event) {

		// Valido que si sea posible la introduccion de 2 ceros
		if (va.validarDobleCero(op.isOperacionPulsada(), fa.getAuxFactor1(), fa.getAuxFactor2())) {

			// Factor 2
			if (op.isOperacionPulsada()) {
				fa.setAuxFactor2(fa.getAuxFactor2()+"00");
				lblOperacion.setText(fa.getAuxFactor1()+op.getOperacion()+fa.getAuxFactor2());

			// Factor 1
			}else {
				fa.setAuxFactor1(fa.getAuxFactor1()+"00");
				lblOperacion.setText(fa.getAuxFactor1());
			}

		}else {
			lblMemoria.setText("Aqui no pueden ir dobles ceros");
		}

	}

	// Metodo que se ejecuta cuando se pulsa el boton de la coma
	@FXML
	void coma(ActionEvent event) {

		// Primero compruebo que no se intente poner una coma en situaciones ilogicas
		if (va.comaCorrecta(fa.getAuxFactor1(), fa.getAuxFactor2(), op.isOperacionPulsada())){

			// Factor 2
			if (op.isOperacionPulsada()) {
				
				fa.comaFactor2();
				va.hayComaFactor2();
				
				lblOperacion.setText(fa.getAuxFactor1() + op.getOperacion() + fa.getAuxFactor2());
				
			// Factor 1
			}else {
				
				fa.comaFactor1();
				va.hayComaFactor1();
				lblOperacion.setText(fa.getAuxFactor1());
				
			}

		}else {

			lblMemoria.setText("La coma no se puede poner aqui");

		}

	}

	// Metodo que se ejecuta cuando se pulsa el boton igual
	@FXML
	void operar(ActionEvent event) {

		// Se podra operar siempre que haya un numero en el factor factor 2
		if (!fa.getAuxFactor2().equals("")) {

			if(va.divisionCero(op.getOperacion(), fa.getAuxFactor2())) {
				
				lblMemoria.setText("No puedes dividir entre 0. Borralo o inserta coma y numeros");
				
			}else {
				
				// Guardo la operacion en la memoria y seguidamente ejecuto la operacion
				lblMemoria.setText(fa.getAuxFactor1() + op.getOperacion() + fa.getAuxFactor2());
				fa.operar(op.getOperacionEscojida());
				
				// Guardo el resultado en el factor 1 y borro las operaciones
				lblOperacion.setText(fa.getAuxFactor1());
				fa.borrarOperacion();
				op.borrarOperador();
				
			}

		}else {

			lblMemoria.setText("Introduzca operaciones");

		}


	}

	// Metodo que se ejecuta cuando se pulsa el boton borrar
	@FXML
	void borrar(ActionEvent event) {

		// Si no se ha pulsado alguna operacion borramos en el factor 1
		if (!op.isOperacionPulsada()) {

			fa.borrarUnDigitoFactor1();
			va.seBorroUnDigitoFactor1(fa.getAuxFactor1());
			
			lblOperacion.setText(fa.getAuxFactor1());

		// Si ya se ha seleccionado alguna operacion borramos en el factor 2 o el operador
		} else {

			// Cuando no hay factor 2 es porque borramos el operador
			if (fa.getAuxFactor2().equals("")) {

				op.seBorroUnDigitoFactor2();
				lblOperacion.setText(fa.getAuxFactor1());

			} else {

				fa.borrarUnDigitoFactor2();
				va.seBorroUnDigitoFactor2(fa.getAuxFactor2());
				lblOperacion.setText(fa.getAuxFactor1() + op.getOperacion() + fa.getAuxFactor2());

			}

		}

	}

	// Metodo que se ejecuta cuando se pulsa el boton borroTodo (CE)
	@FXML
	void borrarTodo(ActionEvent event) {

		op.borrarTodo();
		fa.borrarTodo();
		va.borrarTodo();
		lblMemoria.setText("");
		lblOperacion.setText(fa.getAuxFactor1());

	}

}
