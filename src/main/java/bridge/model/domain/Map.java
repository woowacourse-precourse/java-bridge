package bridge.model.domain;

import java.util.List;

import bridge.model.validation.Stairs;

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
		resetStairs(downstairs);
		resetStairs(upstairs);
	}

	public String getDownstairs() {
		return removeEndChar(downstairs);
	}

	public String getUpstairs() {
		return removeEndChar(upstairs);
	}

	private void resetStairs(StringBuilder stringBuilder) {
		stringBuilder.setLength(0);
	}

	private String removeEndChar(StringBuilder stringBuilder) {
		return stringBuilder.substring(0, stringBuilder.length() - 1);
	}

}
