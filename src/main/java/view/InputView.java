package view;

import constants.CommandTable;
import constants.DirectionTable;
import view.validation.InputViewValidation;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int readBridgeSize() {
        for (; ; ) {
            try {
                printInputBridgeSize();
                return changeStringToInteger(InputSize());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printInputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
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
                printInputMoving();
                return InputMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printInputMoving() {
        System.out.println(String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)"
                , DirectionTable.UP.getInitial(), DirectionTable.DOWN.getInitial()));
    }

    private static String InputMoving() {
        String movingInput = Console.readLine();
        InputViewValidation.validateMovingInput(movingInput);
        return movingInput;
    }

    public static String readGameCommand() {
        for (; ; ) {
            try {
                printInputCommand();
                return inputCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printInputCommand() {
        System.out.println(String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)"
                , CommandTable.RETRY.getInitial(), CommandTable.QUIT.getInitial()));
    }

    private static String inputCommand() {
        String commandInput = Console.readLine();
        InputViewValidation.validateCommandInput(commandInput);
        return commandInput;
    }
}
