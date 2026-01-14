package examen;

public class PrioritySorter {

    /**
     * Insertion Sort.
     * Eficiente para listas pequeñas o por asi decirlo casi ordenadas.
     * Complejidad: O(n²) peor caso.
     */
    public static void insertionSort(Package<?>[] packages) {
        for (int i = 1; i < packages.length; i++) {
            Package<?> key = packages[i];
            int j = i - 1;

            while (j >= 0 && packages[j].getPriority() > key.getPriority()) {
                packages[j + 1] = packages[j];
                j--;
            }
            packages[j + 1] = key;
        }
    }

    /**
     * Selection Sort.
     * Siempre O(n2), pero con menos intercambios.
     */
    public static void selectionSort(Package<?>[] packages) {
        for (int i = 0; i < packages.length; i++) {
            int min = i;
            for (int j = i + 1; j < packages.length; j++) {
                if (packages[j].getPriority() < packages[min].getPriority()) {
                    min = j;
                }
            }
            Package<?> temp = packages[min];
            packages[min] = packages[i];
            packages[i] = temp;
        }
    }
}