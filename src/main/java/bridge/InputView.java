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
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String result = "";
        while(true) {
            try {
                out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                result = validateMoving(Console.readLine());
                break;
            } catch (Exception e) {
                out.println("[ERROR] U,D 값 중 하나를 입력해야 합니다.");
            }
        }
        return result;
    }

    private String validateMoving(String input) {
        if(!Pattern.matches("^\b?[UD]{1}\b?$", input))
            throw new IllegalArgumentException();
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String result = "";
        while(true){
            try{
                out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                result = validateGameCommand(Console.readLine());
                break;
            }catch(Exception e){
                out.println("[ERROR] R,Q중 하나의 값을 입력해야 합니다.");
            }
        }
        return result;
    }

    private String validateGameCommand(String input) {
        if(!Pattern.matches("^\b?[RQ]{1}\b?$", input))
            throw new IllegalArgumentException();
        return input;
    }
}
