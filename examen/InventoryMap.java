package examen;

public class InventoryMap<K, V> {

    private int capacity;
    private Entry<K, V>[] table;

    @SuppressWarnings("unchecked")
    public InventoryMap(int capacity) {
        this.capacity = capacity;
        // Arreglo de listas enlazadas (Entry)
        table = new Entry[capacity];
    }

    /**
     * Convierte la clave en un índice válido.
     */
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Inserta o actualiza un elemento en la tabla.
     * Complejidad promedio: O(1)
     */
    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> head = table[index];

        // Si la clave ya existe se actualiza el valor
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Inserción al inicio de la lista (encadenamiento)
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> head = table[index];

        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }
}