package bridge;

import static bridge.InputView.readBridgeSize;
import static bridge.InputView.readMoving;
import static bridge.OutputView.*;

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
    boolean isGameFinish = false;
    while (!isGameFinish) {
      bridgeGame.gameInit();
      makeBridgeByLengthInput();
      tryMove(); // 시도가 끝날 때 까지 이동
      isGameFinish = checkIsGameFinish();
    }
    // 최종 게임 결과, 시도횟수 출력
  }

  private void makeBridgeByLengthInput() {
    printLengthInputMessage();
    bridgeGame.makeBridge(readBridgeSize());
  }

  private void tryMove() {
    while (!bridgeGame.isTryFinish()) {
      moveByDirectionInput();
      bridgeGame.showResult();
    }
  }

  private void moveByDirectionInput() {
    printMoveDirInputMessage();
    bridgeGame.move(readMoving());
  }

  private boolean checkIsGameFinish() {
    if (!bridgeGame.isTrySuccess()) { // 시도 실패
      return checkRetryByInput(); // 재시도 여부 질문
    }
    return true;
  }

  private boolean checkRetryByInput() {
    // 게임 재시도 여부 메세지 출력
    // 입력받아서 재시도할 것인지 안할 것인지 판단
    return true;
  }
}
