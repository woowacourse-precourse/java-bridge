package exception;

import static constant.ApplicationMessage.*;

public class InputException {

  public static boolean isRightBridgeSize(int size) {
    return size >= 3 && size <= 20;
  }

  public static boolean isRightBridgeMove(String move) {
    if (move.equals(UP))
      return true;
    if (move.equals(DOWN))
      return true;
    return false;
  }

  public static boolean isRightBridgePlay(String play) {
    if (play.equals(QUIT))
      return true;
    if (play.equals(RETRY))
      return true;
    return false;
  }
}
