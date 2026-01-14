package examen;

public class Package<T> {

    // Tipos de envío soportados
    public enum Type {
        FRAGILE, STANDARD, EXPRESS
    }

    private String id;
    private T content;
    private Type type;
    private int priority;

    public Package(String id, T content, Type type, int priority) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.priority = priority;
    }

    // Identificador único del paquete
    public String getId() {
        return id;
    }

    // Prioridad usada para ordenamiento
    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Package ID: " + id + " [" + type + "]";
    }
}