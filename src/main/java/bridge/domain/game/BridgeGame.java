package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridgeMaker.BridgeMaker;
import bridge.domain.player.GameProceedCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class BridgeGame {

	private static final String GAME_START_INFO = "다리 건너기 게임을 시작합니다.";
	private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
	private static final String REQUEST_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	private static final String ENTER = "\n";

	public static final String RESULT_SUCCESS = "성공";
	public static final String RESULT_FAIL = "실패";

	private String crossFailOrSuccess;
	private int trialCount;

	public void play(InputView inputView, BridgeMaker bridgeMaker) {
		OutputView.printGameInfo(GAME_START_INFO + ENTER);

		OutputView.printRequest(REQUEST_BRIDGE_SIZE);
		Bridge bridge = new Bridge(inputView.readBridgeSize(), bridgeMaker);

		crossingTrial(inputView, bridge);
	}

	private void crossingTrial(InputView inputView, Bridge bridge) {
		do {
			trialCount++;
			List<String> bridgeNowCrossing = bridge.getBridgeToCross();
			CrossingBridge crossingBridge = CrossingBridge.over(inputView, bridgeNowCrossing);
			crossFailOrSuccess = crossingBridge.isCrossComplete();
		} while (isTrialContinue(retryOrQuit(inputView)));
	}

	private boolean isTrialContinue(String commandChoice) {
		return !(crossFailOrSuccess.equals(RESULT_SUCCESS) || GameProceedCommand.CQUIT.equals(commandChoice));
	}

	private String retryOrQuit(InputView inputView) {
		String commandChoice = "";
		if (crossFailOrSuccess.equals(RESULT_SUCCESS) || GameProceedCommand.CQUIT.equals(requestRetry(inputView).getGameCommand())) {
			commandChoice = GameProceedCommand.CQUIT;
			return commandChoice;
		}
		Map.underBridgeDescription.clear();
		Map.upperBridgeDescription.clear();
		return commandChoice;
	}

	public GameProceedCommand requestRetry(InputView inputView) {
		OutputView.printRequest(REQUEST_RETRY);
		return inputView.readGameCommand();
	}

	public HashMap<String, Integer> getGameResult() {
		HashMap<String, Integer> gameResult = new HashMap<>();
		gameResult.put(crossFailOrSuccess, trialCount);
		return gameResult;
	}
}
