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
        Nodo actual = this.primero;
        Nodo anterior = actual.ant;
        Nodo siguiente = actual.sig;
        if (i == 0 && this.longitud()==1) {
            this.primero = null;
        }else if(i == 0 && this.longitud()>1){
            siguiente.ant = null;
            this.primero = actual.sig;
        }else if(i == this.longitud()-1){
            for(int j = 0; j<this.longitud(); j++){
                anterior = actual.ant;
                actual = actual.sig;
            }
        }else {
            for (int j = 0; j < i; j++){
                actual = actual.sig;
            }
            anterior = actual.ant;
            siguiente = actual.sig;
            anterior.sig = siguiente;
            siguiente.ant = anterior;
        }
        this.size -= 1;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = this.primero;
        Nodo anterior = actual.ant;
        Nodo siguiente = actual.sig;
        Nodo nuevoNodo = new Nodo(elem);
        if (indice == 0) {
            this.primero = nuevoNodo;
            nuevoNodo.sig = siguiente;
            nuevoNodo.ant = anterior;
        }else{
            for(int j = 0; j<this.longitud(); j++){
                if(j == indice){
                    siguiente = actual.sig;
                    anterior = actual.ant;
                    actual = nuevoNodo;
                    nuevoNodo.sig = siguiente;
                    nuevoNodo.ant = anterior;
                    anterior.sig = nuevoNodo;
                    siguiente.ant = nuevoNodo;
                }else {
                    actual = actual.sig;
                }
            }

        }
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        this.primero = lista.primero;
        this.size = lista.longitud();
    }
    
    @Override
    public String toString() {
        String secuencia = "[";
        for (int i = 0; i < this.longitud(); i++){
            secuencia += this.primero.valor;
            this.primero = this.primero.sig;
            if(i != this.longitud()-1){
                secuencia += ", ";
            }
        }
        secuencia += "]";
        return secuencia;
    }

    private class ListaIterador implements Iterador<T> {
        Nodo anterior;
        Nodo actual;
        public ListaIterador(){
            this.anterior = null;
            this.actual = primero;
        }

        public boolean haySiguiente() {
	        return this.actual != null;
        }

        public boolean hayAnterior() {
	        return this.anterior != null;
        }

        public T siguiente() {
            Nodo ACTUAL = this.actual;
            this.anterior = this.actual;
            this.actual = this.actual.sig;
            return ACTUAL.valor;
        }
        

        public T anterior() {
            Nodo ACTUAL = this.anterior;
	        this.actual = this.anterior;
            this.anterior = this.anterior.ant;
            return ACTUAL.valor;
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}
