package bridge;

import java.util.List;

public class MoveResult {
  private final String gameResult;
  private final List<Cross> crossResult;


  public MoveResult(String gameResult, List<Cross> crossResult) {
    this.gameResult = gameResult;
    this.crossResult = crossResult;
  }

  public String getGameResult() {
    return gameResult;
  }

  public List<Cross> getCrossResult() {
    return crossResult;
  }
}
