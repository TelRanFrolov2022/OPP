package memory;

public class MemoryOperations {
	public static int getMaxAvaibleMemory() {
		int max = Integer.MAX_VALUE;
		int res = max / 2;
		boolean running = true;
		byte ar[] = null;
		int low =0;
		int high = max - 1;

		while (running) {
			int mid = (low + high) / 2;
			try {
				ar = new byte[mid];
				low = mid + 1;
				try {
					ar = new byte[mid + 1];

				} catch (Throwable e) {
					res = mid;
					running = false;
				}

			} catch (Throwable e) {
				high = mid - 1;
			}
		}
		return res;
	}
}
