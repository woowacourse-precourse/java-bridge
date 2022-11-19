package bridge.controller;

import static bridge.constant.Constant.*;

import java.util.List;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.User;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

	private BridgeGame bridgeGame;

	public void run() {
		setting();
		progress();
		finish();
	}

	private void setting() {
		OutputView.printGameStart();
		User user = new User();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		Bridge bridge = new Bridge(bridgeMaker.makeBridge(InputView.readBridgeSize()));
		bridgeGame = new BridgeGame(user, bridge);
	}

	private void progress() {
		boolean end = true;
		while (end) {
			bridgeGame.move(InputView.readMoving());
			OutputView.printMap(bridgeGame.currentMap());
			end = bridgeGame.end();
		}
		if (bridgeGame.result().equals(FAIL.getConstant())) {
			retry();
		}
	}

	private void retry() {
		if (InputView.readGameCommand().equals(RETRY_COMMAND.getConstant())) {
			bridgeGame.retry();
			progress();
		}
	}

	public void finish() {
		List<List<String>> resultMap = bridgeGame.currentMap();
		String gameResult = bridgeGame.result();
		int tryCount = bridgeGame.trialCount();
		OutputView.printResult(resultMap, gameResult, tryCount);
	}
}
