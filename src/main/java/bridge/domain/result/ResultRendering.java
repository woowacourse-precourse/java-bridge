package bridge.domain.result;

import bridge.domain.game.CrossingDecision;
import bridge.domain.game.Map;
import bridge.domain.player.MovementCommand;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ResultRendering {

	private static final String RESULT_PRESENTATION = "최종 게임 결과";
	private static final String RESULT_FAIL_OR_SUCCESS = "게임 성공 여부: %s";
	private static final String RESULT_TRIAL = "총 시도한 횟수: %d";
	private static final String ENTER = "\n";
	private static final String PARAGRAPH = "\n\n";

	private static String BridgeDescription;
	private static String upperBridgeDescription;
	private static String underBridgeDescription;

	private ResultRendering(CrossingDecision crossingDecision, MovementCommand movementCommand) {
		renderEachResult(crossingDecision, movementCommand);

		upperBridgeDescription = constructUpperBridgeMap();
		underBridgeDescription = constructUnderBridgeMap();
		BridgeDescription = constructTotalBridgeMap();
	}

	public static ResultRendering generatedBy(CrossingDecision crossingDecision, MovementCommand movementCommand) {
		return new ResultRendering(crossingDecision, movementCommand);
	}

	public void renderEachResult(CrossingDecision crossingDecision, MovementCommand movementCommand) {
		String crossingMark = MovementDescription.of(crossingDecision).getMark();
		List<String> passingSide = BridgeSideDescription.of(movementCommand).getSide();
		List<String> nonPassingSide = BridgeSideDescription.of(movementCommand).getOtherSide();

		buildDescription(crossingMark, passingSide, nonPassingSide);
	}

	public static String renderFinalResult(HashMap<String, Integer> gameResult) {
		return RESULT_PRESENTATION + ENTER
				+ BridgeDescription + PARAGRAPH
				+ String.format(RESULT_FAIL_OR_SUCCESS, gameResult.keySet().toArray()[0]) + ENTER
				+ String.format(RESULT_TRIAL, (Integer) gameResult.values().toArray()[0]);
	}

	private void buildDescription(String crossingMark, List<String> passingSide, List<String> nonPassingSide) {
		if (passingSide.isEmpty()) {
			buildFromBeginning(crossingMark, passingSide, nonPassingSide);
			return;
		}
		buildFollowingBeginning(crossingMark, passingSide, nonPassingSide);
	}

	private static void fixFormatting(List<String> side) {
		int prevElementIdx = side.size() - 1;
		String preElement = side.get(prevElementIdx);
		int idxToLastCharacter = preElement.length() - 1;

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

	public String constructUpperBridgeMap() {
		return Map.upperBridgeDescription.stream()
				.map(String::toString).collect(Collectors.joining());
	}

	public String constructUnderBridgeMap() {
		return String.join("", Map.underBridgeDescription);
	}

	public String constructTotalBridgeMap() {
		return upperBridgeDescription + ENTER + underBridgeDescription;
	}

	public static String getBridgeDescription() {
		return BridgeDescription;
	}
}
