package view;

import camp.nextstep.edu.missionutils.Console;
import view.validation.InputViewValidation;

import java.util.Collections;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static int readBridgeSize() {
        for (; ; ) {
            try {
                System.out.println("다리의 길이를 입력해주세요.");
                return changeStringToInteger(InputSize());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String InputSize() {
        String sizeInput = Console.readLine();
        InputViewValidation.validateBridgeSizeInput(sizeInput);
        return sizeInput;
    }

    private static int changeStringToInteger(String sizeInput) {
        int size = Integer.parseInt(sizeInput);
        InputViewValidation.validateBridgeSize(size);
        return size;
    }

    public static String readMoving() {
        for (; ; ) {
            try {
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                return InputMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String InputMoving() {
        String movingInput = Console.readLine();
        InputViewValidation.validateMovingInput(movingInput);
        return movingInput;
    }


    public static String readGameCommand() {
        for (; ; ) {
            try {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                return inputCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputCommand() {
        String commandInput = Console.readLine();
        InputViewValidation.validateCommandInput(commandInput);
        return commandInput;
    }

}
