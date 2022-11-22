package domain;

import domain.bridge.AnswerBridge;
import domain.bridge.BridgeGame;
import domain.player.Player;
import org.mockito.stubbing.Answer;

public class Game {
  private int number_of_pick;
  BridgeGame bridgeGame;
  AnswerBridge answerBridge;
  Player player;

  public Game () {
    number_of_pick = 0;
    bridgeGame = new BridgeGame();
    answerBridge = new AnswerBridge();
    Player player = new Player();
  }

  public void play() {
    answerBridge.setBridge();

  }

}
