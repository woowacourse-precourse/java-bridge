package bridge.controller;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.io.InputView;
import bridge.io.OutputView;

public class BridgeController {
  private InputView inputView;
  private OutputView outputView;
  private BridgeGame game;

  public BridgeController() {
    inputView = new InputView();
    outputView = new OutputView();
  }

  public void play() {
    makeBridgeByInput();
    crossBridge();
    showResult();
  }

  public void makeBridgeByInput() {
    outputView.printStart();
    int bridgeSize = inputView.readBridgeSize();
    game = new BridgeGame(new Bridge((bridgeSize)));
  }

  public void crossBridge() {
    do {
      String move = inputView.readMoving();
      game.play(move);
      outputView.printMap(game.getMap());
      if(game.isWin()) break;
      if (!game.canCross()) {
        game.retry(inputView.readGameCommand());
      }
    } while (game.canCross());
  }

  public void showResult() {
    System.out.println();
    outputView.printLastMapResult();
    outputView.printMap(game.getResultMap());
    System.out.println();
    outputView.printResult(game.getResult());
  }
}