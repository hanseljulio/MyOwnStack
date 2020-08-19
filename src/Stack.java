import java.util.*;

public class Stack<E> {
    private int top = -1;
    private E[] elements = (E[]) new Object[10];

    public void push(E value) {
        if (top >= elements.length - 1) {
            this.expandSize();
        }
        top++;
        elements[top] = value;
    }

    public E pop() {
        if (top < 0) {
            throw new EmptyStackException();
        }

        E result = elements[top];
        top--;
        return result;
    }

    public E peek() {
        if (top < 0) {
            throw new EmptyStackException();
        }

        return elements[top];
    }

    public int length() {
        return top;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void remove(int index) {
        for (int i = index; i < top; i++) {
            elements[i] = elements[i - 1];
        }
        top--;
    }

    public void removeAll(E value) {
        int numSwaps = 0;
        for(int i = 0; i <= top; i++) {
            if (elements[i].equals(value)) {
                remove(i);
                i--;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Stack<?> && ((Stack<?>) obj).length() == this.length()) {
            for (int i = 0; i < top; i++) {
                if (!((Stack<?>) obj).get(i).equals(this.get(i))) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public E get(int index) {
        if (index > top) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }



    private void expandSize() {
        int increasedSize = elements.length * 2;
        elements = Arrays.copyOf(elements, increasedSize);
    }
}
