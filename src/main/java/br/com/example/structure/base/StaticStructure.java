package br.com.example.structure.base;

public class StaticStructure<T> {

	protected T[] elements;
	protected int size;

	@SuppressWarnings("unchecked")
	public StaticStructure(int capacidade) {
		this.elements = (T[]) new Object[capacidade]; // solution from the 'Effective Java Book'
		this.size = 0;
	}

	public StaticStructure() {
		this(10);
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	protected boolean add(T element) {
		this.increaseCapacity();
		if (this.size < this.elements.length) {
			this.elements[this.size] = element;
			this.size++;
			return true;
		}
		return false;
	}

	protected boolean add(int position, T element) {

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
