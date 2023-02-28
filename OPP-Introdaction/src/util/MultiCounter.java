package util;

import java.util.Set;

public interface MultiCounter {
	
	Integer addItem(Object item);

	Integer getValue(Object item);

	boolean remove(Object item) ;
	
	Set<Object> getMaxItems();
}