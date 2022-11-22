package bridge.domain;

public interface Output {

  void printMap(GameState gameState);

  void printResult(GameState gameState, boolean isSuccess);
}
