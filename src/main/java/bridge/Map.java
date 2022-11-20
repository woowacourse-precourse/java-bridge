package bridge;

import java.util.ArrayList;
import java.util.List;

public class Map {
	private final List<List<String>> map;

	Map() {
		this.map = new ArrayList<>();
		map.add(new ArrayList<>());
		map.add(new ArrayList<>());
	}

	public void addUp(String answer) {
		map.get(0).add(answer);
	}

	public void addDown(String answer) {
		map.get(1).add(answer);
	}
}
