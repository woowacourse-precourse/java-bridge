package domain.bridge;

import domain.Game;

public class Application {

  public static void main(String[] args) {
    try {
      Game game = new Game();
      game.play();
      game.result();
    } catch (IllegalArgumentException e) {
      return ;
    }
  }
}
