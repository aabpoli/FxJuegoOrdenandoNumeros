package Modelo;

import java.util.Arrays;

/**
 * Clase Serie
 * Esta clese crea un objeto tipo serie que
 * contiene 3 series de numeros (arreglos), la primera con numeros aleatorios,
 * la segunda con los numeros ordenados por la aplicación y la 
 * tercera con los numeros ordenados por el usuario.
 * @author Alons
 */
public class Serie {

    int tamaño;
    int[] numerosAletorios;
    int[] numerosOrdenados;
    int[] numerosUsuario;

    /** 
     * Metodo Construtor de la clase SerieNumerica, 
     * recibe un valor que es el tamaño de la seria a trabajar
     * @param tamaño valor numerico
     */
    public Serie(int tamaño) {
        this.tamaño = tamaño;
        numerosAletorios = new int[this.tamaño];
        numerosUsuario = new int[this.tamaño];
        nAleatorios(this.tamaño);
        nOrdenados();
    }

    /** 
     * Metodo nAleatorios, 
     * este metodo rellena el arreglo numerosAleatorios[], con numeros seleccionados randonicamente.
     * @param cantidad
     */   
    private void nAleatorios(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            numerosAletorios[i] = (int) (Math.random() * 98 + 1);
        }
    }

    /** 
     * Metodo nOrdenados, este metodo copia el arreglo numerosAleatorios[], 
     * en el arreglo numerosOrdenados
     * y posteriormente lo ordena.
     */   
    private void nOrdenados() {
        numerosOrdenados = Arrays.copyOf(numerosAletorios,numerosAletorios.length);
        Arrays.sort(numerosOrdenados);
    }

    /** 
     * Metodo getTamaño, 
     * retorna el tamaño de la serie de cada arreglo de la serie, 
     * @return Entero
     */   
    public int getTamaño() {
        return tamaño;
    }

    /** 
     * Metodo getNumerosAletorios, 
     * retorna la serie (arreglo) de numeros aleatorios que debe ordenar el participante
     * @return Arreglo de enteros
     */    
    public int[] getNumerosAletorios() {
        return numerosAletorios;
    }

    /** 
     * Metodo getNumerosOrdenados, 
     * retorna la serie (arreglo) de numeros ordenados para comparar con la serie ordenada por el usuario
     * @return Arreglo de enteros
     */       
    public int[] getNumerosOrdenados() {
        return numerosOrdenados;
    }

    /** 
     * Metodo getNumerosUsuario, 
     * retorna la serie (arreglo) de numeros ordenados por el participante
     * @return Arreglo de enteros
     */    
    public int[] getNumerosUsuario() {
        return numerosUsuario;
    }

        /** 
     * Metodo setNumerosUsuario, 
     * Modifica el numero en la posición de ordenamiento dado por el participante
     * @param valor a insertar
     * @param posicion del valor
     */
    public void setNumerosUsuario(int valor, int posicion) {
        this.numerosUsuario[posicion] = valor;
    }
  
}
