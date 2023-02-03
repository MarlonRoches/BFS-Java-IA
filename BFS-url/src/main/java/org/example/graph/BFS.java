package org.example.graph;

import javax.swing.text.html.Option;
import java.util.*;

public class BFS<T> {
    public static<T> Optional<Node<T>> search(T value, Node<T> start){
        Queue<Node<T>> queue = new ArrayDeque<>(); //cola de prioridad
        //frontera
        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> closed = new HashSet<>();

        System.out.println("-> Saliendo desde zona: " + start.getValue());
        System.out.println("-> Hasta zona: " + value);
        while (!queue.isEmpty()){ //PASO 1: verificar si puedo continuar

            //mientras no sea vacia, actual a evaluar es el que se encuentre en la cola de prioridad
            currentNode = queue.remove();
            System.out.println("visitando el nodo: "+ currentNode.getValue());

            if (currentNode.getValue().equals(value)){// PASO 2: es el que estoy buscando? se encuentra en la meta?
                //si
                System.out.println("* Llegamos a zona: " + currentNode.getValue());

                return Optional.of(currentNode);
            }else{

                closed.add(currentNode);//3- add el espacio explorado
                queue.addAll(currentNode.getNeighbors()); //4- Funcion sucesora obtengo los hijos, expandimos
                queue.removeAll(closed);// desconsiderar todos los explorados
            }
        }
        //vacia
        return Optional.empty();
    }
}
