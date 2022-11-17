package bridge.view;

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
        try {
            validMoving(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이동 값은 대문자 알파벳이어야 합니다.");
        }
    }

    private void validMoving(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isUpperCase(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
