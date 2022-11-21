package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.GameCommand;
import bridge.domain.User;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

public class GameManager {
  private User user;
  private BridgeGame bridgeGame;

  public GameManager() {
    user = new User();
    bridgeGame = new BridgeGame(user);
  }

  public void run() {
    printGameStartMessage();
    try {
      gameStart();
    } catch (IllegalArgumentException e) {
      printErrorMessage(e);
    }
  }

  private void gameStart() {
    int length = readBridgeSize();
    printBlankLine();
    do {
      bridgeGame.gameInit(length);
      tryMove(); // 시도가 끝날 때 까지 이동
    } while (!checkIsGameFinish());
    printResult();
  }

  private void tryMove() {
    while (!bridgeGame.isTryFinish()) {
      bridgeGame.move(readMoving());
      bridgeGame.showResult();
    }
  }

  private boolean checkIsGameFinish() {
    if (!bridgeGame.isTrySuccess()) { // 시도 실패
      return !checkRetryByInput(readGameCommand()); // 재시도 여부 질문
    }
    return true;
  }

  private boolean checkRetryByInput(String input) {
    if (input.equals(GameCommand.RETRY.getCommand())) {
      return true;
    }
    return false;
  }

  private void printResult() {
    printFinalResult(user.getMoveStatus(), bridgeGame.getBridgeShapes());
    printGameSuccessOrFailure(bridgeGame.isTrySuccess());
    printTotalTryCount(user.getTryCount());
  }
}
