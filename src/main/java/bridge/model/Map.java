package bridge.model;

import java.util.List;

public class Map {

	private final StringBuilder upstairs;
	private final StringBuilder downstairs;

	public Map() {
		this.downstairs = new StringBuilder();
		this.upstairs = new StringBuilder();
	}

	public void drawMap(List<String> footPrints) {
		downstairs.append(footPrints.get(0));
		upstairs.append(footPrints.get(1));
	}

	public String getDownstairs() {
		String value = downstairs.toString();
		return value.substring(0, value.length() - 1);
	}

	public String getUpstairs() {
		String value = upstairs.toString();
		return upstairs.substring(0, upstairs.length() - 1);
	}

}
