package bridge.domain.result;

import bridge.domain.game.Map;
import bridge.domain.player.MovementCommand;

import java.util.Arrays;
import java.util.List;

public enum BridgeSideDescription {

	upperSide("U", Map.upperBridgeDescription, Map.underBridgeDescription),
	underSide("D", Map.underBridgeDescription, Map.upperBridgeDescription);

	private final String sideSymbol;
	private final List<String> side;
	private final List<String> otherSide;

	BridgeSideDescription(String sideSymbol, List<String> side, List<String> otherSide) {
		this.sideSymbol = sideSymbol;
		this.side = side;
		this.otherSide = otherSide;
	}

	public static BridgeSideDescription of(MovementCommand movementCommand) {
		return Arrays.stream(values())
				.filter(checkSide -> checkSide.sideSymbol.equals(movementCommand.side()))
				.findFirst()
				.orElseThrow(IllegalAccessError::new);
	}

	public List<String> getSide() {
		return side;
	}

	public List<String> getOtherSide() {
		return otherSide;
	}
}

