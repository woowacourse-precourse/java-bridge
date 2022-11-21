package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    PrintWriter out = new PrintWriter(System.out);

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int result = -1;
        while (true) {
            try {
                out.println("다리의 길이를 입력해주세요.");
                result = validateBridgeSize(Console.readLine());
                break;
            } catch (Exception e) {
                out.println("[ERROR] 다리의 길이는 3부터 20사이의 숫자여야 합니다.");
            }
        }
        return result;
    }

    private int validateBridgeSize(String input) throws IllegalArgumentException {
         if (!Pattern.matches("(^\b?[3-9]{1}\b?$)|(^\b?1[0-9]+\b?$)|(^\b?20\b?$)", input))
             throw new IllegalArgumentException();
         return  Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    private String validateMoving(String input) {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private String validateGameCommand(String input) {
        return null;
    }
}
