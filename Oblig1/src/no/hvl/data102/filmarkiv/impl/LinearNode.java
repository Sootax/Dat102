package no.hvl.data102.filmarkiv.impl;

public class LinearNode<T> {
    public T data;
    public LinearNode<T> neste;

    public LinearNode(T data) {
        this.data = data;
        this.neste = null;
    }

    public T[] toArray(T[] data) {
        LinearNode<T> current = this;
        int i = 0;

        while (current != null) {
            data[i] = current.data;
            current = current.neste;
            i++;
        }

        return data;
    }
}
