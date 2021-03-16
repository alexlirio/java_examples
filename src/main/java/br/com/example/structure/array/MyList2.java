package br.com.example.structure.array;

import br.com.example.structure.base.StaticStructure;

public class MyList2<T> extends StaticStructure<T> {

	public MyList2(int capacity) {
		super(capacity);
	}

	public MyList2() {
		super();
	}

	public boolean add(T element) {
		return super.add(element);
	}

	public boolean add(int position, T element) {
		return super.add(position, element);
	}

	public void remove(int position) {
		super.remove(position);
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
