package aedtrabalhopratico.CommonFiles.SortSearch;

import aedtrabalhopratico.CommonFiles.LinkedLists.*;

/**
 *
 * @author Nuno
 */

public class SortingandSearching {

    public static <T extends Comparable<? super T>> boolean
            linearSearch(T[] data, int min, int max, T target) {

        int index = min;
        boolean found = false;

        while (!found && index <= max) {
            if (data[index].compareTo(target) == 0) {
                found = true;
            }
            index++;
        }
        return found;
    }
//##############################################################################

    public static <T extends Comparable<? super T>> boolean
            binarySearch(T[] data, int min, int max, T target) {

        boolean found = false;
        int midpoint = (min + max) / 2; // determinar o midpoint
        if (data[midpoint].compareTo(target) == 0) {
            found = true;
        } else if (data[midpoint].compareTo(target) > 0) {
            if (min <= midpoint - 1) {
                found = binarySearch(data, min, midpoint - 1, target);
            }
        } else if (midpoint + 1 <= max) {
            found = binarySearch(data, midpoint + 1, max, target);
        }
        return found;
    }
//##############################################################################

    public static <T extends Comparable<? super T>> void
            selectionSort(T[] data) {

        int min;
        T temp;
        for (int index = 0; index < data.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < data.length; scan++) {
                if (data[scan].compareTo(data[min]) < 0) {
                    min = scan;
                }
            }
            /**
             * * Swap the values
             */
            temp = data[min];
            data[min] = data[index];
            data[index] = temp;
        }
    }
//##############################################################################    

    public static <T extends Comparable<? super T>> void
            selectionSortLL(LinkedNode<T> head) {

        LinkedNode<T> temp;

        for (LinkedNode<T> current = head; current.getNext() != null; current.getNext()) {
            LinkedNode<T> min = current;

            for (LinkedNode<T> scan = current.getNext(); scan != null; scan = scan.getNext()) {
                if (scan.getElement().compareTo(min.getElement()) < 0) {
                    min = scan;
                }
            }
            if (min != current) {
                temp = new LinkedNode<>(min.getElement());
                min.setElement(current.getElement());
                current.setElement(temp.getElement());
            }
        }
    }
//##############################################################################        

    public static <T extends Comparable<? super T>> void
            insertionSort(T[] data) {

        for (int index = 1; index < data.length; index++) {
            T key = data[index];
            int position = index;
            /**
             * * Shift larger values to the right
             */
            while (position > 0 && data[position - 1].compareTo(key) > 0) {
                data[position] = data[position - 1];
                position--;
            }
            data[position] = key;
        }
    }
//##############################################################################        

    public static <T extends Comparable<? super T>> void
            bubbleSort(T[] data) {

        int position, scan;
        T temp;
        for (position = data.length - 1; position >= 0; position--) {
            for (scan = 0; scan <= position - 1; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    /**
                     * * Swap the values
                     */
                    temp = data[scan];
                    data[scan] = data[scan + 1];
                    data[scan + 1] = temp;
                }
            }
        }
    }
//##############################################################################        

    public static <T extends Comparable<? super T>> void
            quickSort(T[] data, int min, int max) {        //QUICKSORT 

        int indexofpartition;
        if (max - min > 0) {
            /**
             * * Create partitions
             */
            indexofpartition = findPartition(data, min, max);
            /**
             * * Sort the left side
             */
            quickSort(data, min, indexofpartition - 1);
            /**
             * * Sort the right side
             */
            quickSort(data, indexofpartition + 1, max);
        }
    }
//##############################################################################

    private static <T extends Comparable<? super T>> int
            findPartition(T[] data, int min, int max) {

        int left, right;
        T temp, partitionelement;
        int middle = (min + max) / 2;
        // use middle element as partition
        partitionelement = data[middle];
        left = min;
        right = max;
        while (left < right) {
            /**
             * * search for an element that is > the partitionelement
             */
            while (data[left].compareTo(partitionelement) < 0) {
                left++;
            }
        }
        /**
         * * search for an element that is < the partitionelement
         */
        while (data[right].compareTo(partitionelement) > 0) {
            right--;
        }
        /**
         * * swap the elements
         */
        if (left < right) {
            temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
        return right;
    }
//##############################################################################

    public static <T extends Comparable<? super T>> void
            mergeSort(T[] data, int min, int max) {

        T[] temp;
        int index1, left, right;
        /**
         * * return on list of length one
         */
        if (min == max) {
            return;
        }
        /**
         * * find the length and the midpoint of the list
         */
        int size = max - min + 1;
        int pivot = (min + max) / 2;
        temp = (T[]) (new Comparable[size]);

        mergeSort(data, min, pivot); // sort left half of list
        mergeSort(data, pivot + 1, max); // sort right half of list
        /**
         * copy sorted data into workspace
         */
        for (index1 = 0; index1 < size; index1++) {
            temp[index1] = data[min + index1];
        }
        /**
         * merge the two sorted lists
         */
        left = 0;
        right = pivot - min + 1;
        for (index1 = 0; index1 < size; index1++) {
            if (right <= max - min) {
                if (left <= pivot - min) {
                    if (temp[left].compareTo(temp[right]) > 0) {
                        data[index1 + min] = temp[right++];
                    } else {
                        data[index1 + min] = temp[left++];
                    }
                } else {
                    data[index1 + min] = temp[right++];
                }
            } else {
                data[index1 + min] = temp[left++];
            }
        }
    }
}
//##############################################################################    
