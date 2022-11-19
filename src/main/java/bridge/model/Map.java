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
		downstairs.append(footPrints.get(Stairs.DOWN.getNumber()));
		upstairs.append(footPrints.get(Stairs.UP.getNumber()));
	}

	public void resetMap() {
		downstairs.setLength(0);
		upstairs.setLength(0);
	}

	public String getDownstairs() {
		return downstairs.substring(0, downstairs.length() - 1);
	}

	public String getUpstairs() {
		return upstairs.substring(0, upstairs.length() - 1);
	}

}
