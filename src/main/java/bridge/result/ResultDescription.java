package bridge.result;

import bridge.BridgeGame;
import bridge.Movement;

import java.util.List;
import java.util.stream.Collectors;

public class ResultDescription {

	private static String BridgeDescription;
	private static String upperBridgeDescription;
	private static String underBridgeDescription;

	private ResultDescription(boolean passable, Movement movement) {
		resultDescription(passable, movement);
		upperBridgeDescription = upperBridgeDescription();
		underBridgeDescription = downBridgeDescription();
		BridgeDescription = combineBridge();
	}

	public static ResultDescription generatedBy(boolean passable, Movement movement) {
		return new ResultDescription(passable, movement);
	}


	public void resultDescription(boolean passable, Movement movement) {
		String crossingMark = MovementDescription.of(passable).getMark();
		List<String> passingSide = SideDescription.of(movement).getSide();
		List<String> nonPassingSide = SideDescription.of(movement).getOtherSide();

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
