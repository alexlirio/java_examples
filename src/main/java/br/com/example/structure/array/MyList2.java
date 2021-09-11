package br.com.example.structure.array;

public class MyList2<T> {

    protected T[] elements;
    protected int size;

    @SuppressWarnings("unchecked")
	public MyList2(int capacity) {
	    this.elements = (T[]) new Object[capacity]; // solution from the 'Effective Java Book'
	    this.size = 0;
	}

	public MyList2() {
		super();
	}

	public boolean add(T element) {
        this.increaseCapacity();
        if (this.size < this.elements.length) {
            this.elements[this.size] = element;
            this.size++;
            return true;
        }
        return false;
	}

	public boolean add(int position, T element) {
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

	public void remove(int position) {
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

	public T get(int position) {
		if (!(position >= 0 && position < size)) {
			throw new IllegalArgumentException("Invalid Position");
		}
		return elements[position];
	}

	public int indexOf(T element) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
}
