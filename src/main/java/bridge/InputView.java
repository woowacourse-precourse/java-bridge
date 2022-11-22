package bridge;

import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    Except excpet = new Except();
    OutputView outputView = new OutputView();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String InputVal = Console.readLine();
        try {
            int BridgeSize = Integer.parseInt(InputVal);
            excpet.BridgeSizeCheck(BridgeSize);
        }
        catch (IllegalArgumentException e) {
            outputView.PrintText("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return -1;
        }
        return Integer.parseInt(InputVal);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String InputVal = Console.readLine();
        try {
            excpet.InsertCorrect(InputVal,"U","D");
        }
        catch (IllegalArgumentException e) {
            outputView.PrintText("[ERROR] U,D 이외의 값을 입력하였습니다.");
            return "EXIT";
        }
        return InputVal;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String InputVal = Console.readLine();
        try {
            excpet.InsertCorrect(InputVal,"R","Q");
        }
        catch (IllegalArgumentException e) {
            outputView.PrintText("[ERROR] R,Q 이외의 값을 입력하였습니다.");
            return "EXIT";
        }
        return InputVal;
    }
}
