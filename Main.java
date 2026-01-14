package examen;

public class Main {
    public static void main(String[] args) {

        // CREAR PAQUETESS
        Package<String> p1 = new Package<>("PK1", "Laptop", Package.Type.FRAGILE, 1);
        Package<String> p2 = new Package<>("PK2", "Ropa", Package.Type.STANDARD, 3);
        Package<String> p3 = new Package<>("PK3", "Documentos", Package.Type.EXPRESS, 2);

        // RUTAS
        RouteManager<Package<?>> route = new RouteManager<>();
        route.add(p1);
        route.add(p2);
        route.add(p3);

        // INVENTARIO
        InventoryMap<String, Package<?>> inventory = new InventoryMap<>(10);
        inventory.put(p1.getId(), p1);
        inventory.put(p2.getId(), p2);
        inventory.put(p3.getId(), p3);

        System.out.println("******Consulta rápida por ID *****");
        System.out.println(inventory.get("PK2"));

        // ORDENAMIENTO
        Package<?>[] packages = { p1, p2, p3 };

        PrioritySorter.insertionSort(packages);

        System.out.println("\n****Ordenados por prioridad*****");
        for (Package<?> p : packages) {
            System.out.println(p);
        }
    }
}
