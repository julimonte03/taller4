package aed;

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
        return this.size;
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
    
        this.size++;
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
    
        this.size++;
    }

    public T obtener(int i) {
        Nodo nuevoNodo = primerNodo;

        for (int j = 0; j < i; j++) {
            nuevoNodo = nuevoNodo.siguiente;
        }
        return nuevoNodo.elemento;
    }

    public void eliminar(int i) {
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
        
            if (nuevoNodo == this.ultimNodo) {
                this.ultimNodo = nuevoNodo.anterior;
            }
        
            nuevoNodo = null;
        
            this.size--;   
        }
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo nuevoNodo = primerNodo;
        for(int i = 0; i < indice; i++){
            nuevoNodo = nuevoNodo.siguiente;
        }

        nuevoNodo.elemento = elem;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> copia = new ListaEnlazada<>();
        Nodo nuevoNodo = this.primerNodo;

        while (nuevoNodo != null) {
            copia.agregarAtras(nuevoNodo.elemento); 
            nuevoNodo = nuevoNodo.siguiente;
        }

        return copia;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        this();

        Nodo nodoOriginal = lista.primerNodo;
        while (nodoOriginal != null) {
            this.agregarAtras(nodoOriginal.elemento);
            nodoOriginal = nodoOriginal.siguiente;
        }
    }
    
    @Override
    public String toString() {
        if (primerNodo == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("["); 
        Nodo nodoActual = primerNodo;

        while (nodoActual != null) {
            result.append(nodoActual.elemento);
            nodoActual = nodoActual.siguiente;
            if (nodoActual != null) {
                result.append(", ");
            }
        }

        result.append("]");
        return result.toString();
    }

    private class ListaIterador implements Iterador<T> {
        private Nodo actual = primerNodo;
        private Nodo ultimoRetornado = null;

        @Override
        public boolean haySiguiente() {
            return actual != null;
        }

        @Override
        public T siguiente() {

            ultimoRetornado = actual;
            T dato = actual.elemento;
            actual = actual.siguiente;
            return dato;
        }

        @Override
        public boolean hayAnterior() {
            return actual != null && actual.anterior != null;
        }

        @Override
        public T anterior() {

            actual = ultimoRetornado;
            T dato = actual.elemento;
            ultimoRetornado = ultimoRetornado.anterior;
            return dato;
        }
    }


    public Iterador<T> iterador() {
        return new ListaIterador();
    }
}
