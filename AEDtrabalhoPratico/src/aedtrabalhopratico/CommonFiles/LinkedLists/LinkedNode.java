package aedtrabalhopratico.CommonFiles.LinkedLists;

/**
 * @param <T>
 * @author Nuno
 */
public class LinkedNode<T> {

    public T element;
    public LinkedNode<T> next;

    public LinkedNode() {
        element = null;
        next = null;
    }

    public LinkedNode(T elemento) {
        element = elemento;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "\nLinkedNo\n{" + "\nelement=" + element + ", \n\nnext=\n" + next + '}';
    }

}
