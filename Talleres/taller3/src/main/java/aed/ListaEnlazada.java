package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int size;

    private class Nodo {
        T valor;
        Nodo sig;
        Nodo ant;
        Nodo(T elem) {
            this.valor = elem;
        }
    }

    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
    }

    public int longitud() {
        return this.size;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (longitud() == 0) {
            primero = nuevo;
            ultimo = nuevo;
        }else {
            nuevo.sig = primero;
            primero.ant = nuevo;
            primero = nuevo;
        }
        this.size += 1;  
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (longitud() == 0) {
            primero = nuevo;
            ultimo = nuevo;
        }else {
            nuevo.ant = ultimo;
            ultimo.sig = nuevo;
            ultimo = nuevo;
            }
        this.size += 1;
    }

    public T obtener(int i) {
        if (i == 0) {
            return this.primero.valor;
        }else {
            Nodo res = null;
            Nodo actual = primero;
            for (int j = 0; j < i; j++){
                actual = actual.sig;
            }
            res = actual;
            return res.valor;
        }
    }

    public void eliminar(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, T elem) {
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
