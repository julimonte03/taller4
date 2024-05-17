package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primerNodo;
    private Nodo ultimNodo;
    private int size;

    private class Nodo {
        private Nodo anterior;
        private Nodo siguiente;
        private T elemento;
    }

    public ListaEnlazada() {
        this.size = 0;
        this.primerNodo = null;
        this.ultimNodo = null;
    }

    public int longitud() {
        return size;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.elemento = elem;
    
        if (this.primerNodo == null) {
            this.primerNodo = nuevoNodo;
            this.ultimNodo = nuevoNodo;
        } else {
            nuevoNodo.siguiente = this.primerNodo;
            this.primerNodo.anterior = nuevoNodo;
            this.primerNodo = nuevoNodo;
        }
    
        this.size+=1;
    }
    

    public void agregarAtras(T elem) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.elemento = elem;
    
        if (this.primerNodo == null) {
            this.primerNodo = nuevoNodo;
            this.ultimNodo = nuevoNodo;
        } else {
            nuevoNodo.anterior = this.ultimNodo;
            this.ultimNodo.siguiente = nuevoNodo;
            this.ultimNodo = nuevoNodo;
        }
    
        this.size+=1;
    }

    public T obtener(int i) {
        Nodo nuevoNodo = primerNodo;

        for (int j = 0; j < i; j++) {
            nuevoNodo = nuevoNodo.siguiente;
        }
        return nuevoNodo.elemento;
    }
    

    public void eliminar(int i) {
        // lista vacía?
        if (this.primerNodo != null) {

        if (i == 0) {
            this.primerNodo = this.primerNodo.siguiente;
            if (this.primerNodo != null) {
                this.primerNodo.anterior = null;
            } else {
                this.ultimNodo = null; 
            }
            this.size--;
            return;
        }
    
        Nodo nuevoNodo = this.primerNodo;
        for (int j = 0; j < i; j++) {
            nuevoNodo = nuevoNodo.siguiente;
        }
    
        if (nuevoNodo.anterior != null) {
            nuevoNodo.anterior.siguiente = nuevoNodo.siguiente;
        }
        if (nuevoNodo.siguiente != null) {
            nuevoNodo.siguiente.anterior = nuevoNodo.anterior;
        }
    
        nuevoNodo = null;
    
        this.size--;   
        }
    }
    

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada<T> copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
