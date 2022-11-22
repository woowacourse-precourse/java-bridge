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
    do {
      bridgeGame.gameInit(length);
      tryMove(); // 시도가 끝날 때 까지 이동
    } while (!checkIsGameFinish());
    printResult(bridgeGame, user.getTryCount());
  }

  private void tryMove() {
    while (!bridgeGame.isTryFinish()) {
      bridgeGame.move(readMoving());
      printMap(bridgeGame.getMap());
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
}
