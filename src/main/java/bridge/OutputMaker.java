package bridge;

public interface OutputMaker {
  void printMap(char[][] maps, int end);
  void printResult(char[][] maps, int end, boolean success, int cnt);
  void printStatus(boolean success);
}
