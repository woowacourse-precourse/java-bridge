package bridge.view;

// TODO 시그니처(인자, 이름)와 반환 타입은 변경 가능합니다
//  메서드 추가도 가능합니다

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static Integer readBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return Console.readLine();
    }

    public static void showStartGameMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
