package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

/** 다리 건너기 게임을 관리하는 클래스 */
public class BridgeGame {
  private final User user;
  private final BridgeMaker bridgeMaker;
  private Bridge bridge;
  private Map map;

  public BridgeGame(final User user) {
    this.user = user;
    this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    this.map = new Map();
  }

  public void gameInit(int length) {
    this.user.startNewGame();
    this.bridge = new Bridge(bridgeMaker.makeBridge(length));
    this.map = new Map();
  }

  /** 사용자가 칸을 이동할 때 사용하는 메서드 */
  public void move(String moveDirection) {
    user.move(moveDirection);
    updateMap(moveDirection);
  }

  /** 사용자가 게임을 다시 시도할 때 사용하는 메서드 */
  public void retry() {}

  public boolean isTryFinish() {
    return !user.isCorrectlyMove(bridge.getBridgeShapes()) || isTrySuccess();
  }

  public boolean isTrySuccess() {
    return user.isCorrectlyMove(bridge.getBridgeShapes()) && isArriveFinishLine();
  }

  private boolean isArriveFinishLine() {
    return bridge.isArriveFinishLine(user.getMoveCount());
  }

  public Map getMap() {
    return this.map;
  }

  private void updateMap(String moveDirection) {
    this.map.updateMap(moveDirection, bridge.getBridgeShapes().get(user.getCurrentIndex()));
  }
}
