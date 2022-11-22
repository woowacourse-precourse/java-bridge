package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    final PrintWriter out = new PrintWriter(System.out);

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int result = -1;
        System.out.println("다리의 길이를 입력해주세요.");
        result = validateBridgeSize(Console.readLine());

        return result;
    }

    private int validateBridgeSize(String input) throws IllegalArgumentException {
        if (!Pattern.matches("(^\b?[3-9]{1}\b?$)|(^\b?1[0-9]+\b?$)|(^\b?20\b?$)", input))
            throw new IllegalArgumentException("[ERROR] 3과 20사이의 정수여야합니다.");
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String result = "";
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        result = validateMoving(Console.readLine());

        return result;
    }

    private String validateMoving(String input) {
        if (!Pattern.matches("^\b?[UD]{1}\b?$", input))
            throw new IllegalArgumentException("[ERROR] \'U\' 아니면 \'D\'만 입력 가능합니다.");
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        String result = "";

        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        result = validateGameCommand(Console.readLine());

        if ("R".equals(result))
            return true;

        return false;
    }

    private String validateGameCommand(String input) {
        if (!Pattern.matches("^\b?[RQ]{1}\b?$", input))
            throw new IllegalArgumentException("[ERROR] \'R\' 아니면 \'Q\'만 입력 가능합니다.");
        return input;
    }
}
