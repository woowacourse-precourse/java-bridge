package bridge;

import bridge.Messages.Error;
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
            throw new IllegalArgumentException(Error.INVALID_LENGTH.getMessage());
        }
        return num;
    }
    static public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeLength = 0;
        try {
            bridgeLength = castInt(Console.readLine());
            if (bridgeLength > 20 || bridgeLength < 3)
                throw new IllegalArgumentException(Error.INVALID_RANGE.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            bridgeLength = readBridgeSize();
        }

        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    static public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = "";
        try {
            input = Console.readLine();
            checkLetter(input, "U", "D");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            readMoving(); //Recursively execute to scan new input
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    static public String readGameCommand() {
        String input = "";
        try {
            input = Console.readLine();
            checkLetter(input, "R", "Q");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            readGameCommand(); //Recursively execute to scan new input
        }
        return input;
    }

    static private void checkLetter(String check, String opt1, String opt2){
        if (!check.equals(opt1) && !check.equals(opt2))
            throw new IllegalArgumentException(Error.INVALID_LETTER.getMessage());
    }
}
