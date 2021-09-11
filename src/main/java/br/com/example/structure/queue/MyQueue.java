package br.com.example.structure.queue;

public class MyQueue<T> {

    protected T[] elements;
    protected int size;

	public MyQueue() {
	    this(10);
	}

	@SuppressWarnings("unchecked")
	public MyQueue(int capacity) {
        this.elements = (T[]) new Object[capacity]; // solution from the 'Effective Java Book'
        this.size = 0;
	}

	public void enqueue(T element) {
        this.increaseCapacity();
        if (this.size < this.elements.length) {
            this.elements[this.size] = element;
            this.size++;
        }
	}

	public T peek() {
		if (this.isEmpty()) {
			return null;
		}
		return this.elements[0];
	}

	public T dequeue() {
		final int POS = 0;
		if (this.isEmpty()) {
			return null;
		}
		T elementToRemove = this.elements[POS];
		this.remove(POS);
		return elementToRemove;
	}

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    protected void remove(int position) {
        if (!(position >= 0 && position < size)) {
            throw new IllegalArgumentException("Invalid Position");
        }
        for (int i = position; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
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
