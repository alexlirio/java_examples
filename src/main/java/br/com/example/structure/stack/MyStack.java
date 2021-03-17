package br.com.example.structure.stack;

import br.com.example.structure.base.StaticStructure;

public class MyStack<T> extends StaticStructure<T> {

	public MyStack() {
		super();
	}

	public MyStack(int capacity) {
		super(capacity);
	}

	public void push(T element) {
		super.add(element);
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
}
