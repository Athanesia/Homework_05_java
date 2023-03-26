// Реализовать алгоритм пирамидальной сортировки (HeapSort).


public class HeapSort_03 {

    public static void heapSort(int[] array) {
        if (array == null) {
            throw new NullPointerException("The input array is null");
        }

        if (array.length <= 0) {
            throw new IllegalArgumentException("The length of the input array is less than or equal to zero");
        }

        sort(array);
    }

    private static void sort(int[] array) {
        int n = array.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Извлечение элементов из кучи по одному
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    // Функция для перегруппировки поддерева с корнем i в куче размера n
    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень поддерева
        int left = 2 * i + 1; // Левый потомок узла i
        int right = 2 * i + 2; // Правый потомок узла i

        // Если левый потомок больше корня
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // Если правый потомок больше наибольшего элемента на данный момент
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // Если наибольший элемент не корень
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Рекурсивно вызываем heapify для поддерева с наибольшим элементом
            heapify(array, n, largest);
        }
    }
}
