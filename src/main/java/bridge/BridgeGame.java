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
	private static final String ENTER = "\n";

	public static List<String> upperBridge = new ArrayList<>();
	public static List<String> downBridge = new ArrayList<>();
	private ResultDescription resultDescription;

	private void BridgeGame(List<String> bridge) {
		this.resultDescription = resultDescription;
	}

	public void play(InputView inputView, BridgeMaker bridgeMaker) {
		OutputView.printGameInfo(GAME_START_INFO + ENTER);

		OutputView.printRequest(REQUEST_BRIDGE_SIZE);
		Bridge bridge = new Bridge(inputView.readBridgeSize(), bridgeMaker);
	}

}
