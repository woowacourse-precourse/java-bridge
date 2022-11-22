package bridge.service;

import static bridge.domain.ResultMessageStatus.*;

import java.util.ArrayList;
import java.util.List;

import bridge.BridgeGame;
import bridge.domain.ResultMessageStatus;
import bridge.domain.ResultStatus;

public class BridgeService {

	private final List<ResultMessageStatus> resultMessageStatuses;
	private BridgeGame bridgeGame;
	private int tryCount;

	public BridgeService() {
		resultMessageStatuses = new ArrayList<>();
		tryCount = 1;
	}

	public void createBridgeGame(int bridgeSize) {
		bridgeGame = new BridgeGame(bridgeSize);
	}

	public ResultStatus moveService(String command) {
		String bridgeCommand = bridgeGame.move();
		ResultMessageStatus moveResultMessage = makeResultMessageStatus(bridgeCommand, command);
		resultMessageStatuses.add(moveResultMessage);
		return ResultStatus.makeResultStatus(bridgeCommand, command);
	}

	public void retryService() {
		bridgeGame.retry();
		tryCount += 1;
		resultMessageStatuses.clear();
	}

	public List<ResultMessageStatus> getResultMessageStatuses() {
		return resultMessageStatuses;
	}

	public int getTryCount() {
		return tryCount;
	}

	public boolean isFinish(ResultStatus resultStatus, int bridgeSize) {
		return resultStatus == ResultStatus.FAILURE || bridgeGame.isFinishGameStage(bridgeSize);
	}
}
