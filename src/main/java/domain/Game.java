package domain;

import domain.bridge.AnswerBridge;
import domain.bridge.BridgeGame;
import domain.bridge.view.OutputView;
import domain.player.Player;

public class Game {
  private int number_of_pick;
  BridgeGame bridgeGame;
  AnswerBridge answerBridge;
  Player player;

  public Game () {
    number_of_pick = 0;
    bridgeGame = new BridgeGame();
    answerBridge = new AnswerBridge();
  }

  public void play() {
    answerBridge.setBridge();
    while (true) {
      player = new Player();
      while (bridgeGame.move(player, answerBridge))
        ;
      number_of_pick += player.getPick();
      if (!bridgeGame.retry(player)) {
        break;
      }
    }
  }

  public void result() {
    OutputView outputView = new OutputView();
    outputView.printResult(player, number_of_pick);
  }
}
