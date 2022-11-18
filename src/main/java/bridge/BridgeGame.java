package bridge;

import bridge.result.ResultDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private static final String GAME_START_INFO = "다리 건너기 게임을 시작합니다.";
	private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
	private static final String REQUEST_MOVEMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String REQUEST_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	private static final String ENTER = "\n";

	private List<String> bridgeNowCrossing;
	private boolean passable;
	public static List<String> upperBridge = new ArrayList<>();
	public static List<String> underBridge = new ArrayList<>();
	private ResultDescription resultDescription;
	private String commandChoice;



	private void BridgeGame(List<String> bridge) {
		this.resultDescription = resultDescription;
	}

	public void play(InputView inputView, BridgeMaker bridgeMaker) {
		OutputView.printGameInfo(GAME_START_INFO + ENTER);

		OutputView.printRequest(REQUEST_BRIDGE_SIZE);
		Bridge bridge = new Bridge(inputView.readBridgeSize(), bridgeMaker);

		crossingTrialStart(inputView, bridge);
	}

	private void crossBridge(InputView inputView) {
		do {
			OutputView.printRequest(REQUEST_MOVEMENT);
			Movement movement = inputView.readMovement();
			judgement(movement, bridgeNowCrossing);
			passThrough();
			resultDescription = ResultDescription.generatedBy(passable, movement);
			OutputView.printGameInfo(resultDescription.getBridgeDescription()+ENTER);

		} while (continueToPassThrough(resultDescription));
	}

	private void judgement(Movement movement, List<String> bridge) {
		passable = false;
		if (movement.side().equals(bridge.get(0))) {
			passable = true;
		}
	}

	private void passThrough() {
		if (passable == true) {
			bridgeNowCrossing.remove(0);
		}
	}

	private boolean continueToPassThrough(ResultDescription resultDescription) {
		return !(resultDescription.getBridgeDescription().contains("X") || completeCrossing());
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

	private void crossingTrialStart(InputView inputView, Bridge bridge) {
		bridgeNowCrossing = bridge.getBridgeToCross();
		do {
			crossBridge(inputView);
			retryOrQuit(inputView, bridge);
		} while (continueToRetry());
	}


	public GameCommand requestRetry(InputView inputView) {
		OutputView.printRequest(REQUEST_RETRY);
		return inputView.readGameCommand();
	}

	private boolean completeCrossing() {
		return (bridgeNowCrossing.isEmpty());
	}
}
