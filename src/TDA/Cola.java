/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA;

/**
 *
 * @author esteb
 */
public class Cola<T> {
    // Atributos

    private Nodo<T> frente;
    private Nodo<T> ultimo;

    // Constructores

    public Cola() {
        frente = null;
        ultimo = null;
    }

    // Si la cola esta vacia

    public boolean esVacia() {
        if (frente == null) {
            return true;
        } else {
            return false;
        }
    }

    // encolar: agregar un nuevo elemento a al final de la cola

    public void encolar(T pElemento) {
        if (esVacia() == true) {
            Nodo<T> nuevoNodo = new Nodo(pElemento, null);
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        } else { // la cola no esta vacia
            Nodo<T> nuevoNodo = new Nodo(pElemento, null);
            ultimo.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;

        }
    }

    // desencolar: eliminar el elemento que esta al frente de la cola
    // nos devuelve el elemento eliminado

    public T desencolar() {
        if (esVacia() == false) {
            T x = frente.getElemento();
            Nodo<T> aux = frente;
            frente = aux.getSgteNodo();
            return x;
        } else {
            throw new RuntimeException("ERROR: no es posible desencolar");
        }
    }

    public T frente() {
        if (!esVacia()) {
            return frente.getElemento();
        } else {
            throw new RuntimeException("ERROR: no es posible devolver frente");
        }
    }

    public int longitud() {
        int i = 0;
        Nodo<T> aux = frente;
        while (aux != null) {
            aux = aux.getSgteNodo();
            i++;
        }
        return i;
    }
}
