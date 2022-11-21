package bridge.domain.map;

import bridge.domain.game.CrossingDecision;
import bridge.domain.player.MovementCommand;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

	protected static List<String> upperBridgeDescription = new ArrayList<>();
	protected static List<String> underBridgeDescription = new ArrayList<>();

	private BridgeMap() {
	}

	public static BridgeMap constructedBy(CrossingDecision crossingDecision, MovementCommand movementCommand){
		buildMapDescription(crossingDecision, movementCommand);
		return new BridgeMap();
	}

	private static void buildMapDescription(CrossingDecision crossingDecision, MovementCommand movementCommand) {
		String crossingMark = MovementDescription.of(crossingDecision).getMark();
		List<String> crossingSide = BridgeSideDescription.of(movementCommand).getSide();
		List<String> nonCrossingSide = BridgeSideDescription.of(movementCommand).getOtherSide();

		if (crossingSide.isEmpty()) {
			buildFromBeginning(crossingMark, crossingSide, nonCrossingSide);
			return;
		}
		buildFollowingBeginning(crossingMark, crossingSide, nonCrossingSide);
	}

	private static void buildFromBeginning(String crossingMark, List<String> crossingSide, List<String> nonCrossingSide) {
		crossingSide.add(String.format("[ %s ]", crossingMark));
		nonCrossingSide.add("[   ]");
	}

	private static void buildFollowingBeginning(String crossingMark, List<String> crossingSide, List<String> nonCrossingSide) {
		fixMapDescription(crossingSide);
		fixMapDescription(nonCrossingSide);

		crossingSide.add(String.format("| %s ]", crossingMark));
		nonCrossingSide.add("|   ]");
	}

	private static void fixMapDescription(List<String> side) {
		int prevElementIdx = side.size() - 1;
		String preElement = side.get(prevElementIdx);
		int idxToLastCharacter = preElement.length() - 1;

		side.set(prevElementIdx, preElement.substring(0, idxToLastCharacter));
	}

	public static void clearBridgeDescription(){
		upperBridgeDescription.clear();
		underBridgeDescription.clear();
	}

	public List<String> getUpperBridgeDescription() {
		return upperBridgeDescription;
	}

	public List<String> getUnderBridgeDescription() {
		return underBridgeDescription;
	}
}
