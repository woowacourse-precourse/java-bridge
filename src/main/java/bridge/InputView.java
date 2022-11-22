package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    OutputView outputView = new OutputView();
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        int userInputBridgeLength = 0;
        while(userInputBridgeLength > 25 || userInputBridgeLength < 3) {
            OutputView.whatSizeBridge();
            userInputBridgeLength = Integer.parseInt(Console.readLine());
            if (userInputBridgeLength > 25 || userInputBridgeLength < 3) {
                OutputView.printError(1);
            }
        }
        return userInputBridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String userInput = "";
        while(!userInput.equals("U") && !userInput.equals("D")){
            OutputView.printInputWhereToGo();
            userInput = Console.readLine();
            if (!userInput.equals("U") && !userInput.equals("D")){
                OutputView.printError(2);
            }
        }
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand(int i) {
        OutputView.printInputReGameOrNot();
        return BridgeGame.retry(Console.readLine(), i);
    }
}
