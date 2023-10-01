import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Реализация алгоритма пирамидальной сортировки.");
        int[] array_for_sort = new int[]{6,6,4,3,2,7,1,5,9,0};;
        System.out.printf("Изначальный массив: %s\n",  Arrays.toString(array_for_sort));
        sort(array_for_sort);
        System.out.printf("Отсортированный массив: %s\n",  Arrays.toString(array_for_sort));
    }
    public static void sort(int[]array){
        for(int i = array.length/2 - 1; i>=0; i--){
            heapify(array, array.length, i);
        }
        for(int i = array.length - 1; i>=0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }
    private static void heapify(int[] array, int heapSize, int rootIndex){
        int largest = rootIndex;
        int leftChild = 2*rootIndex + 1;
        int rightChild = 2*rootIndex + 2;
        if(leftChild<heapSize && array[leftChild]>array[largest]) largest = leftChild;
        if(rightChild<heapSize && array[rightChild]>array[largest]) largest = rightChild;
        if(largest!=rootIndex){
            int temp =array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            heapify(array, heapSize, largest);
        }
        }
    }
