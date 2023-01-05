package util;

import java.util.function.*;

public interface Collection<T> extends Iterable<T> {
	boolean add(T element);

	boolean remove(T pattern);

	boolean removeIf(Predicate<T> predicate);

	boolean isEmpty();

	int size();

	boolean contains(T pattern);
	default boolean isEqual(T sms1, T sms2) {
		return sms1 == null ? sms1 == sms2 : sms1.equals(sms2);
	}
	T[] toArray(T[] ar);
}