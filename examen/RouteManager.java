package examen;

public class RouteManager<T extends Package<?>> implements IContainer<T> {

    private Node<T> head;
    private Node<T> tail;
    private Node<T> current; // punto actual de la ruta

    public RouteManager() {
        head = null;
        tail = null;
        current = null;
    }

    /**
     * Inserta un nuevo paquete al final de la ruta - Complejidad: O(1)
     */
    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    /**
     * Elimina un paquete de la ruta.
     * O(1) si se tiene la referencia directa,
     * O(n) si se busca por valor.
     */
    @Override
    public boolean remove(T element) {
        Node<T> temp = head;

        while (temp != null) {
            if (temp.data.equals(element)) {

                if (temp.prev != null)
                    temp.prev.next = temp.next;
                else
                    head = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;
                else
                    tail = temp.prev;

                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * Busca un paquete por su ID.
     * Complejidad: O(n)
     */
    @Override
    public T get(String id) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.getId().equals(id)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    // Navega al siguiente punto de la ruta
    public void moveNext() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    // Navega al punto anterior de la ruta
    public void movePrev() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }
}