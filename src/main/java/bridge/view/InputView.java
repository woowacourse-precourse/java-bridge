package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int readBridgeSize() {
        int size = 0;
        try {
            size = checkBridgeSizeInput(getInput("\n다리의 길이를 입력해주세요."));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return size;
    }

    private int checkBridgeSizeInput(String input) {
        int num;
        if (!isNumeric(input)) {
            generateError("[ERROR] 다리길이는 숫자여야 합니다.");
        }
        num = Integer.parseInt(input);
        if (num < 3 || num > 20) {
            generateError("[ERROR] 다리길이는 3부터 20 사이의 숫자여여 합니다.");
        }
        return num;
    }

    public String readMoving() {
        String move = "";
        try {
            move = checkMovingInput(getInput("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return move;
    }

    private String checkMovingInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            generateError("[ERROR] 이동 명령어는 U나 D여야 합니다.");
        }
        return input;
    }

    public String readGameCommand() {
        String command = "";
        try {
            command = checkGameCommandInput(getInput("\n게임을 다시 시도할지 여부를 입력햐주세요. (재시도: R, 종료: Q)"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return command;
    }

    private String checkGameCommandInput(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            generateError("[ERROR] 재시도 명령어는 R나 Q여야 합니다.");
        }
        return input;
    }

    private String getInput(String prompt) {
        System.out.println(prompt);
        return readLine();
    }

    private void generateError(String message) {
        throw new IllegalArgumentException(message);
    }

    private boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
