package bridge.controller;

import bridge.service.GameEndService;
import bridge.service.GameService;
import bridge.util.InputViewConst;
import bridge.util.OutputViewConst;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private final InputController inputController;
	private final GameService gameService;
	private final OutputView outputView;
	private final GameEndService gameEndService;

	public BridgeGame(InputController inputController, GameService gameService, OutputView outputView,
		GameEndService gameEndService) {
		this.inputController = inputController;
		this.gameService = gameService;
		this.outputView = outputView;
		this.gameEndService = gameEndService;
	}

	public void startApplication() {

		inputController.startGame();
		Integer attemptCount = 0;
		Integer bridgeSize = inputController.getBridgeSize();
		gameService.makeBridge(bridgeSize);
		String userResult;
		do {
			userResult = move(bridgeSize);
			attemptCount++;
			if (userResult.equals(OutputViewConst.SUCCESS)) {
				break;
			}
		} while (!retry());
		//여기부터 게임을 나가는 경우다

		//게임 최종결과 출력
		outputView.printMap(gameEndService.getUserMap(), bridgeSize);
		//게임 성공 여부 출력, 총시도한 횟수 출력
		outputView.printResult(userResult, attemptCount); // 이거 경우의 수 나눠서 판단해야함, 지금은 임시
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public String move(Integer bridgeSize) {
		boolean validMove;
		Integer currentCount = 0;
		do {
			String userMoving = inputController.getUserMoving();
			validMove = gameService.checkValidSpace(userMoving, currentCount);
			if (validMove == false) {
				return OutputViewConst.FAIL;
			}
			currentCount++;
			gameService.saveUserSpace(userMoving);
		} while (currentCount != bridgeSize);//다리에 끝까지 도착했는지 진행한 다리 사이즈로 체크
		//만약 움직일수 있는 곳이 아니면 break 게임 종료,-> 그리고 재시작 할것인지 물음
		return OutputViewConst.SUCCESS;
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry() {
		String userRestartCommand = inputController.getUserRestartCommand();
		return userRestartCommand.equals(InputViewConst.QUIT);
	}
}
