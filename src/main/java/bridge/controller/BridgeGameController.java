package bridge.controller;

import bridge.dto.GameResultDto;
import bridge.dto.MoveCommandDto;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.StartView;

public class BridgeGameController {
	private static final StartView startView = new StartView();
	private static final OutputView outputView = new OutputView();
	private static final InputView inputView = new InputView();
	private static final BridgeGame bridgeGame = new BridgeGame();

	public void run() {
		startView.printStart();	// "다리 건너기 게임을 시작합니다."
		processBridgeSize();	// "다리의 길이를 입력해주세요."
		processMoveCommand();	// "이동할 칸을 선택해주세요. (위: U, 아래: D)"


		// "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
		boolean endOrRetryError = false;
		GameResultDto GameResultDto;
		do {
			try {
				String endOrRetry = inputView.readGameCommand();
				GameResultDto = bridgeGame.retry(endOrRetry);

				endOrRetryError = false;
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
				endOrRetryError = true;
			}
		} while (endOrRetryError);

		// "최종 게임 결과"
		//printResult();
	}

	private void processBridgeSize() {
		boolean sizeError;
		do {
			sizeError = makeBridge();
		} while (sizeError);
	}

	private boolean makeBridge() {
		try {
			String bridgeSize = inputView.readBridgeSize();
			bridgeGame.initializeBridge(bridgeSize);
			return false;
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
	}

	private void processMoveCommand() {
		boolean moveError = false;
		MoveCommandDto moveCommandDto;
		do {
			try {
				String moving = inputView.readMoving();
				moveCommandDto = bridgeGame.move(moving);
				outputView.receiveMoveCommandResult(moveCommandDto);
				outputView.printMap();
				moveError = false;
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
				moveError = true;
			}
		} while (moveError);
	}
}
