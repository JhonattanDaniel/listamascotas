/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.modelo;

/**
 *
 * @author
 */
public class ListaSE {

    private Nodo cabeza;

    public ListaSE() {
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * Método para adicionar un nodo
     *
     * - Si tiene perros llamar a un ayudante recorrer todos los perros ,
     * mirando si tienen otro ammarrado cuando llegue al perro libre (No
     * ammarrado a otro) amarra el nuevo perro
     *
     * si no tiene perros El perro entrante Es la cabeza
     */
    public void adicionarNodo(Perro dato) {
        if (cabeza == null) {
            //No tiene perros
            cabeza = new Nodo(dato);
        } else {
            // tiene perros
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            //Ubicado o parado en el último
            temp.setSiguiente(new Nodo(dato));

        }
    }

    /**
     * Método que sirve para contar la cantidad de elementos de la Lista SE
     *
     * @return int cantidad de elementos
     */
    public int contarNodos() //cabeza
    {
        if (cabeza != null) {
            Nodo temp = cabeza;
            int cont = 1;
            while (temp.getSiguiente() != null) //Mientras el lazo este lleno
            {
                temp = temp.getSiguiente(); // Ayudante pase al siguiente perro
                cont++;
            }
            return cont;
        } else {
            return 0;
        }
    }

    /**
     * Método que adiciona un nodo al inicio
     *
     * @param perro Dato a agregar *
     */
    public void adicionarNodoAlInicio(Perro perro) {
        if (cabeza != null) {
            Nodo temp = new Nodo(perro);
            temp.setSiguiente(cabeza);
            cabeza = temp;
        } else {
            cabeza = new Nodo(perro);
        }
    }

    /**
     * Método que permite intercambiar los datos de los extremos de la lista *
     */
    public void intercambiarExtremos() {
        if (cabeza != null) {
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            /// Parado en el último nodo
            Perro perrotemp = cabeza.getDato();
            cabeza.setDato(temp.getDato());
            temp.setDato(perrotemp);
        }
    }

    public void invertir() {
        if (cabeza != null) {
            ListaSE listaTemporal = new ListaSE();
            Nodo temp = cabeza;
            while (temp != null)//Recorre de principio a fin
            {
                listaTemporal.adicionarNodoAlInicio(temp.getDato());
                temp = temp.getSiguiente();//Ayudante pase al siguiente perro
            }
            cabeza = listaTemporal.getCabeza();
        }
    }

    public void eliminarNodo(byte id) {
        Nodo temp = cabeza.getSiguiente();
        Nodo tempA = cabeza;
        if (tempA.getDato().getNumero() == id) {
            if (tempA.getSiguiente() == null) {
                cabeza = null;
                //  ListaDE nuevaLista = new ListaDE();

            } else {
                //Eliminar cabeza
                cabeza = temp;
                //temp.setSiguiente(cabeza);
                tempA = null;
            }
        } else {

            while (temp.getDato().getNumero() != id) {
                tempA = temp.getSiguiente();
                temp = temp.getSiguiente();
            }

            if (temp.getSiguiente() == null) {
                temp = null;

            } else {
                tempA.setSiguiente(temp.getSiguiente());
            }

        }
    }

    public Perro encontrarPosicion(int pos) {
        if (cabeza != null) {
            // if (pos <= contarNodos()) {
            int cont = 1;
            Nodo temp = cabeza;
            while (pos != cont) {
                temp = temp.getSiguiente();
                cont++;
            }
            return temp.getDato();
        }
        return null;
    }

    public void ordenarGenero(int gen) {

        Nodo temp = cabeza;
        ListaSE nuevaLista = new ListaSE();
        switch (gen) {
            case 1:
                while (temp != null) {
                    if (temp.getDato().getGenero().equalsIgnoreCase("macho")) {
                        nuevaLista.adicionarNodoAlInicio(temp.getDato());
                    } else if (temp.getDato().getGenero().equalsIgnoreCase("hembra")) {
                        nuevaLista.adicionarNodo(temp.getDato());
                    }
                    temp = temp.getSiguiente();
                    cabeza = nuevaLista.getCabeza();
                }
                break;
            case 2:
                while (temp != null) {
                    if (temp.getDato().getGenero().equalsIgnoreCase("hembra")) {
                        nuevaLista.adicionarNodoAlInicio(temp.getDato());
                    } else if (temp.getDato().getGenero().equalsIgnoreCase("macho")) {
                        nuevaLista.adicionarNodo(temp.getDato());
                    }
                    temp = temp.getSiguiente();
                    cabeza = nuevaLista.getCabeza();
                }
                break;
            default:
                break;
        }
    }

    public boolean comprobarID(Perro perroID) {
        Nodo temp = cabeza;
        while (temp != null) {

            if (temp.getDato().getNumero() == perroID.getNumero()) {
                return false;
            } else {
                temp = temp.getSiguiente();
            }
        }
        return true;
    }
}
