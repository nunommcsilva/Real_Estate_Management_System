package aedtrabalhopratico.CommonFiles.LinkedLists;

import aedtrabalhopratico.CommonFiles.SortSearch.*;

public class LinkedList<T extends Comparable> {

    public LinkedNode<T> head;
    public int count;

    public LinkedList() {
        head = null;
        count = 0;
    }
//##############################################################################    

    public void add(T elemento) {
        LinkedNode<T> novo = new LinkedNode<>(elemento);
        if (head == null) {
            head = novo;
        } else {
            novo.setNext(head);
            head = novo;
        }
        count++;
    }
//##############################################################################    

    public T remove(T elemento) {
        T elementToRemove;
        if (head == null) {
            return null;
        }
        LinkedNode<T> current = head;
        LinkedNode<T> previous = null;
        while (current != null && !current.getElement().equals(elemento)) {
            previous = current;
            current = current.getNext();
        }
        if (current == null) {
            return null;
        }
        if (current == head) {
            head = current.getNext();
            current.setNext(null);

        } else if (current.getNext() == null) {
            previous.setNext(null);

        } else {
            previous.setNext(current.getNext());
            current.setNext(null);
        }
        count--;
        return current.getElement();
    }
//##############################################################################

    @Override
    public String toString() {
        return "\nLinkedList\n{" + "\nhead=\n" + head + '}' + "\n";
    }
//##############################################################################    

    public boolean LinkedS(T target) {

        boolean b = SearchingLinkedList.linearSearch(head, target);

        return b;
    }
//##############################################################################

    public void selectionSort() {
        SearchingLinkedList.selectionSort(this.head);
    }

}
//##############################################################################              

