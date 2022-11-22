package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Constants.X;

public class Map {

	private final List<List<String>> map;

	public Map() {
		this.map = new ArrayList<>();
		init();
	}

	public void init() {
		map.clear();
		map.add(new ArrayList<>());
		map.add(new ArrayList<>());
	}

	public void addUp(String answer) {
		map.get(0).add(answer);
	}

	public void addDown(String answer) {
		map.get(1).add(answer);
	}

	public int getSize() {
		return map.get(0).size();
	}

	public boolean containX() {
		for (List<String> map : this.map) {
			if (map.contains(X)) {
					return true;
			}
		}
		return false;
	}

	public List<List<String>> getMap() {
		return map;
	}
}
