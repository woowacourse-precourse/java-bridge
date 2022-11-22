package bridge.infra;

import bridge.constant.Message;
import bridge.domain.BridgeArea;
import bridge.domain.GameState;
import bridge.domain.Output;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView implements Output {

  private final StringBuilder sb = new StringBuilder();

  @Override
  public void printMap(GameState gameState) {
    List<BridgeArea> movementHistory = gameState.getMovementHistory();
    List<Boolean> stateHistory = gameState.getStateHistory();
    makeBlank(movementHistory, stateHistory, BridgeArea.U);
    makeBlank(movementHistory, stateHistory, BridgeArea.D);
    printBlankByBuilder();
  }

  private void makeBlank(List<BridgeArea> userAreas, List<Boolean> isSuccess,
      BridgeArea printArea) {
    sb.append("[");
    for (int i = 0; i < isSuccess.size(); i++) {
      sb.append(" ").append(makeOX(userAreas.get(i), isSuccess.get(i), printArea)).append(" ");
      if (isLast(i, isSuccess.size())) {
        sb.append("]").append("\n");
      }
      if (!isLast(i, isSuccess.size())) {
        sb.append("|");
      }
    }
  }

  private boolean isLast(int cur, int size) {
    return cur == size - 1;
  }

  private String makeOX(BridgeArea userArea, boolean isSuccess, BridgeArea printArea) {
    if (!userArea.equals(printArea)) {
      return " ";
    }
    if (isSuccess) {
      return "O";
    }
    return "X";
  }

  @Override
  public void printResult(GameState gameState, boolean isSuccess) {
    System.out.println(Message.OUTPUT_RESULT_MESSAGE.getText());
    List<BridgeArea> movementHistory = gameState.getMovementHistory();
    List<Boolean> stateHistory = gameState.getStateHistory();
    int tryCount = gameState.getTryCount();

    makeBlank(movementHistory, stateHistory, BridgeArea.U);
    makeBlank(movementHistory, stateHistory, BridgeArea.D);
    printGameEndAndResult(isSuccess, tryCount);
  }

  private void printGameEndAndResult(boolean isSuccess, int tryCount) {
    printBlankByBuilder();
    printEndMessage(isSuccess);
    System.out.println(Message.OUTPUT_TRY_COUNT_MESSAGE.getText() + tryCount);
  }

  private void printBlankByBuilder(){
    System.out.println(sb);
    sb.setLength(0);
  }

  private void printEndMessage(boolean isSuccess) {
    if (isSuccess) {
      System.out.println(Message.OUTPUT_SUCCESS_MESSAGE.getText());
    }

    if (!isSuccess) {
      System.out.println(Message.OUTPUT_FAIL_MESSAGE.getText());
    }
  }
}
