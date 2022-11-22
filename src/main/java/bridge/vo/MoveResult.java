package bridge.vo;

import java.util.List;

public class MoveResult {
  private final String gameResult;
  private final List<Cross> crossResult;
  private final int tryNumber;


  public MoveResult(String gameResult, List<Cross> crossResult, int tryNumber) {
    this.gameResult = gameResult;
    this.crossResult = crossResult;
    this.tryNumber = tryNumber;
  }

  public String getGameResult() {
    return gameResult;
  }

  public List<Cross> getCrossResult() {
    return crossResult;
  }

  public int getTryNumber() {
    return tryNumber;
  }
}
