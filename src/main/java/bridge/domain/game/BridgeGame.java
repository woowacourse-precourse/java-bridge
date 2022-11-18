package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridgeMaker.BridgeMaker;
import bridge.domain.player.GameProceedCommand;
import bridge.domain.result.ResultDescription;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

	private static final String GAME_START_INFO = "다리 건너기 게임을 시작합니다.";
	private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
	private static final String REQUEST_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	private static final String RESULT_PRESENTATION = "최종 게임 결과";
	private static final String RESULT_FAIL_OR_SUCCESS = "게임 성공 여부: %s";
	private static final String RESULT_TRIAL = "총 시도한 횟수: %d";
	private static final String ENTER = "\n";
	private static final String DOUBLE_ENTER = "\n\n";

	public static List<String> upperBridge = new ArrayList<>();	// map
	public static List<String> underBridge = new ArrayList<>();	// map
//	private String commandChoice;
	private String crossComplete = "실패";	// 얘가 고유
	private int trialCount;					// 얘가 고유

	public void play(InputView inputView, BridgeMaker bridgeMaker) {
		OutputView.printGameInfo(GAME_START_INFO + ENTER);

		OutputView.printRequest(REQUEST_BRIDGE_SIZE);
		Bridge bridge = new Bridge(inputView.readBridgeSize(), bridgeMaker);

		crossingTrial(inputView, bridge);

		OutputView.printGameInfo(RESULT_PRESENTATION + ENTER + ResultDescription.getBridgeDescription()
				+ DOUBLE_ENTER + String.format(RESULT_FAIL_OR_SUCCESS, crossComplete)
				+ ENTER + String.format(RESULT_TRIAL, trialCount));
	}

	private void crossingTrial(InputView inputView, Bridge bridge) {
		do {
			trialCount++;
			List<String> bridgeNowCrossing = bridge.getBridgeToCross();
			CrossingBridge crossingBridge = CrossingBridge.over(inputView, bridgeNowCrossing);
			crossComplete = crossingBridge.isCrossComplete();

		} while (isTrialContinue(retryOrQuit(inputView)));
	}

	private boolean isTrialContinue(String commandChoice) {
		return !(crossComplete.equals("성공") || GameProceedCommand.CQUIT.equals(commandChoice));
	}

	private String retryOrQuit(InputView inputView) {
		String commandChoice = "";
		if (crossComplete.equals("성공") || GameProceedCommand.CQUIT.equals(requestRetry(inputView).getGameCommand())) {
			 commandChoice = GameProceedCommand.CQUIT;
			return commandChoice;
		}
		upperBridge.clear();
		underBridge.clear();
		return commandChoice;
	}

	public GameProceedCommand requestRetry(InputView inputView) {
		OutputView.printRequest(REQUEST_RETRY);
		return inputView.readGameCommand();
	}
}
