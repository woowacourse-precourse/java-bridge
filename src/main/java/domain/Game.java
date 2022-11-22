package domain;

import domain.bridge.AnswerBridge;
import domain.bridge.BridgeGame;
import view.OutputView;
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
    answerBridge.setBridge();
  }

  public void play() {
    int i;
    while (true) {
      player = new Player();
      for (i = 0; i < answerBridge.getBridgeSize(); i++) {
        if (!bridgeGame.move(player, answerBridge))
          break;
      }
      if (!keepGame(i, player))
        break;
    }
  }

  private boolean keepGame(int i, Player player) {
    number_of_pick++;
    if (i != answerBridge.getBridgeSize())// 중간에 틀려서 게엠 종료
      if (!bridgeGame.retry(player)) // 근데 다시 안하겠대 그럼 종료
        return false;
    if (i == answerBridge.getBridgeSize()) //  다 맞춰서 끝났다
      return false;
    return true;
  }

  public void result() {
    OutputView outputView = new OutputView();
    outputView.printResult(player, number_of_pick);
  }
}
