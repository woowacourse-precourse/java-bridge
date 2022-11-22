package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static Integer readBridgeSize() {
        Integer bridgeSize = null;
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            handleInputException(e);
        }
        return bridgeSize;
    }

    public static void handleInputException(Exception e) {
        if (e.getClass().equals(NumberFormatException.class)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }


    public static String readMoving() {
        String moving = null;
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            moving = Console.readLine();
        } catch (Exception e) {
            handleInputException(e);
        }
        checkInputNotNullAndNotEmpty(moving);
        return moving;
    }


    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = null;
        try {
            command = Console.readLine();
        } catch (Exception e) {
            handleInputException(e);
        }
        checkInputNotNullAndNotEmpty(command);
        return command;
    }

    public static void checkInputNotNullAndNotEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("공백이 아닌 문자를 입력해주세요.");
        }
    }
}
