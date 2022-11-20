package bridge.controller;

import bridge.service.GameService;
import bridge.util.GameConst;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private final InputController inputController;
	private final GameService gameService;
	private final OutputView outputView;

	public BridgeGame(InputController inputController, GameService gameService, OutputView outputView) {
		this.inputController = inputController;
		this.gameService = gameService;
		this.outputView = outputView;

	}

	public void startApplication() {
		Integer bridgeSize = getBridgeSize();
		gameService.makeBridge(bridgeSize);
		Integer attemptCount = 0;
		String userResult;
		do {
			userResult = move(bridgeSize);
			attemptCount++;
		} while (userResult.equals(GameConst.FAIL) && retry());
		printResult(attemptCount, userResult);
	}

	private Integer getBridgeSize() {
		inputController.startGame();
		Integer bridgeSize = inputController.getBridgeSize();
		return bridgeSize;
	}

	private void printResult(Integer attemptCount, String userResult) {
		outputView.printFinalResultPhrase();
		outputView.printMap(gameService.getUserBridgeStatus());
		outputView.printResult(userResult, attemptCount);
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public String move(Integer bridgeSize) {
		Integer currentLocation = 0;
		do {
			String userLocation = inputController.getUserMoving();
			if (!gameService.checkValidSpace(userLocation, currentLocation)) {
				printWrongUserMap(userLocation);
				return GameConst.FAIL;
			}
			printCorrectMap(userLocation);
			currentLocation++;
		} while (!currentLocation.equals(bridgeSize));
		return GameConst.SUCCESS;
	}

	private void printCorrectMap(String userLocation) {
		outputView.printMap(gameService.saveUserCorrectSpace(userLocation));
	}

	private void printWrongUserMap(String userLocation) {
		outputView.printMap(gameService.saveUserWrongSpace(userLocation));
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry() {
		String userRestartCommand = inputController.getUserRestartCommand();
		if (userRestartCommand.equals(GameConst.QUIT)) {
			return false;
		}
		gameService.clearUserBridge();
		return true;
	}
}
