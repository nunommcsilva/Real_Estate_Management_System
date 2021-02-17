package aedtrabalhopratico.CommonFiles.LinkedLists;

/**
 * @param T
 * @author Nuno
 */
public class LinkedStack<T> implements StackADT<T> {

    public int count;
    public LinkedNode<T> head;

    public LinkedStack() {
        head = new LinkedNode<T>(null);
    }

    public void push(T element) {
        LinkedNode<T> novo = new LinkedNode<T>(element);
        if (head == null) {
            head = novo;
            count++;
        } else {
            novo.setNext(head);
            head = novo;
            count++;
        }
    }

    @Override
    public T pop() {

        if (isEmpty()) {
            System.out.println("Não existem elementos");
        }

        LinkedNode<T> current = head;

        head = head.getNext();
        current.setNext(null);
        count--;
        return current.getElement();

    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return head.getElement();
        }
    }

    @Override
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String s = "";
        LinkedNode<T> current = head;
        while (current.getNext() != null) {
            s += current.getElement().toString() + "\n";
            current = current.getNext();
        }
        return s;

    }

}
