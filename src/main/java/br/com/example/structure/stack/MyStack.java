package br.com.example.structure.stack;

public class MyStack<T> {

    protected T[] elements;
    protected int size;

	public MyStack() {
	    this(10);
	}

	@SuppressWarnings("unchecked")
	public MyStack(int capacity) {
        this.elements = (T[]) new Object[capacity]; // solution from the 'Effective Java Book'
        this.size = 0;
	}

	public void push(T element) {
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
		return this.elements[size - 1];
	}

	public T pop() {
		if (this.isEmpty()) {
			return null;
		}

//		T element = this.elements[size - 1];
//		size--;
//		return element;

		return this.elements[--size];
	}

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
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
