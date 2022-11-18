package view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 *
 * 요구사항
 * 1. 제공된 InputView 클래스를 활용해 구현해야 한다.
 * 2. InputView 의 패키지는 변경할 수 있다.
 * 3. InputView 의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 4. 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final Validation validation = new Validation();
    public static String input = "";

    public String repeat(String message) {
        while(true) {
            try {
                System.out.println("\n" + message);
                validation.validate(input = Console.readLine());
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return Integer.parseInt(repeat(INPUT_BRIDGE_SIZE));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}