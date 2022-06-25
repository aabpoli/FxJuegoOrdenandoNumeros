/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelo.Juego;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Alons
 */
public class VistaOrdNumController implements Initializable {

    @FXML
    private ImageView ImgNiño;
    @FXML
    private AnchorPane Pentrada;
    @FXML
    private TabPane Pantallas;
    @FXML
    private Tab Pantalla1;
    @FXML
    private AnchorPane PanePantalla1;
    @FXML
    private Tab Pantalla2;
    @FXML
    private AnchorPane PanePantalla2;
    @FXML
    private Tab Pantalla3;
    @FXML
    private AnchorPane PanePantalla3;
    @FXML
    private Tab Pantalla4;
    @FXML
    private AnchorPane PanePantalla4;
    @FXML
    private Button Bsiguiente;
    @FXML
    private Button Bcontinuar;
    @FXML
    private TextField TnumParticipantes;
    @FXML
    private TextField TnumNiveles;
    @FXML
    private TextField Tp2NombreParticipante;
    @FXML
    private TextField Tp2Numparticipantes;
    @FXML
    private Button BJentregar;
    @FXML
    private Label LJnivel;
    @FXML
    private Label LJtamaño;
    @FXML
    private Label LJnombrePart;
    @FXML
    private Label LJpuntaje;
    @FXML
    private Label LJaleatorios;
    @FXML
    private TextField BJ1;
    @FXML
    private TextField BJ2;
    @FXML
    private TextField BJ3;
    @FXML
    private TextField BJ4;
    @FXML
    private TextField BJ5;
    @FXML
    private TextField BJ6;
    @FXML
    private TextField BJ7;
    @FXML
    private TextField BJ8;
    @FXML
    private TextField BJ9;
    @FXML
    private TextField BJ10;
    @FXML
    private TextField BJ11;
    @FXML
    private TextField BJ12;
    @FXML
    private TextField BJ13;
    @FXML
    private TextField BJ14;
    @FXML
    private TextField BJ15;
    @FXML
    private TextField BJ16;
    @FXML
    private TextField BJ17;
    @FXML
    private TextField BJ18;
    @FXML
    private TextField BJ19;
    @FXML
    private TextField BJ20;
    @FXML
    private TextField BJ21;
    @FXML
    private TextField BJ22;
    @FXML
    private Label Lcampeon;
    @FXML
    private Label LpuntosCampeon;
    @FXML
    private Label Lsegundo;   
    @FXML
    private Label LpuntosSegundo;
    @FXML
    private Label Ltercero;
    @FXML
    private Label LpuntosTercero;    
    
    //Varibles para administrar el numero de niveles y participantes
    int numParticipantes = 1;
    int numNiveles = 1;
    int PartActual;
    int NivelActual;

    //Variable tipo Juego
    Juego juego;


    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TnumParticipantes.textProperty().set("1");
        TnumNiveles.textProperty().set("1");
    }

    @FXML
    private void Clic(ActionEvent event) {
        numParticipantes = Integer.parseInt(TnumParticipantes.textProperty().getValue());
        numNiveles = Integer.parseInt(TnumNiveles.textProperty().getValue());

        if (numParticipantes < 1) {
            numParticipantes = 1;
        }

        if (numNiveles < 1) {
            numNiveles = 1;
        }

        if (numNiveles > 10) {
            JOptionPane.showMessageDialog(null, "El nivel maximo es 10");
            numNiveles = 10;
            TnumParticipantes.textProperty().set("" + numParticipantes);
            TnumNiveles.textProperty().set("" + numNiveles);
        
        } else {          
            Pantalla1.disableProperty().setValue(Boolean.TRUE);
            PanePantalla1.visibleProperty().setValue(Boolean.FALSE);
            Pantalla2.disableProperty().setValue(Boolean.FALSE);
            PanePantalla2.visibleProperty().setValue(Boolean.TRUE);
            Pantalla1.getTabPane().getSelectionModel().select(Pantalla2);

            Tp2Numparticipantes.textProperty().set("1");

            if (numParticipantes == 1) {
                Bsiguiente.setText("Iniciar Juego");
            }

            PartActual = 1;
            NivelActual = 1;

            juego = new Juego();
        }
    }

    @FXML
    private void ClicPar(ActionEvent event) {
        PartActual = Integer.parseInt(Tp2Numparticipantes.textProperty().getValue());
        String nombrePar = Tp2NombreParticipante.textProperty().getValue();
        juego.setParticipantes(nombrePar, PartActual);

        if ((numParticipantes == PartActual)) {
            PartActual = 1;
            NivelActual = 1;

            Pantalla2.disableProperty().setValue(Boolean.TRUE);
            PanePantalla2.visibleProperty().setValue(Boolean.FALSE);
            Pantalla3.disableProperty().setValue(Boolean.FALSE);
            PanePantalla3.visibleProperty().setValue(Boolean.TRUE);
            Pantalla2.getTabPane().getSelectionModel().select(Pantalla3);

            pantallaNuevoJuego();

        } else {
            PartActual = PartActual + 1;
            Tp2Numparticipantes.textProperty().set("" + PartActual);
            Tp2NombreParticipante.textProperty().set("");
            if (PartActual == numParticipantes) {
                Bsiguiente.setText("Inciar Juego");
            }
        }
    }

    @FXML
    private void ClicJ(ActionEvent event) {
        String puntajeEsteNivel = "Puntaje ganado en este nivel: " + cargaNumerosUsuario();
        juego.setCargaNivelParticipante(PartActual);
        JOptionPane.showMessageDialog(null, puntajeEsteNivel);

        if ((numParticipantes == PartActual)) {
            if ((NivelActual == numNiveles)) {
                Pantalla3.disableProperty().setValue(Boolean.TRUE);
                PanePantalla3.visibleProperty().setValue(Boolean.FALSE);
                Pantalla4.disableProperty().setValue(Boolean.FALSE);
                PanePantalla4.visibleProperty().setValue(Boolean.TRUE);
                Pantalla3.getTabPane().getSelectionModel().select(Pantalla4);
                
                definicionRanking();
                
            } else {
                NivelActual = NivelActual + 1;
                PartActual = 1;
                pantallaNuevoJuego();
            }
            
        } else {
            PartActual = PartActual + 1;
            pantallaNuevoJuego();
        }
    }

    @FXML
    private void validacionSoloNumeros(KeyEvent event) {
        String s = event.getCharacter();
        if (!Character.isDigit(s.charAt(0))) {
            event.consume();
        }
    }

    private void pantallaNuevoJuego() {
        juego.setNivel(NivelActual);
        LJnivel.textProperty().set("Nivel No.: " + NivelActual);
        LJtamaño.textProperty().set(juego.getNivel().getSerie().getTamaño() + " numeros");
        LJnombrePart.textProperty().set(nombreParticipante(PartActual));
        LJpuntaje.textProperty().set(puntajeAcumuladoPar(PartActual));
        LJaleatorios.textProperty().set(numerosAleatorios());
        limpiarCasillasNumeros();
    }

    private void definicionRanking(){
        int [][] resultado = juego.rankingParticipantes();
        
        if (resultado[0][0] > 0) {
            Lcampeon.textProperty().set(nombreParticipante(resultado[0][0]));
            LpuntosCampeon.textProperty().set(resultado[0][1] + " Puntos");
        }else{
            Lcampeon.textProperty().set("");
            LpuntosCampeon.textProperty().set("");
        }        
        
        if (resultado[1][0] > 0) {
            Lsegundo.textProperty().set(nombreParticipante(resultado[1][0]));
            LpuntosSegundo.textProperty().set(resultado[1][1] + " Puntos");
        }else{
            Lsegundo.textProperty().set("");
            LpuntosSegundo.textProperty().set("");
        }
        
        if (resultado[2][0] > 0) {
            Ltercero.textProperty().set(nombreParticipante(resultado[2][0]));
            LpuntosTercero.textProperty().set(resultado[2][1] + " Puntos");
        }else{
            Ltercero.textProperty().set("");
            LpuntosTercero.textProperty().set("");                    
        }
    }    
    
    private String puntajeAcumuladoPar(int codParticipante) {
        return "Puntaje Acumulado: " + juego.getParticipantes().get(codParticipante).getPuntajeTotal();
    }

    private String nombreParticipante(int codParticipante) {
        return juego.getParticipantes().get(codParticipante).getNombre();
    }

    private String numerosAleatorios() {
        return Arrays.toString(juego.getNivel().getSerie().getNumerosAletorios());
    }

    private int cargaNumerosUsuario() {
        int tamaño = juego.getNivel().getSerie().getTamaño();
        String[] arreglo = new String[22];
        arreglo[0] = BJ1.textProperty().getValue();
        arreglo[1] = BJ2.textProperty().getValue();
        arreglo[2] = BJ3.textProperty().getValue();
        arreglo[3] = BJ4.textProperty().getValue();
        arreglo[4] = BJ5.textProperty().getValue();
        arreglo[5] = BJ6.textProperty().getValue();
        arreglo[6] = BJ7.textProperty().getValue();
        arreglo[7] = BJ8.textProperty().getValue();
        arreglo[8] = BJ9.textProperty().getValue();
        arreglo[9] = BJ10.textProperty().getValue();
        arreglo[10] = BJ11.textProperty().getValue();
        arreglo[11] = BJ12.textProperty().getValue();
        arreglo[12] = BJ13.textProperty().getValue();
        arreglo[13] = BJ14.textProperty().getValue();
        arreglo[14] = BJ15.textProperty().getValue();
        arreglo[15] = BJ16.textProperty().getValue();
        arreglo[16] = BJ17.textProperty().getValue();
        arreglo[17] = BJ18.textProperty().getValue();
        arreglo[18] = BJ19.textProperty().getValue();
        arreglo[19] = BJ20.textProperty().getValue();
        arreglo[20] = BJ21.textProperty().getValue();
        arreglo[21] = BJ22.textProperty().getValue();

        int[] arregloNum = new int[22];
        for (int i = 0; i < tamaño; i++) {
            if ("".equals(arreglo[i])) {
                arregloNum[i] = 0;
            } else {
                arregloNum[i] = Integer.parseInt(arreglo[i]);
            }
        }

        for (int i = 0; i < tamaño; i++) {
            juego.getNivel().setSerie(arregloNum[i], i);
        }

        juego.setPuntajeNivel();
        return juego.getNivel().getPuntaje();
    }

    private void limpiarCasillasNumeros() {
        BJ1.textProperty().set("");
        BJ2.textProperty().set("");
        BJ3.textProperty().set("");
        BJ4.textProperty().set("");
        BJ5.textProperty().set("");
        BJ6.textProperty().set("");
        BJ7.textProperty().set("");
        BJ8.textProperty().set("");
        BJ9.textProperty().set("");
        BJ10.textProperty().set("");
        BJ11.textProperty().set("");
        BJ12.textProperty().set("");
        BJ13.textProperty().set("");
        BJ14.textProperty().set("");
        BJ15.textProperty().set("");
        BJ16.textProperty().set("");
        BJ17.textProperty().set("");
        BJ18.textProperty().set("");
        BJ19.textProperty().set("");
        BJ20.textProperty().set("");
        BJ21.textProperty().set("");
        BJ22.textProperty().set("");
    }

}
