package examen;

public interface IContainer<T> {

    // Agrega un elemento al contenedor
    void add(T element);

    // Elimina elemento
    boolean remove(T element);

    // Obtiene un elemento por id
    T get(String id);
}