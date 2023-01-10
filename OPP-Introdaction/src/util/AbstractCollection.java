package util;

public abstract class AbstractCollection<T> implements Collection<T> {
	protected int size;

	protected boolean isEqual(T element, T pattern) {

		return element == null ? element == pattern : element.equals(pattern);
	}

	protected AbstractCollection(Collection<T> collection) {
		for (T item : collection) {
			add(item);
		}
	}
	protected AbstractCollection() {
	};
	@Override
	public int size() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		
		return size == 0;
	}

}