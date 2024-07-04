/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA;

/**
 *
 * @author esteb
 */
public class Pila<T> {
    // Atributos

    private Nodo<T> top;

    // Constructor para crear una pila
    public Pila() { // objeto pila totalmente vacia
        top = null;
    }

    // Otro metodos
    // Verifica si una pila esta vacia

    public boolean isEmpty() {
        return top == null;
    }

    // push() - Apilar: Añade un elemento en la cima de la pila

    public void push(T elemento) {
        Nodo<T> nuevoNodo = new Nodo(elemento, null);
        if (isEmpty()) {
            top = nuevoNodo;
        } else { // la pila no esta vacia
            nuevoNodo.setSgteNodo(top);
            top = nuevoNodo;
        }
    }

    // pop() - desapilar: Sacar un elemento de la pila

    public T pop() {
        if (!isEmpty()) {
            // eliminar el nodo de la cima
            T elemento = top.getElemento();
            top = top.getSgteNodo();
            return elemento;
        } else {
            throw new RuntimeException("ERROR: no es posible desapilar");
        }

    }

    public T top() {
        if (!isEmpty()) {
            return top.getElemento();
        } else {
            throw new RuntimeException("ERROR: no es posible devolver cima");
        }
    }

    public int longitud() {
        int i = 0;
        Nodo<T> aux = top;
        while (aux != null) {
            aux = aux.getSgteNodo();
            i++;
        }
        return i;
    }
    
    public Pila<T> clonar() {
        Pila<T> pilaAux = new Pila<>();
        Pila<T> nuevaPila = new Pila<>();

        // Paso 1: Vaciar la pila original en la pila auxiliar
        while (!this.isEmpty()) {
            pilaAux.push(this.pop());
        }

        // Paso 2: Volver a llenar la pila original y llenar la nueva pila
        while (!pilaAux.isEmpty()) {
            T elemento = pilaAux.pop();
            this.push(elemento);  // Restaurar la pila original
            nuevaPila.push(elemento);  // Llenar la nueva pila
        }

        return nuevaPila;
    }
    
}
