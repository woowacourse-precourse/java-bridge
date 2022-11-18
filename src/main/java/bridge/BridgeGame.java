package bridge;

import bridge.result.ResultDescription;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

	private static final String GAME_START_INFO = "다리 건너기 게임을 시작합니다.";
	private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
	private static final String REQUEST_MOVEMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String REQUEST_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	private static final String RESULT_PRESENTATION = "최종 게임 결과";
	private static final String RESULT_FAIL_OR_SUCCESS = "게임 성공 여부: %s";
	private static final String RESULT_TRIAL = "총 시도한 횟수: %d";
	private static final String ENTER = "\n";
	private static final String DOUBLE_ENTER = "\n\n";

	private List<String> bridgeNowCrossing;
	private boolean passable;
	public static List<String> upperBridge = new ArrayList<>();
	public static List<String> underBridge = new ArrayList<>();
	private String commandChoice;
	private String failOrSuccess = "실패";
	private int trialCount;


	public void play(InputView inputView, BridgeMaker bridgeMaker) {
		OutputView.printGameInfo(GAME_START_INFO + ENTER);

		OutputView.printRequest(REQUEST_BRIDGE_SIZE);
		Bridge bridge = new Bridge(inputView.readBridgeSize(), bridgeMaker);

		crossingTrialStart(inputView, bridge);

		OutputView.printGameInfo(RESULT_PRESENTATION + ENTER + ResultDescription.getBridgeDescription()
				+ DOUBLE_ENTER + String.format(RESULT_FAIL_OR_SUCCESS, failOrSuccess)
				+ ENTER + String.format(RESULT_TRIAL, trialCount));
	}

	private void crossingTrialStart(InputView inputView, Bridge bridge) {
		bridgeNowCrossing = bridge.getBridgeToCross();
		do {
			trialCount++;
			crossBridge(inputView);
			retryOrQuit(inputView, bridge);
		} while (continueToRetry());
	}

	private void crossBridge(InputView inputView) {
		do {
			OutputView.printRequest(REQUEST_MOVEMENT);
			Movement movement = inputView.readMovement();
			judgement(movement, bridgeNowCrossing);
			passThrough();
			OutputView.printGameInfo(ResultDescription.generatedBy(passable, movement).getBridgeDescription() + ENTER);

		} while (continueToPassThrough());
	}

	private void judgement(Movement movement, List<String> bridge) {
		passable = movement.side().equals(bridge.get(0));
	}

	private void passThrough() {
		if (passable) {
			bridgeNowCrossing.remove(0);
		}
	}

	private boolean continueToPassThrough() {
		return !(ResultDescription.getBridgeDescription().contains("X") || completeCrossing());
	}

	private boolean continueToRetry() {
		return !(completeCrossing() || GameCommand.COMMAND_QUIT.equals(commandChoice));
	}

	private void retryOrQuit(InputView inputView, Bridge bridge) {
		if (completeCrossing() || GameCommand.COMMAND_QUIT.equals(requestRetry(inputView).getGameCommand())) {
			commandChoice = GameCommand.COMMAND_QUIT;
			return;
		}
		upperBridge.clear();
		underBridge.clear();
		bridgeNowCrossing = bridge.getBridgeToCross();
	}

	public GameCommand requestRetry(InputView inputView) {
		OutputView.printRequest(REQUEST_RETRY);
		return inputView.readGameCommand();
	}

	private boolean completeCrossing() {
		failOrSuccess = "성공";
		return (bridgeNowCrossing.isEmpty());
	}
}
