package bridge;

import java.util.List;

public interface OutputMaker {
  void printMap(List<List<String>> maps);
  void printResult(List<List<String>> maps, boolean success, int cnt);
  void printStatus(boolean success);
}
