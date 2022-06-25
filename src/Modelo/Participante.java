package Modelo;

import java.util.Map;
import java.util.TreeMap;

/**
 * Clase participante
 * Esta clase es para crear los objeto tipo participante
 * que participa en el juego
 * @author Alons
 */
public class Participante {

    private String nombre;
    private int puntajeTotal;
    private Map<Integer, Nivel> niveles = new TreeMap<>();

    /** 
     * Metodo Construtor de la clase Participante
     * permite construir el objeto participante, 
     * contienen una lista de objetos Nivel de los niveles jugados por el participante
     * @param nombre del participante
     */ 
    public Participante(String nombre) {
        this.nombre = nombre;
    }

    /** 
     * Metodo sumaPuntajeTotal
     * Este metodo calcula el puntaje total del paticipante, 
     * sumando los valores de cada nivel.
     */    
    private void sumaPuntajeTotal() {
        puntajeTotal = 0; 
        for (int i=1; i<=(niveles.size()); i++) {
            puntajeTotal = puntajeTotal + niveles.get(i).getPuntaje();
        }
    }

    /** 
     * Metodo getNiveles
     * Este metodo retorna el numero de niveles jugados por el participante, 
     * @return Entero
     */    
    public int getNiveles() {
        return niveles.size();
    }

    /** 
     * Metodo getNombre
     * Este metodo retorna el nombre del participante, 
     * @return String
     */    
    public String getNombre() {
        return nombre;
    }

    /** 
     * Metodo getPuntajeTotal
     * @return Entero con el valor del puntaje total del participante.
     */    
    public int getPuntajeTotal() {
        sumaPuntajeTotal();
        return puntajeTotal;
    }

    /** 
     * Metodo setNombre
     * Modifica el nombre del participante
     * @param nombre una cadena de caracteres
     */    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** 
     * Metodo setNiveles
     * Inserta un nuevo nivel jugado por el participante
     * @param nivel Objeto nivel
     * @param nNivel Numero de nivel
     */      
    public void setNiveles(Nivel nivel, int nNivel) {
        niveles.put(nNivel, nivel);
    }
    
}