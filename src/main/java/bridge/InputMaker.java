package bridge;

public interface InputMaker {
  int readBridgeSize();
  int validateSize(int parseInt);
  String readMoving();
  String readGameCommand();
  void startGame();
  String readRetry();
  String readMove();
  int readSize();
}
