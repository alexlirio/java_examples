package br.com.example.structure.queue;

public class MyPriorityQueue<T> extends MyQueue<T> {

	public void enqueue(T element) {

		@SuppressWarnings("unchecked")
		Comparable<T> key = (Comparable<T>) element;

		int i;
		for (i = 0; i < this.size; i++) {
			if (key.compareTo(this.elements[i]) < 0) {
				break;
			}
		}
		this.enqueue(i, element);
	}

    private boolean enqueue(int position, T element) {

        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Invalid Position");
        }

        this.increaseCapacity();

        // move all elements
        for (int i = this.size - 1; i >= position; i--) {
            this.elements[i + 1] = this.elements[i];
        }
        this.elements[position] = element;
        this.size++;

        return true;
    }

    @SuppressWarnings("unchecked")
    private void increaseCapacity() {
        if (this.size == this.elements.length) {
            T[] newElements = (T[]) new Object[this.elements.length * 2];
            for (int i = 0; i < this.elements.length; i++) {
                newElements[i] = this.elements[i];
            }
            this.elements = newElements;
        }
    }
}
