package bridge.domain.result;

import bridge.domain.game.BridgeGame;
import bridge.domain.game.CrossingDecision;
import bridge.domain.player.MovementCommand;

import java.util.List;
import java.util.stream.Collectors;

public class ResultDescription {

	private static String BridgeDescription;
	private static String upperBridgeDescription;
	private static String underBridgeDescription;

	private ResultDescription(CrossingDecision crossingDecision, MovementCommand movementCommand) {
		resultDescription(crossingDecision, movementCommand);
		upperBridgeDescription = upperBridgeDescription();
		underBridgeDescription = downBridgeDescription();
		BridgeDescription = combineBridge();
	}

	public static ResultDescription generatedBy(CrossingDecision crossingDecision, MovementCommand movementCommand) {
		return new ResultDescription(crossingDecision, movementCommand);
	}


	public void resultDescription(CrossingDecision crossingDecision, MovementCommand movementCommand) {
		String crossingMark = MovementDescription.of(crossingDecision).getMark();
		List<String> passingSide = SideDescription.of(movementCommand).getSide();
		List<String> nonPassingSide = SideDescription.of(movementCommand).getOtherSide();

		buildDescription(crossingMark, passingSide, nonPassingSide);
	}

	private void buildDescription(String crossingMark, List<String> passingSide, List<String> nonPassingSide) {
		if (passingSide.isEmpty()) {
			buildFromBeginning(crossingMark, passingSide, nonPassingSide);
			return;
		}
		buildFollowingBeginning(crossingMark, passingSide, nonPassingSide);
	}

	private static void fixFormatting(List<String> side) {
		int prevElementIdx = side.size()-1;
		String preElement = side.get(prevElementIdx);
		int idxToLastCharacter = preElement.length()-1;

		side.set(prevElementIdx, preElement.substring(0, idxToLastCharacter));
	}

	private static void buildFollowingBeginning(String crossingMark, List<String> passingSide, List<String> nonPassingSide) {
		fixFormatting(passingSide);
		fixFormatting(nonPassingSide);

		passingSide.add(String.format("| %s ]", crossingMark));
		nonPassingSide.add("|   ]");
	}

	private static void buildFromBeginning(String crossingMark, List<String> passingSide, List<String> nonPassingSide) {
		passingSide.add(String.format("[ %s ]", crossingMark));
		nonPassingSide.add("[   ]");
	}

	public String upperBridgeDescription() {
		return BridgeGame.upperBridge.stream()
				.map(String::toString).collect(Collectors.joining());
	}

	public String downBridgeDescription() {
		return String.join("", BridgeGame.underBridge);
	}

	public String combineBridge(){
		return upperBridgeDescription + "\n" + underBridgeDescription;
	}

	public static String getBridgeDescription() {
		return BridgeDescription;
	}
}
