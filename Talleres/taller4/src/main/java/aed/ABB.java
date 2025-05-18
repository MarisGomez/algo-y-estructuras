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

    public Nodo(T v){
        this.valor = v;
        this.izq = null;
        this.der = null;
        this.padre = null;
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
        }else{
            Nodo actual = this.raiz;
            while (actual.izq != null) {
                actual = actual.izq;
            }
            return actual.valor;
        }
    }

    public T maximo(){
        if(cardinal == 0){
            return null;
        }else {
            Nodo actual = this.raiz;
            while (actual.der != null) {
                actual = actual.der;
            }
            return actual.valor;
        }
    }

    public void insertar(T elem){
        if(!pertenece(elem)){
            this.raiz =  insertarRec(this.raiz, null, elem);
            cardinal ++;
        }
    }
    private Nodo insertarRec(Nodo nodo, Nodo padre, T elem){
        if(nodo == null){
            Nodo nuevo = new Nodo(elem);
            nuevo.padre = padre;
            return nuevo;
        }
        if(nodo.valor.compareTo(elem) > 0){
            nodo.izq = insertarRec(nodo.izq, nodo, elem);
        }else{
            nodo.der = insertarRec(nodo.der, nodo, elem);
        }
        return nodo;
    }

    public boolean pertenece(T elem){
        return perteneceRec(this.raiz, elem);
    }

    private boolean perteneceRec(Nodo nodo, T elem){
        if(nodo == null){
            return false;
        }
        if(nodo.valor.compareTo(elem) == 0){
            return true;
        }else if(nodo.valor.compareTo(elem) > 0){
            return perteneceRec(nodo.izq, elem);
        }else{
            return perteneceRec(nodo.der, elem);
        }
    }

    public void eliminar(T elem){
        if(pertenece(elem)){
            this.raiz = eliminarRec(this.raiz, elem);
            cardinal --;
        }
    }

    private Nodo eliminarRec(Nodo nodo, T elem){
        if(nodo == null){
            return null;
        }
        if(nodo.valor.compareTo(elem) > 0){
            nodo.izq = eliminarRec(nodo.izq, elem);
        }else if(nodo.valor.compareTo(elem) < 0){
            nodo.der = eliminarRec(nodo.der, elem);
        }else{
            if (nodo.izq == null && nodo.der == null){ //caso sin hijos
                return null;
            }else if(nodo.izq == null){ //caso1 un solo hijo
                nodo.der.padre = nodo.padre;
                return nodo.der;
            }else if(nodo.der == null){ //caso2 un solo hijo
                nodo.izq.padre = nodo.padre;
                return nodo.izq;
            }else{ //caso dos hijos
                Nodo sucesor = encontrarMin(nodo.der);
                nodo.valor = sucesor.valor; 
                nodo.der = eliminarRec(nodo.der, sucesor.valor);
            }
        }
        return nodo;
    }

    public Nodo encontrarMin(Nodo nodo) {
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }

    public String toString(){
        if(this.cardinal == 0){
            return "{}";
        }else{
            String conjunto = "{";
            Nodo nodo = encontrarMin(this.raiz);
            while(nodo != null){
                conjunto += nodo.valor;
                if(sucesorNodo(nodo) != null){
                    conjunto += ",";
                }
                nodo = sucesorNodo(nodo);
            }
            conjunto += "}";
            return conjunto;
        }
    }


    public Nodo sucesorNodo(Nodo nodo) {
        if (nodo.der != null) {
            return encontrarMin(nodo.der);
        }else{
            Nodo padre = nodo.padre;
            while (padre != null && nodo == padre.der) {
                nodo = padre;
                padre = padre.padre;
            }
            return padre;
        }
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo actual;

        public ABB_Iterador(){
            this.actual = encontrarMin(raiz);
        }

        public boolean haySiguiente() {            
            return this.actual != null;
        }
    
        public T siguiente() {
            Nodo ACTUAL = this.actual;
            this.actual = sucesorNodo(actual);
            return ACTUAL.valor;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
