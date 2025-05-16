package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo raiz;
    private int cardinal; //cantidad de elementos


    private class Nodo {
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;

        Nodo(T v) {
            valor = v;
            izq = null;
            der = null;
            padre = null;
        }
    }

    public ABB() {
        raiz = null;
        cardinal = 0;
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo(){
        if(cardinal == 0){
            return null;
        }else {
            Nodo res = null;
            Nodo actual = this.raiz;
            while (actual.izq != null) {
                actual = actual.izq;
            }
            res = actual;
            return res.valor;
        }
    }

    public T maximo(){
        if(cardinal == 0){
            return null;
        }else {
            Nodo res = null;
            Nodo actual = this.raiz;
            while (actual.der != null) {
                actual = actual.der;
            }
            res = actual;
            return res.valor;
        }
    }

    public void insertar(T elem){
        if(!pertenece(elem)){
            if(raiz == null){
                raiz.valor = elem;
            }else{
                Nodo actual = this.raiz;
                if(actual == null){
                    Nodo nuevo = new Nodo(elem);
                    nuevo.padre = actual.padre;
                }else if(actual.valor.compareTo(elem) > 0){
                    actual = actual.izq;
                    insertar(elem);
                }else{
                    actual = actual.der;
                    insertar(elem);
                }
            }
        }
        cardinal += 1;
    }

    public boolean pertenece(T elem){
        if (cardinal == 0){
            return false;
        }else if(raiz.valor == elem){
            return true;
        }else{
            Nodo actual = this.raiz;
            if(actual.valor.compareTo(elem) > 0){
                actual = actual.izq;
                return pertenece(elem);
            }else{
                actual = actual.der;
                return pertenece(elem);
            }
        }
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
