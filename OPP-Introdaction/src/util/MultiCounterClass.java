package util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class MultiCounterClass implements MultiCounter {

	public HashMap<Object, Integer> items = new HashMap<>();
	public TreeMap<Integer, Set<Object>> itemsByValue = new TreeMap<>();

	@Override
	public Integer addItem(Object item) {
		int count = items.merge(item, 1, (x, y) -> x + y);
		itemsByValue.computeIfAbsent(count, key -> new HashSet<>()).add(item);
		if (count > 1) {
			removeFromItemsByValue(item, count--);
		}
		return count;
	}

	private void removeFromItemsByValue(Object item, int count) {
		Set<Object> itemsInItemsByValue = itemsByValue.get(count);
		itemsInItemsByValue.remove(item);
		itemsByValue.put(count, itemsInItemsByValue);
		if (itemsInItemsByValue.isEmpty()) {
			itemsByValue.remove(count);
		}
	}

	@Override
	public boolean remove(Object item) {
		Integer count = items.remove(item);
		removeFromItemsByValue(item, count);
		return count != null;
	}

	@Override
	public Set<Object> getMaxItems() {
		return itemsByValue.lastEntry().getValue();
	}

	@Override
	public Integer getValue(Object item) {
		return items.get(item);
	}

}