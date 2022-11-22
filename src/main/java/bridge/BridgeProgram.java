package bridge;

import java.util.LinkedList;
import java.util.List;

public class BridgeProgram {
  private final InputView input;
  private final OutputView output;
  private final BridgeMaker bridgeMaker;
  private final BridgeGame bridgeGame;


  public BridgeProgram(InputView input, OutputView output, BridgeMaker bridgeMaker,BridgeGame bridgeGame) {
    this.input = input;
    this.output = output;
    this.bridgeMaker = bridgeMaker;
    this.bridgeGame = bridgeGame;
  }

  public void run() {
    List<String> bridgeRoute = bridgeMaker.makeBridge(getBridgeSize());
    Bridge bridge = new Bridge(bridgeRoute);
    int movingCount = 0;

    boolean isRunning = true;
    while (GameStatus.isRunning) {
      Mark mark = bridge.matchRoute(getInputDirection(), bridgeGame.countMoving());
      List<List<String>> route = bridgeGame.move(mark);

      output.printMap(route);
      if (!mark.isRight()) {
        restartOrStop(route);
      }
      if (bridge.getSize() == bridgeGame.getMovingCount()) {
        end(route, "성공");
      }
    }
  }
  private int getBridgeSize() {
    output.printMessage(Message.START);
    return input.readBridgeSize();
  }

  private String getInputDirection() {
    output.printMessage(Message.REQUEST_DIRECTION);
    return input.readMoving();
  }

  private void restartOrStop(List<List<String>> route) {
    if (getGameCommand().equals("Q")) {
      end(route, "실패");
      return;
    }
    bridgeGame.retry();
  }

  private String getGameCommand() {
    output.printMessage(Message.RESTART_OR_EXIT);
    return input.readGameCommand();
  }
  private void end(List<List<String>> route, String result) {
    GameStatus.quitGame();
    output.printResult(route, result, bridgeGame.getGameCount());
  }
}
