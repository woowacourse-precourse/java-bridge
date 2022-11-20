package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public int readBridgeSize(int size) {
        return 0;
    }
    public String readMoving(String direction) {
        return null;
    }
    public String readGameCommand(String command) {
        return null;
    }

}
/*
  readBridgeSize -> 길이를 입력받는다.
  readMoving -> 이동할 칸
  readGame -> 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
 */