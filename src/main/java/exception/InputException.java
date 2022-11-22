package exception;

public class InputException {

  public static boolean isRightBridgeSize(int size) {
    return size >= 3 && size <= 20;
  }

  public static boolean isRightBridgeMove(String move) {
    if (move.equals("U"))
      return true;
    if (move.equals("D"))
      return true;
    return false;
  }

  public static boolean isRightBridgePlay(String play) {
    if (play.equals("Q"))
      return true;
    if (play.equals("R"))
      return true;
    return false;
  }
}
