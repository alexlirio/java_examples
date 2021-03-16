package br.com.example.structure.array;

public class MyArrayObject {

	private Object[] elements;
	private int size;

	public MyArrayObject(int capacity){
		this.elements = new Object[capacity];
		this.size = 0;
	}

	public boolean add(Object element) {
		this.increaseCapacity();
		if (this.size < this.elements.length) {
			this.elements[this.size] = element;
			this.size++;
			return true;
		}
		return false;
	}

	// 0 1 2 3 4 5 6 = the size is 5
	// B C E F G + +
	//
	public boolean add(int position, Object element) {

		if (!(position >= 0 && position < size)) {
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

	private void increaseCapacity() {
		if (this.size == this.elements.length) {
			Object[] newElements = new Object[this.elements.length * 2];
			for (int i = 0; i < this.elements.length; i++) {
				newElements[i] = this.elements[i];
			}
			this.elements = newElements;
		}
	}

	public Object get(int position) {
		if (!(position >= 0 && position < size)) {
			throw new IllegalArgumentException("Invalid Position");
		}
		return this.elements[position];
	}

	public int indexOf(Object element) {
		for (int i = 0; i < this.size; i++) {
			if (this.elements[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	// B D E F F -> the position to remove is 1 (G)
	// 0 1 2 3 4 -> the size is 5
	// vetor[1] = vetor[2]
	// vetor[2] = vetor[3]
	// vetor[3] = vetor[4]
	public void remove(int position) {
		if (!(position >= 0 && position < size)) {
			throw new IllegalArgumentException("Invalid Position");
		}
		for (int i = position; i < this.size - 1; i++) {
			this.elements[i] = this.elements[i + 1];
		}
		this.size--;
	}

	public int size() {
		return this.size;
	}

	@Override
	public String toString() {

		StringBuilder s = new StringBuilder();
		s.append("[");

		for (int i = 0; i < this.size - 1; i++) {
			s.append(this.elements[i]);
			s.append(", ");
		}

		if (this.size > 0) {
			s.append(this.elements[this.size - 1]);
		}

		s.append("]");

		return s.toString();
	}
}
