package bridge.view;

import bridge.Cross;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

  public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
  public static final String ASK_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
  public static final String ASK_DIRECTION_TO_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
  public static final String TOTAL_NUMBER_OF_ATTEMPTS = "총 시도한 횟수: %d";
  public static final String ASK_RESTART_OR_END_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
  public static final String GAME_RESULT = "최종 게임 결과";
  public static final String GAME_RESULT_MESSAGE = "게임 성공 여부: ";
  public static final String SUCCESS = "성공";
  public static final String FAIL = "실패";


  public void printGameStartMessage() {
    System.out.println(GAME_START_MESSAGE);
  }

  public void printAskBridgeSizeMessage() {
    System.out.println(ASK_BRIDGE_SIZE_MESSAGE);
  }

  public void printAskDirectionMessage(){
    System.out.println(ASK_DIRECTION_TO_MOVE_MESSAGE);
  }

  public void printAskRestartMessage() {
    System.out.println(ASK_RESTART_OR_END_MESSAGE);
  }

  /**
   * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
   * <p>
   * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public void printMap(List<Cross> crossResult) {
    BridgeView bridgeView = new BridgeView(crossResult);
    bridgeView.printUpper();
    bridgeView.printLower();
  }

  /**
   * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
   * <p>
   * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public void printResult() {
  }

}
