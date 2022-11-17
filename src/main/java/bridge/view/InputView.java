package bridge.view;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        String input = Console.readLine();
        try {
            validSize(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 자연수여야 합니다.");
        }
        return Integer.parseInt(input);
    }

    private void validSize(String input) {
        int size = Integer.parseInt(input);
        if (size < 0) {
            throw new IllegalArgumentException();
        }
    }

    public String readMoving() {
        String input = Console.readLine();
        validCommand(input);
        return input;
    }

    public String readGameCommand() {
        String input = Console.readLine();
        validCommand(input);
        return input;
    }

    private void validCommand(String input) {
        try {
            for (char c : input.toCharArray()) {
                checkUpperCase(c);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이동 값은 대문자 알파벳이어야 합니다.");
        }
    }

    private void checkUpperCase(char input) {
        if (!Character.isUpperCase(input)) {
            throw new IllegalArgumentException();
        }
    }
}
