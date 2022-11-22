package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    Scanner scanner = new Scanner(System.in);

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
//        return validateBridgeSize(Console.readLine());
        return validateBridgeSize(scanner.next());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
//        return validateMoving(Console.readLine());
        return validateMoving(scanner.next());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
//        return validateGameCommand(Console.readLine());
        return validateGameCommand(scanner.next());
    }

    private int validateBridgeSize(String size) {
        int num = 0;
        if(isNumeric(size)) {
            num = Integer.parseInt(size);
        }
        if (num < 3 || num > 20) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return num;
    }

    private String validateMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException("U(위 칸)이나 D(아래 칸)으로만 이동 가능합니다.");
        }
        return moving;
    }

    private String validateGameCommand(String command) {
        if (!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException("R(재시도)이나 Q(종료)를 입력해주세요.");
        }
        return command;
    }

    private boolean isNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }
        return true;
    }
}