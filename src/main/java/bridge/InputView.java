package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final OutputView view = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String line;
        do {
            System.out.println("다리의 길이를 입력해주세요.");
            line = Console.readLine();
        } while (!validateNumber(line));
        return Integer.parseInt(line);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String line;
        do {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            line = Console.readLine();
        } while (!validateMovingInput(line));
        return line;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String line;
        do {
            line = Console.readLine();
        } while (!validateGameInput(line));
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return line;
    }

    public void exceptionTemplate(Exception e) {
        try {
            throw e;
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public boolean validateNumber(String line) {
        if (!validateDigit(line))
            return false;
        return validateSize(line);
    }

    public boolean validateDigit(String line) {
        boolean isValid = true;
        for (int i = 0; i < line.length(); i++) {
            isValid &= checkIdxIsNumber(line, i);
        }
        if (!isValid) {
            exceptionTemplate(new InputException(InputExceptionMessage.SIZE_INPUT_ERROR));
            return false;
        }
        return true;
    }

    public boolean validateSize(String line) {
        boolean isValid = true;
        int sz = Integer.parseInt(line);
        if (sz < 3 || sz > 20)
            isValid = false;
        if (!isValid) {
            exceptionTemplate(new InputException(InputExceptionMessage.SIZE_INPUT_ERROR));
        }
        return isValid;
    }


    public boolean checkIdxIsNumber(String line, int idx) {
        return Character.isDigit(line.charAt(idx));
    }

    public boolean validateMovingInput(String line) {
        if (line.equals("U") || line.equals("D"))
            return true;
        exceptionTemplate(new InputException(InputExceptionMessage.MOVE_INPUT_ERROR));
        return false;
    }

    public boolean validateGameInput(String line) {
        if (line.equals("R") || line.equals("Q"))
            return true;
        exceptionTemplate(new InputException(InputExceptionMessage.GAMECOMMAND_INPUT_ERROR));
        return false;
    }
}
