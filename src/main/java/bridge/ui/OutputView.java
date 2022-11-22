package bridge.ui;

import bridge.BridgeGame;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

  /**
   * 처음 게임을 시작했을 때 시작 문구를 출력한다.
   */
  public void printGameStart() {
    System.out.println("다리 건너기 게임을 시작합니다.");
  }

  /**
   * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
   * <p>
   * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public void printMap(int round, List<List<String>> currentBridge) {

    if (round == currentBridge.get(0).size()) {
      round--;
    }
    for (int i = 0; i < 2; i++) {
      System.out.println("[" + String.join("|", currentBridge.get(i).subList(0, round + 1)) + "]");
    }

  }

  /**
   * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
   * <p>
   * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public void printResult(int round, BridgeGame bridgeGame) {
    System.out.println("최종 게임 결과");
    printMap(round, bridgeGame.getCurrentBridge());
    System.out.println("게임 성공 여부: " + bridgeGame.getSuccess().getState());
    System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
  }

  /**
   * 양식에 맞춰 에러 문구를 출력한다.
   *
   * @param e 에러 메세지 정보를 가지고 있는 Exception 객체
   */
  public static void printError(Exception e) {
    System.out.println("[ERROR] " + e.getMessage());
  }
}
