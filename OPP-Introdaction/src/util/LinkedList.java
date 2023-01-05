package util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class LinkedList<T> implements List<T> {
	private static class Node<T> {
		T obj;
		Node<T> prev;
		Node<T> next;

		Node(T obj) {
			this.obj = obj;
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size;

	private class LinkedListIterator implements Iterator<T> {
		Node<T> current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T node = current.obj;
			current = current.next;
			return node;
		}

	}

	@Override
	public boolean add(T element) {
		Node<T> node = new Node<>(element);
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}

		size++;
		return true;
	}

	@Override
	public boolean remove(T pattern) {
		int ind = indexOf(pattern);
		if (ind > -1) {
			remove(ind);
		}
		return ind > -1;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {
		int oldSize = size;
		Node<T> current = head;
		Node<T> next = null;
		for (int i = 0; i < oldSize; i++) {
			next = current.next;
			if (predicate.test(current.obj)) {
				Node<T> nextt = current.next;
				Node<T> prevv = current.prev;
				if (prevv == null) {
					head = next;
				} else {
					prevv.next = next;
					current.prev = null;
				}
				if (next == null) {
					tail = prevv;
				} else {
					next.prev = prevv;
					current.next = null;
				}
				current.obj = null;
			}
			current = next;
		}
		return oldSize > size;

	}

	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public T[] toArray(T[] ar) {
		if (ar.length < size) {
			ar = Arrays.copyOf(ar, size);
		}
		Node<T> current = head;
		for (int i = 0; i < size; i++) {
			ar[i] = current.obj;
			current = current.next;
		}
		Arrays.fill(ar, size, ar.length, null);
		return ar;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	@Override
	public void add(int index, T element) {
		if (index == size) {
			add(element);
		} else if (index == 0) {
			addHead(element);
		} else {
			addMiddle(index, element);
		}

	}

	private void addMiddle(int index, T element) {
		Node<T> node = new Node<>(element);
		Node<T> nodeIndex = getNode(index);
		Node<T> nodePrev = nodeIndex.prev;
		nodePrev.next = node;
		node.prev = nodePrev;
		nodeIndex.prev = node;
		node.next = nodeIndex;
		size++;
	}

	private Node<T> getNode(int index) {

		return index < size / 2 ? getNodeFromLeft(index) : getNodeFromRight(index);
	}

	private Node<T> getNodeFromRight(int index) {
		Node<T> current = tail;
		for (int i = size - 1; i > index; i--) {
			current = current.prev;
		}
		return current;
	}

	private Node<T> getNodeFromLeft(int index) {
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	private void addHead(T element) {
		Node<T> node = new Node<>(element);
		node.next = head;
		head.prev = node;
		head = node;
		size++;
	}

	@Override
	public T remove(int index) {
		checkIndex(index, 0, size - 1);
		Node<T> node = getNode(index);
		T object = node.obj;
		Node<T> next = node.next;
		Node<T> prev = node.prev;
		if (prev == null) {
			head = next;
		} else {
			prev.next = next;
			node.prev = null;
		}

		if (next == null) {
			tail = prev;
		} else {
			next.prev = prev;
			node.next = null;
		}
		node.obj = null;
		size--;
		return object;
	}

	@Override
	public int indexOf(T pattern) {
		Node<T> current = head;
		int index = 0;
		while (index < size && !isEqual(current.obj, pattern)) {
			current = current.next;
			index++;
		}
		return index == size ? -1 : index;
	}

	@Override
	public int lastIndexOf(T pattern) {
		Node<T> current = tail;
		int index = size - 1;
		while (index > -1 && !isEqual(current.obj, pattern)) {
			current = current.prev;
			index--;
		}
		return index == -1 ? -1 : index;
	}

	@Override
	public T get(int index) {
		checkIndex(index, 0, size - 1);
		return getNode(index).obj;
	}

	@Override
	public void set(int index, T element) {
		checkIndex(index, 0, size - 1);
		getNode(index).obj = element;

	}

}