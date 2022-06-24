/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Clase Juego La clase Juego permite crear los objetos de cada Juego
 *
 * @author Alons
 */
public class Juego {

    private Nivel nivel;
    private Map<Integer, Participante> participantes = new TreeMap<>();

    /**
     * Metodo Construtor de la clase Juego La clase Juego permite crear los
     * objetos de cada Juego, que contienen Un nivel Activo y una lista de
     * participantes
     */
    public Juego() {

    }

    /**
     * Metodo setParticipantes permite crear un nuevo objeto tipo participante y
     * adicionarlo a la lista de participantes.
     *
     * @param nombre del paticipante
     * @param codigo del paticipante
     */
    public void setParticipantes(String nombre, int codigo) {
        Participante participante = new Participante(nombre);
        participantes.put(codigo, participante);
    }

    /**
     * Metodo getNivel lee los datos del Nivel
     *
     * @return Nivel
     */
    public Nivel getNivel() {
        return nivel;
    }

    /**
     * Metodo getParticipantes lee los datos del participante
     *
     * @return un alista de participantes
     */
    public Map<Integer, Participante> getParticipantes() {
        return participantes;
    }

    /**
     * Metodo setNivel Crea un nuevo nivel de juego
     *
     * @param numNivel nuemro del nivel (1, 2, 3, 4....)
     */
    public void setNivel(int numNivel) {
        this.nivel = new Nivel(numNivel);
    }

    /**
     * Metodo setPuntajeNivel calcula y carga el puntaje recibido en un nivel de
     * juego
     */
    public void setPuntajeNivel() {
        this.nivel.setPuntaje();
    }

    /**
     * Metodo setCargaNivelParticipante Carga un nivel de juego terminado al
     * participante y calcula el puntaje acumulado y total de el participante.
     *
     * @param nParticipante codigo del paticipante
     */
    public void setCargaNivelParticipante(int nParticipante) {
        participantes.get(nParticipante).setNiveles(nivel, nivel.getNumero());
        participantes.get(nParticipante).getPuntajeTotal();
    }

    /**
     * Metodo RankinParticipantes al final del juego arma y retorna el Ranking 
     * con los tres mejores puntajes de todo el juego.
     */
    public int[][] RankingParticipantes() {
        int[][] resultado = new int[3][2];
        int auxiliar;
        int cambio;
        int posicion;
        int cambioPos;

        for (int i = 1; i <= participantes.size(); i++) {
            auxiliar = participantes.get(i).getPuntajeTotal();
            posicion = i;

            if (auxiliar > resultado[0][1]) {
                cambio = resultado[0][1];
                cambioPos = resultado[0][0]; 
                resultado[0][0] = posicion;
                resultado[0][1] = auxiliar;
                auxiliar = cambio;
                posicion = cambioPos;
            }
            if (auxiliar > resultado[1][1]) {
                cambio = resultado[1][1];
                cambioPos = resultado[1][0]; 
                resultado[1][0] = posicion;
                resultado[1][1] = auxiliar;
                auxiliar = cambio;
                posicion = cambioPos;
            }
            if (auxiliar > resultado[2][1]) {
                cambio = resultado[2][1];
                cambioPos = resultado[2][0]; 
                resultado[2][0] = posicion;
                resultado[2][1] = auxiliar;
                auxiliar = cambio;
                posicion = cambioPos;
            }
        }
        return resultado;
    }
}
