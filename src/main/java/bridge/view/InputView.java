package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private String getInput(String prompt) {
        System.out.println(prompt);
        return readLine();
    }

    public int readBridgeSize() {
        int size = 0;
        try {
            size = checkBridgeSizeInput(getInput("\n다리의 길이를 입력해주세요."));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
        return size;
    }

    private int checkBridgeSizeInput(String input) {
        int num;
        if (!isNumeric(input)) {
            generateError("다리 길이는 숫자여야 합니다.");
        }
        num = Integer.parseInt(input);
        if (num < 3 || num > 20) {
            generateError("다리길이는 3부터 20 사이의 숫자여여 합니다.");
        }
        return num;
    }

    public String readMoving() {
        String move = "";
        try {
            move = checkMovingInput(getInput("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            readMoving();
        }
        return move;
    }

    private String checkMovingInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            generateError("이동 명령어는 U나 D여야 합니다.");
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void generateError(String message) {
        throw new IllegalArgumentException(message);
    }

    private boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
