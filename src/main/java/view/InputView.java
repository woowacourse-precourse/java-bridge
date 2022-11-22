package view;

import static camp.nextstep.edu.missionutils.Console.readLine;
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
      throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요!");
    }
    if (!isRightBridgeSize(size)) {
      throw new IllegalArgumentException("[ERROR] 다리 길이는 3이상 20이하입니다.");
    }
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
      throw new IllegalArgumentException("[ERROR] 문자를 입력하세요!");
    }
    if (!isRightBridgeMove(move)) {
      throw new IllegalArgumentException("[ERROR] U 와 D 중 입력하세요.");
    }
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
      throw new IllegalArgumentException("[ERROR] 문자를 입력하세요!");
    }
    if (!isRightBridgePlay(play)) {
      throw new IllegalArgumentException("[ERROR] Q 와 R 중 입력하세요.");
    }
    return play;
  }
}
