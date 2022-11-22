package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridgeMaker.BridgeMaker;
import bridge.domain.player.BridgeSizeCommand;
import bridge.domain.player.CommandReader;
import bridge.domain.player.GameProceedCommand;
import bridge.view.input.InputCommandReader;
import bridge.view.output.OutputView;

import java.util.HashMap;
import java.util.List;

public class BridgeGame {

	private static final String GAME_START_INFO = "다리 건너기 게임을 시작합니다.";
	private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
	private static final String REQUEST_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

	public static final String RESULT_SUCCESS = "성공";
	public static final String RESULT_FAIL = "실패";

	private String crossFailOrSuccess;
	private int trialCount;

	public void play(BridgeMaker bridgeMaker) {
		OutputView.withContentOf(GAME_START_INFO, false, true).ConsoleMessage();

		OutputView.withContentOf(REQUEST_BRIDGE_SIZE, false, false).ConsoleMessage();
		Bridge bridge = new Bridge((BridgeSizeCommand) InputCommandReader.read(CommandReader.BRIDGE_SIZE).command(), bridgeMaker);

		crossingTrial(bridge);
	}

	private void crossingTrial(Bridge bridge) {
		do {
			trialCount++;
			List<String> bridgeNowCrossing = bridge.getBridgeToCross();
			CrossingBridge crossingBridge = CrossingBridge.over(bridgeNowCrossing);
			crossFailOrSuccess = crossingBridge.isCrossComplete();
		} while (isTrialContinue(retryOrQuit()));
	}

	private boolean isTrialContinue(String commandChoice) {
		return !(crossFailOrSuccess.equals(RESULT_SUCCESS) || GameProceedCommand.QUIT.equals(commandChoice));
	}

	private String retryOrQuit() {
		String commandChoice = "";
		if (crossFailOrSuccess.equals(RESULT_SUCCESS) || GameProceedCommand.QUIT.equals(requestRetry().getGameCommand())) {
			commandChoice = GameProceedCommand.QUIT;
			return commandChoice;
		}
		Map.underBridgeDescription.clear();
		Map.upperBridgeDescription.clear();
		return commandChoice;
	}

	public GameProceedCommand requestRetry() {
		OutputView.withContentOf(REQUEST_RETRY, true, false).ConsoleMessage();
		return (GameProceedCommand) InputCommandReader.read(CommandReader.GAME_PROCEED).command();
	}

	public HashMap<String, Integer> getGameResult() {
		HashMap<String, Integer> gameResult = new HashMap<>();
		gameResult.put(crossFailOrSuccess, trialCount);
		return gameResult;
	}
}
