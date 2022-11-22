package view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static constant.Message.*;
import static exception.InputException.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

  /**
   * 다리의 길이를 입력받는다.
   */
  public int readBridgeSize() {
    int size;
    try {
      size = Integer.parseInt(readLine());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(PUT_NUM);
    }
    if (!isRightBridgeSize(size))
      throw new IllegalArgumentException(BRIDGE_SIZE);
    return size;
  }

  /**
   * 사용자가 이동할 칸을 입력받는다.
   */
  public String readMoving() {
    String move;
    try {
      move = readLine();
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(PUT_STR);
    }
    if (!isRightBridgeMove(move))
      throw new IllegalArgumentException(PUT_UD);
    return move;
  }

  /**
   * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
   */
  public String readGameCommand() {
    String play;
    try {
      play = readLine();
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(PUT_STR);
    }
    if (!isRightBridgePlay(play))
      throw new IllegalArgumentException(PUT_QR);
    return play;
  }
}
