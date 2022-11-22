package bridge;

import bridge.Messages.Error;
import bridge.Validate;
import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.pool.TypePool;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    static private int castInt(String str){
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException(Error.INVALID_NOTANUMBER.getMessage());
        }
        return num;
    }
    static public int readBridgeSize() {
        OutputView.printLengthGuide();
        int bridgeLength = 0;
        try {
            bridgeLength = castInt(Console.readLine());
            Validate.checkRange(bridgeLength);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            bridgeLength = readBridgeSize(); //Recursively execute to scan new input
        }
        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    static public String readMoving() {
        OutputView.printMoveGuide();
        String input = "";
        try {
            input = Console.readLine();
            Validate.checkLetter(input, "U", "D");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            input = readMoving(); //Recursively execute to scan new input
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    static public String readGameCommand() {
        OutputView.printGameCommandGuide();
        String input = "";
        try {
            input = Console.readLine();
            Validate.checkLetter(input, "R", "Q");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            input = readGameCommand(); //Recursively execute to scan new input
        }
        return input;
    }
}
