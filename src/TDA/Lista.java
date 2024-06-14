/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA;

/**
 *
 * @author esteb
 */
public class Lista<T> {
    // Atributos 
    private Nodo<T> cabeza;
    private Nodo<T> ultimo;

    // Metodos
    // Constructor sin parametros
    // Crear una lista vacia
    public Lista() {
        cabeza = null;
        ultimo = null;
    }

    /*
     esVacia: verifica si la lista esta vacia. Devuelve un booleano
     True: si la lista es vacia
     False: Si la lista tiene elementos
     */
    public boolean esVacia() {
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }
    }

    /*
     ** agregar: añade un elemento al final de la lista
     */
    public void agregar(T pElemento) {
        // crear un nuevo nodo
        Nodo<T> nuevoNodo = new Nodo(pElemento, null);
        // Caso 1: Cuando la lista esta vacia
        if (esVacia() == true) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        } else { // tiene uno o mas elementos
            // aux haga referencia a lo mismo que esta referenciando cabeza
            ultimo.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }

    /*
     * Mostrar los elementos de la Lista
     */
    public void mostrar() {
        Nodo<T> aux = cabeza;
        while (aux != null) {
            System.out.print(aux.getElemento() + "\t");
            // avanzo al siguiente
            aux = aux.getSgteNodo();
        }
        System.out.println("");
    }

    /*
     * Longitud: devuelve la cantidad de nodos en la lista
     */
    public int longitud() {
        int num = 0;
        Nodo<T> aux = cabeza;
        while (aux != null) {
            num++;
            // avanzo al siguiente
            aux = aux.getSgteNodo();
        }
        return num;
    }

    /*
     * iesimo: devuelve el iesimo elemento de la lista
     */
    public T iesimo(int pos) {
        T elemento = null; // -1 significa que el elemento no existe
        // Validar la posicion 
        if (pos >= 1 && pos <= longitud()) {
            int i = 1;
            Nodo<T> aux = cabeza;
            while (i < pos) {
                i++;
                aux = aux.getSgteNodo();
            }
            elemento = aux.getElemento();
            return elemento;
        }
        return elemento;
    }

    /*
     * ubicacion: devuelve la posicion de un elemento de la lista
     */
    public Integer ubicacion(T elemento) {
        Nodo<T> aux = cabeza;
        int i = 0;
        while (aux != null) {
            i++;
            if (aux.getElemento().equals(elemento)) {
                return i;
            }
            aux = aux.getSgteNodo();
        }
        return null;
    }

    /*
     * Eliminar: elimina un nodo de la lista
     */
    public void eliminar(int pos) {
        if (pos >= 1 && pos <= longitud()) {
            if (pos == 1) { // Caso 1: eliminar el primer nodo
                //Nodo<T> aux = cabeza;
                // cabeza = aux.getSgteNodo();
                cabeza = cabeza.getSgteNodo();
            } else { // eliminar un elemento que no sea el primero
                // Ubicarnos en el nodo anterior del nodo que deseo eliminar
                Nodo<T> aux = cabeza;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getSgteNodo();
                    i++;
                }
                Nodo<T> temp = aux.getSgteNodo();
                aux.setSgteNodo(temp.getSgteNodo());

            }
        }

    }

    public void eliminar(T elemento) {
        Integer pos = ubicacion(elemento);
        if (pos != null) {
            eliminar(pos);
        }
    }

    /*
     * Insertar un elemento en una determinada posicion de la lista
     */
    public void insertar(T elemento, int pos) {
        Nodo<T> nuevoNodo = new Nodo(elemento, null);
        if (pos >= 1 && pos <= longitud() + 1) {
            if (pos == 1) {
                nuevoNodo.setSgteNodo(cabeza);
                cabeza = nuevoNodo;
            } else { // pos>1
                Nodo<T> aux = cabeza;
                int posActual = 1;
                //Recorro hasta la posición pos-1
                while (posActual < pos - 1) {
                    aux = aux.getSgteNodo();
                    posActual++;
                }
                nuevoNodo.setSgteNodo(aux.getSgteNodo());
                aux.setSgteNodo(nuevoNodo);
            }
        }
    }

    public void insertarAlaDerecha(T elemento, int pos) {
        Nodo<T> nuevoNodo = new Nodo(elemento, null);
        if (pos >= 1 && pos <= longitud()) {
            if (pos == this.longitud()) {
                ultimo.setSgteNodo(nuevoNodo);
                ultimo = nuevoNodo;
            } else { // Cuando pos está entre  1 y longitud de la lista -1
                Nodo<T> aux = cabeza;
                int posActual = 1;
                //Recorro hasta la posición pos-1
                while (posActual < pos) {
                    aux = aux.getSgteNodo();
                    posActual++;
                }
                nuevoNodo.setSgteNodo(aux.getSgteNodo());
                aux.setSgteNodo(nuevoNodo);
            }
        }
    }

    /*
    Purgar elementos duplicados
     */
    public void purgarDuplicados() {
        if (!esVacia()) {
            Nodo<T> aux = cabeza;
            while (aux != null) {
                Nodo<T> aux2 = aux;
                Nodo<T> ant = aux2;
                // Recorrer los nodos para buscar un duplicado
                while (aux2.getSgteNodo() != null) {
                    aux2 = aux2.getSgteNodo();
                    if (aux.getElemento().equals(aux2.getElemento())) {
                        // hemos encontrado un duplicado
                        ant.setSgteNodo(aux2.getSgteNodo()); // elimnar nodo duplicado
                    } else {
                        // el nodo no es duplicado
                        ant = aux2;// seguimos al nodo aux2
                    }
                }
                // avanzar aux
                aux = aux.getSgteNodo();
            }

        } else {
            System.out.println("La lista esta vacia!!");
        }
    }
}
