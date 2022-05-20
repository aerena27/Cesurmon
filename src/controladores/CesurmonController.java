package controladores;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import combate.Combate;
import combate.Tipo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import movimientos.Efectividad;
import movimientos.MovAtaqueEspecial;
import movimientos.MovAtaqueFisico;
import movimientos.Movimiento;
import movimientos.MovimientoAtaque;
import pokemon.Entrenador;
import pokemon.Pokemon;

public class CesurmonController implements Initializable {

    /**
     * MENÚ PRINCIPAL
     * Atributos y métodos del menú de selección
     */

    private Entrenador usuario; // Entrenador usuario
    private Entrenador cpu; // Entrenador controlado por el programa

    @FXML
    private Button btnMenuCombatir; // entrarMenuCombate

    @FXML
    private void entrarMenuCombate() throws Exception { // btnCombatir
        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuCombate.fxml"));
        Stage window = (Stage) btnMenuCombatir.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private Button btnMenuCapturar; // entrarMenuCaptura

    @FXML
    private void entrarMenuCaptura() throws Exception { // btnCapturar
        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuCaptura1.fxml"));
        Stage window = (Stage) btnMenuCapturar.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private Button btnHolaMundo; // sayHelloWorld

    @FXML
    private void sayHelloWorld(ActionEvent event) { // btnHolaMundo
        System.out.println("Hola mundo");
    }

    /**
     * MENÚ DE CAPTURAR
     * Atributos y métodos de la vista de captura
     */

    private Pokemon pokemonSalvaje; // Pokémon que se generará
    private int turnosCaptura = 0; // Turnos hasta que el Pokémon huya y se genere otro
    private int totalCapturas = 0; // Contador de capturas logradas
    private int totalIntentos = 0; // Contador de intentos realizadoss

    @FXML
    private TextField textoNombreSalvaje;

    @FXML
    private TextField textoCapturaLog;

    @FXML
    private TextField textoCapturasTotal;

    @FXML
    private TextField textoIntentosTotal;

    @FXML
    private Button btnHuirCaptura; // volverMenuPrincipal

    @FXML
    private void capturaVolverMenuPrincipal(ActionEvent event) throws Exception { // btnHuir
        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuPrincipal.fxml"));
        Stage window = (Stage) btnHuirCaptura.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private Button btnLanzarBall; // intentarCapturar

    /**
     * Método ejecutado al pulsar el botón capturar
     */
    @FXML
    private void intentarCapturar() { // btnLanzarBall
        // Llama al método de entrenador que devuelve la probabilidad de haber acertado
        // al intentarlo 1 vez
        Boolean capturaCompletada = usuario.intentarCapturar();
        totalIntentos++; // Se incrementan los intentos totales
        textoIntentosTotal.setText("Intentos: " + totalIntentos);
        turnosCaptura++; // Se incrementa los turnos que lleva el Pokémon generado

        // Si no acierta
        if (capturaCompletada == false) {
            textoCapturasTotal.setText("Capturas: " + totalCapturas);
            if (turnosCaptura >= 3) { // Al llegar al límite y fallar, se genera otro
                textoCapturaLog.setText("Se ha escapado...");
                aleatorizarSalvaje();
            } else {
                textoCapturaLog.setText("Has fallado...");
            }
        }
        // Si acierta, se añade a la caja y se genera otro Pokémon
        if (capturaCompletada == true) {
            textoCapturaLog.setText("¡Pokémon atrapado!");
            usuario.meterCaja(pokemonSalvaje); // Se añade a nuestra caja
            totalCapturas++; // Se incrementa el contador
            aleatorizarSalvaje();
        }
    }

    @FXML
    private Button btnAleatorizarSalvaje;

    /**
     * Método que genera un nuevo Pokémon salvaje y resetea los turnos de captura,
     * además de mostrar en pantalla sus datos
     */
    @FXML
    private void aleatorizarSalvaje() {
        turnosCaptura = 0;
        pokemonSalvaje = usuario.generarPokemon();
        // TODO: Poner el texto con el nombre de la especie
        textoNombreSalvaje.setText("N. Pokedex: " + pokemonSalvaje.getIdEspecie());
        textoCapturasTotal.setText("Capturas: " + totalCapturas);
        textoIntentosTotal.setText("Intentos: " + totalIntentos);
    }

    @FXML
    TextField dialogoTexto;

    @FXML
    TextField textoNombreRival;

    @FXML
    private void mostrarNombreRival() {
    }

    /**
     * COMBATE
     * Atributos y métodos de la vista combate
     */

    Pokemon pokeUsuario; // Pokémon que usará el usuario
    Pokemon pokeRival; // Pokémon que usará el programa
    Movimiento moviUsuario; // Movimiento que ejecutará el usuario
    Movimiento moviRival; // Movimiento que ejecutará el rival
    Combate combate; // Combate que se realizará

    @FXML
    private TextField txtPokemonUsuario; // Nombre de nuestro Pokémon

    @FXML
    private TextField txtPokemonRival; // Nombre del Pokémon rival

    @FXML
    private TextField txtVidaUsuario; // Nuestra vitalidad

    @FXML
    private TextField txtVidaRival; // Vitalidad rival

    @FXML
    private TextField txtAccionUsuario; // Mensaje del movimiento escogido por el usuario

    @FXML
    private TextField txtAccionRival;// Mensaje del movimiento escogido por el programa

    @FXML
    private TextField txtResistenciaUsuario; // Estamina restante del Pokémon usuario

    @FXML
    private TextField txtResistenciaRival; // Estamina restante del Pokémon rival

    @FXML
    private TextField txtVentaja1; // Efectividad del movimiento 1

    @FXML
    private TextField txtVentaja2;// Efectividad del movimiento 2

    @FXML
    private TextField txtVentaja3;// Efectividad del movimiento 3

    @FXML
    private TextField txtVentaja4;// Efectividad del movimiento 4

    @FXML
    private TextField txtTurnosCombate;// Mensaje del turno actual

    @FXML
    private TextField txtContadorKO; // Mensaje del contador de KOs de ambos bandos

    @FXML
    private TextField txtContadorVictorias; // Mensaje del contador de victorias

    @FXML
    private Button btnHuirCombate; // combateVolverMenuPrincipal

    @FXML
    private void combateVolverMenuPrincipal(ActionEvent event) throws Exception { // btnHuirCombate

        usuario.darDinero(cpu);

        Parent root = FXMLLoader.load(getClass().getResource("../vistas/menuPrincipal.fxml"));
        Stage window = (Stage) btnHuirCombate.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private Button btnIniciarCombate;

    /**
     * Método principal que controlará la mayoría de textos que se muestren en los
     * textfield y botones de la interfaz, que se actualizarán cada vez que se
     * realice un turno.
     */
    @FXML
    private void setTextos() {
        // Textos de atributos de los Pokémon
        txtPokemonUsuario.setText(pokeUsuario.getNombreEspecie());
        txtPokemonRival.setText(pokeRival.getNombreEspecie());
        txtVidaUsuario.setText("PS: " + pokeUsuario.getPuntosSaludCombate() + "/"
                + pokeUsuario.getPuntosSalud());
        txtVidaRival.setText("PS: " + pokeRival.getPuntosSaludCombate() + "/"
                + pokeRival.getPuntosSalud());
        txtResistenciaUsuario.setText("Estam.: " + pokeUsuario.getResistencia());
        txtResistenciaRival.setText("Estam.: " + pokeRival.getResistencia());

        // Textos de atributos del combate
        txtTurnosCombate.setText("Turno: " + combate.getNumeroTurno());
        txtContadorKO.setText("Contador actual: " + combate.getKoJugador() + " - " + combate.getKoRival());
        txtContadorVictorias.setText("Victorias: " + combate.getContadorVictorias());

        // Textos de la efectividad de movimientos
        txtVentaja1.setText(pokeUsuario.getMovimiento(0).checkVentaja(pokeRival));
        txtVentaja2.setText(pokeUsuario.getMovimiento(1).checkVentaja(pokeRival));
        txtVentaja3.setText(pokeUsuario.getMovimiento(2).checkVentaja(pokeRival));
        txtVentaja4.setText(pokeUsuario.getMovimiento(3).checkVentaja(pokeRival));

        // Textos del nombre de movimientos usables por nuestro Pokémon
        btnMovimiento1.setText(pokeUsuario.getMovimiento(0).getNombreHabilidad());
        btnMovimiento2.setText(pokeUsuario.getMovimiento(1).getNombreHabilidad());
        btnMovimiento3.setText(pokeUsuario.getMovimiento(2).getNombreHabilidad());
        btnMovimiento4.setText(pokeUsuario.getMovimiento(3).getNombreHabilidad());
    }

    /**
     * Método que solamente controla las acciones realizadas por ambos Pokémon,
     * similar a la clase Turno.
     */
    @FXML
    private void setTextosAcciones() {
        txtAccionUsuario.setText(pokeUsuario.getMote() + " ha usado " + moviUsuario.getNombreHabilidad());
        txtAccionRival.setText(pokeRival.getMote() + " ha usado " + moviRival.getNombreHabilidad());
    }

    /**
     * Método necesario para inicializar las variables necesarias para crear un
     * combate al acceder a la vista de combate.
     */
    @FXML
    private void iniciarCombate() {
        // Se revisa la vitalidad del equipo de ambos
        pokeUsuario = usuario.sacarPokemon();
        pokeRival = cpu.sacarPokemon();
        combate = new Combate(usuario, cpu);
        setTextos(); // Se actualizan los textos correspondientes
    }

    /**
     * Método que se añadirá al final de un turno para que actualice las variables
     * principales.
     */
    @FXML
    private void continuarCombate() {
        pokeUsuario = usuario.sacarPokemon();
        pokeRival = cpu.sacarPokemon();
        setTextos();
    }

    /**
     * Método que escogerá al azar 1 de los 4 movimientos disponibles del Pokémon
     * rival.
     */
    @FXML
    private void escogerMovimientoRival() {
        Random random = new Random();
        int eleccion = random.nextInt(3);
        moviRival = pokeRival.getMovimiento(eleccion);
    }

    /**
     * Cuatro métodos para cada botón de movimiento. Inicializan los movimientos de
     * ambos equipos que se usarán en el método realizarTurno de la clase Combate,
     * donde se calcula toda la lógica, se escribe el turno, y se hace set de los
     * atributos que hayan cambiado de ambos Pokémon.
     *
     */
    @FXML
    private Button btnMovimiento1;

    @FXML
    private void usarMovimiento1(ActionEvent event) {
        moviUsuario = pokeUsuario.getMovimiento(0); // Se escoge el movimiento i
        escogerMovimientoRival(); // Se inicializa el movimiento rival
        combate.realizarTurno(usuario, cpu, moviUsuario, moviRival); // Lógica del turno
        setTextosAcciones(); // Se actualizan los textos de las acciones
        continuarCombate(); // Se revisa la vitalidad de ambos equipos y actualiza resto de textos
    }

    @FXML
    private Button btnMovimiento2; // usarMovimiento1

    @FXML
    private void usarMovimiento2(ActionEvent event) { // btnMovimiento1
        moviUsuario = pokeUsuario.getMovimiento(1);
        escogerMovimientoRival();
        combate.realizarTurno(usuario, cpu, moviUsuario, moviRival);
        setTextosAcciones();
        continuarCombate();
    }

    @FXML
    private Button btnMovimiento3; // usarMovimiento1

    @FXML
    private void usarMovimiento3(ActionEvent event) { // btnMovimiento1
        moviUsuario = pokeUsuario.getMovimiento(2);
        escogerMovimientoRival();
        combate.realizarTurno(usuario, cpu, moviUsuario, moviRival);
        setTextosAcciones();
        continuarCombate();
    }

    @FXML
    private Button btnMovimiento4; // usarMovimiento1

    @FXML
    private void usarMovimiento4(ActionEvent event) { // btnMovimiento1
        moviUsuario = pokeUsuario.getMovimiento(3);
        escogerMovimientoRival();
        combate.realizarTurno(usuario, cpu, moviUsuario, moviRival);
        setTextosAcciones();
        continuarCombate();
    }

    @FXML
    private Button btnDescansar;

    @FXML
    private void descansar() {
        // TODO:
    }

    /**
     * INICIALIZAR
     * Variables por código para testear las clases y las vistas
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MovAtaqueFisico placaje = new MovAtaqueFisico(Tipo.NORMAL, "Placaje", 1, 50);
        MovAtaqueEspecial ascuas = new MovAtaqueEspecial(Tipo.PYRO, "Ascuas", 1, 50);
        MovAtaqueFisico latigoCepa = new MovAtaqueFisico(Tipo.DENDRO, "Latigo cepa", 1, 50);
        MovAtaqueEspecial pistolaAgua = new MovAtaqueEspecial(Tipo.HYDRO, "Pistola agua", 1, 50);

        Pokemon poke1 = new Pokemon(1, "Pikachu1", Tipo.ELECTRO, placaje, ascuas, latigoCepa, pistolaAgua);
        Pokemon poke2 = new Pokemon(2, "Blastoise1", Tipo.HYDRO, placaje, ascuas, latigoCepa, pistolaAgua);
        Pokemon poke3 = new Pokemon(3, "Charizard1", Tipo.PYRO, placaje, ascuas, latigoCepa, pistolaAgua);
        Pokemon poke4 = new Pokemon(4, "Venusaur1", Tipo.DENDRO, placaje, ascuas, latigoCepa, pistolaAgua);

        Pokemon poke5 = new Pokemon(5, "Pikachu2", Tipo.ELECTRO, placaje, ascuas, latigoCepa, pistolaAgua);
        Pokemon poke6 = new Pokemon(6, "Blastoise2", Tipo.HYDRO, placaje, ascuas, latigoCepa, pistolaAgua);
        Pokemon poke7 = new Pokemon(7, "Charizard2", Tipo.PYRO, placaje, ascuas, latigoCepa, pistolaAgua);
        Pokemon poke8 = new Pokemon(8, "Venusaur2", Tipo.DENDRO, placaje, ascuas, latigoCepa, pistolaAgua);

        poke1.setMaxStats();
        poke2.setMaxStats();
        poke3.setMaxStats();
        poke4.setMaxStats();

        usuario = new Entrenador("Pepe", 9999, poke1, poke2, poke3, poke4);
        cpu = new Entrenador("Luis", 9999, poke5, poke6, poke7, poke8);
    }

}
