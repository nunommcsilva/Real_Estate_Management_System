package aedtrabalhopratico.CommonFiles.SortSearch;

import aedtrabalhopratico.CommonFiles.LinkedLists.LinkedNode;

/**
 *
 * @author Nuno
 */
public class SearchingLinkedList {

    public static <T extends Comparable<? super T>> boolean
            linearSearch(LinkedNode<T> head, T target) {

        LinkedNode<T> index = head;

        boolean found = false;

        while (!found && index != null) {
            if (index.getElement().compareTo(target) == 0) {
                found = true;
            }
            index = index.getNext();
        }
        return found;
    }

    public static <T extends Comparable<? super T>> void
            selectionSort(LinkedNode<T> head) {
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

}
