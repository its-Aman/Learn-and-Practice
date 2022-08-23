import java.util.TreeMap;

/**
 * @author AmanK
 *
 */
public class My_Calendar_I_729 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		My_Calendar_I_729 mc = new My_Calendar_I_729();

//		System.out.println(mc.book(10, 20));
//		System.out.println(mc.book(15, 25));
//		System.out.println(mc.book(20, 30));
//		System.out.println(mc.book(30, 40));
//		System.out.println(mc.book(40, 50));
//		System.out.println(mc.book(50, 60));

		System.out.println(mc.book(47, 50));
		System.out.println(mc.book(33, 41));
		System.out.println(mc.book(39, 45));
		System.out.println(mc.book(33, 42));
		System.out.println(mc.book(25, 32));
		System.out.println(mc.book(26, 35));
		System.out.println(mc.book(19, 25));
		System.out.println(mc.book(3, 8));
		System.out.println(mc.book(8, 13));
		System.out.println(mc.book(18, 27));
	}

	TreeMap<Integer, Integer> times;

	public My_Calendar_I_729() {
		this.times = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		Integer next = this.times.ceilingKey(start);
		Integer prev = this.times.floorKey(start);

		if ((prev == null || this.times.get(prev) <= start) && (next == null || end <= next)) {
			this.times.put(start, end);
			return true;
		} else {
			return false;
		}
	}
}
