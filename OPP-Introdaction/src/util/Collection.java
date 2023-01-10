package util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.*;

public interface Collection<T> extends Iterable<T>{
boolean add (T element);
boolean remove(T pattern);
default boolean removeIf(Predicate<T> predicate) {
	Iterator<T> it = iterator();
	int oldSize = size();
	while(it.hasNext()) {
		T obj = it.next();
		if (predicate.test(obj)) {
			it.remove();
		}
	}
	return oldSize > size();
}
boolean isEmpty();
int size();
boolean contains(T pattern);

public default T[] toArray1(T[] array) {
	int size = size();
	if (array.length < size) {
		array = Arrays.copyOf(array, size);
	}
	Iterator<T> temp = iterator();
	for (int i = 0; i < size; i++) {
		array[i] = temp.next();
	}
	Arrays.fill(array, size, array.length, null);
	return array;
}
/*******************************/
/**
 * 
 * @param ar
 * @return array containing elements of a Collection
 * if ar refers to memory that is enough for all elements of Collection then new array is not created,
 * otherwise there will be created new array.
 * if ar refers to memory that is greater than required for all elements of Collection then all elements of the 
 * Collection will be put in the array and rest of memory will be filled by null's 
 */
}