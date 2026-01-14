package examen;

public class Entry<K, V> {

    K key;
    V value;
    Entry<K, V> next; // referencia al siguiente nodo (encadenamiento)

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}