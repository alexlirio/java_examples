package br.com.example.structure.array;

import java.lang.reflect.Array;

public class MyList<T> {

	private T[] elements;
	private int size;

	@SuppressWarnings("unchecked")
	public MyList(int capacity) {
		this.elements = (T[]) new Object[capacity]; // solution from the 'Effective Java Book'
		this.size = 0;
	}

	public MyList(){
		this(10);
	}

	@SuppressWarnings("unchecked")
	public MyList(int capacity, Class<T> classeType){
		this.elements = (T[]) Array.newInstance(classeType, capacity);
		this.size = 0;
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

	// 0 1 2 3 4 5 6 = the size is 5
	// B C E F G + +
	//
	public boolean add(int position, T element) {

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
		return this.elements[position];
	}

	public int indexOf(T element) {
		for (int i = 0; i < this.size; i++) {
			if (this.elements[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(T element) {

		for (int i = this.size - 1; i >= 0; i--) {
			if (this.elements[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	public boolean has(T element) {

//		int position = getIndexOf(element);
//		if (position > -1) {
//			return true;
//		}
//		return false;

		return indexOf(element) > -1; // >=0
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

	public void remove(T element) {
		int pos = this.indexOf(element);
		if (pos > -1) {
			this.remove(pos);
		}
	}

	public void clean() {
		// option 1
		// this.elements = (T[]) new Object[this.elements.length];

		// option 2
		// this.size = 0;

		// option 3
		for (int i = 0; i < this.size; i++) {
			this.elements[i] = null;
		}
		this.size = 0;
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
