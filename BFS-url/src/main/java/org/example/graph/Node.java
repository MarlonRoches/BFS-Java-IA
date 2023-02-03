package org.example.graph;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Node<T> {
    private T value;
    private Set<Node<T>> neighbors;

    public Node(T value){
        this.value =value;
        this.neighbors = new HashSet<>(); //
    }
    public T getValue(){
        return this.value;
    }
    public Set<Node<T>> getNeighbors(){
        return Collections.unmodifiableSet(neighbors); //lista inmutable y no falle en el debug
    }

    public void connect(Node<T> node){
        if (node == this) throw new IllegalArgumentException("Un nodo intenta referenciarse a si mismo"); //un nodo no se puede referenciar a si mismo
        this.neighbors.add(node); // el actual le agregamos el vecino
        node.neighbors.add(this); // el vecino le agregamos el actual
    }

    public String toString(){
        return this.value.toString();
    }
}
