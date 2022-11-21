package bridge.domain;

import bridge.*;
import bridge.view.OutputView;

import java.util.List;

/** 다리 건너기 게임을 관리하는 클래스 */
public class BridgeGame {
  private final User user;
  private final BridgeMaker bridgeMaker;
  private Bridge bridge;

  public BridgeGame(final User user) {
    this.user = user;
    this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
  }

  public void gameInit(int length) {
    user.startNewGame();
    bridge = new Bridge(bridgeMaker.makeBridge(length));
  }

  /** 사용자가 칸을 이동할 때 사용하는 메서드 */
  public void move(String moveDirection) {
    user.move(moveDirection);
  }

  /**
   * 사용자가 게임을 다시 시도할 때 사용하는 메서드
   *
   * <p>재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public void retry() {}

  public boolean isTryFinish() {
    return !user.isCorrectlyMove(bridge.getBridgeShapes()) || isTrySuccess();
  }

  public boolean isTrySuccess() {
    return user.isCorrectlyMove(bridge.getBridgeShapes()) && isArriveFinishLine();
  }

  private boolean isArriveFinishLine() {
    return user.isArriveFinishLine(bridge.getBridgeShapes().size());
  }

  public void showResult() {
    OutputView.printMap(user.getMoveStatus(), bridge.getBridgeShapes());
  }

  public List<String> getBridgeShapes() {
    return this.bridge.getBridgeShapes();
  }
}
