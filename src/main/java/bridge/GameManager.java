package bridge;

import static bridge.OutputView.printErrorMessage;
import static bridge.OutputView.printGameStartMessage;

public class GameManager {
  private User user;
  private BridgeGame bridgeGame;

  public GameManager() {
    this.user = new User();
    this.bridgeGame = new BridgeGame(user);
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
    // 게임 진행 코드
  }
}
