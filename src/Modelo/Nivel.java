/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * Clase Nivel
 * Es el nivel jugado por cada cliente
 * @author Alons
 */
public class Nivel {

    private int numero = 0;
    private Serie serie;
    private int puntaje = 0;

    /** 
     * Metodo Construtor de la clase Nivel
     * La clase Nivel permite crear los objetos de cada Nivel, 
     * que contienen un objeto Serie de numeros a ordenar en cada nivel
     * @param numero un valor numerico
     */     
    public Nivel(int numero) {
        this.serie = new Serie(((numero * 2) + 2));
        this.numero = numero;
    }

    /** 
     * Metodo getNumero
     * Este metodo permite leer el numero de nivel del juego. 
     * @return Entero
     */    
    public int getNumero() {
        return numero;
    }

    /** 
     * Metodo getSerie
     * Este metodo permite leer la serie a ordenar y ordenada por el participante. 
     * @return Serie, con los valores numericos a ordenar y ordenados por el participante
     */    
    public Serie getSerie() {
        return serie;
    }

    /** 
     * Metodo setPuntaje
     * Este metodo permite inserta un valor en la serie ordenada por el participante. 
     * @return entero, valor del puntaje obtenido en este nivel
     */    
    public int getPuntaje() {
        return puntaje;
    }

    /** 
     * Metodo setSerie
     * Este metodo permite inserta un valor en la serie ordenada por el participante. 
     * @param valor numero a insertar en el arreglo ordenado por el participante
     * @param posicion Posición en la cual se debe insertar el valor
     */    
    public void setSerie(int valor, int posicion) {
        this.serie.setNumerosUsuario(valor, posicion);
    }

    /** 
     * Metodo setPuntaje
     * Este metodo permite calcular el puntaje de la Serie 
     * de numeros ordenados en el nivel 
     */    
    public void setPuntaje() {
        int tamaño = this.serie.getTamaño();
        int premioArreglo = tamaño * 10;
        int puntosNumeros = 0;  
                
        for (int i = 0; i < tamaño; i++) {
            if (this.serie.getNumerosOrdenados()[i] == this.serie.getNumerosUsuario()[i]) {
                puntosNumeros = puntosNumeros + 10;
            } else {
                premioArreglo = 0;
            }
        }
        this.puntaje = premioArreglo + puntosNumeros;
    }
}