package bridge.domain;

import static bridge.domain.ResultMessageStatus.*;

import java.util.ArrayList;
import java.util.List;

import bridge.BridgeRandomNumberGenerator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
	private final List<String> bridge;
	private final List<ResultMessageStatus> resultMessageStatuses;
	private int gameStage;
	private int tryCount;

	public BridgeGame(int bridgeSize) {
		this.bridge = bridgeMaker.makeBridge(bridgeSize);
		this.resultMessageStatuses = new ArrayList<>();
		this.gameStage = 0;
		this.tryCount = 1;
	}

	/**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
	public ResultStatus move(String command) {
		String bridgeCommand = bridge.get(gameStage);
		ResultMessageStatus moveResultMessage = makeResultMessageStatus(bridgeCommand, command);
		resultMessageStatuses.add(moveResultMessage);
		gameStage += 1;
		return ResultStatus.makeResultStatus(bridgeCommand, command);
	}

	/**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
	public void retry() {
		gameStage = 0;
		tryCount += 1;
		resultMessageStatuses.clear();
	}

	public boolean isFinish(ResultStatus resultStatus, int bridgeSize) {
		return resultStatus == ResultStatus.FAILURE || gameStage == bridgeSize;
	}
}
