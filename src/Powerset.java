import java.util.HashSet;

/* Generic power set class */

public class Powerset {
	private static Powerset powerset;
	
	private Powerset() {}
	
	public static Powerset get() {
		if (powerset == null)
			powerset = new Powerset();
		return powerset;
	}
	
	public <T> HashSet<HashSet<T>> powerset(HashSet<T> set) {
		HashSet<HashSet<T>> power_set = new HashSet<>();
		
		// Adding the empty set
		power_set.add(new HashSet<>());
		
		for (T item : set) {
			// cloning set but without item
			HashSet<T> temp = new HashSet<>();
			temp.addAll(new HashSet<>(set));
			temp.remove(item);
			
			HashSet<HashSet<T>> temp_powerset = powerset(temp);
						
			// add item to each subset without and with item
			for (HashSet<T> subset : temp_powerset) {
				power_set.add(new HashSet<>(subset));
				subset.add(item);
				power_set.add(new HashSet<>(subset));
			}
						
			// exit loop early if power_set has size 2^n (n = cardinality of power_set)
			if (power_set.size() == (int) Math.pow(2, power_set.size())) {
				break;
			}
		}
		
		return power_set;
	}
}
