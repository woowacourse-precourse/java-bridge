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
        String line = Console.readLine();
        validateNumber(line);
        return Integer.parseInt(line);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String line = Console.readLine();
        validateMovingInput(line);
        return line;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {

        String line = Console.readLine();
        validateGameInput(line);
        return line;
    }

    public void validateNumber(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (!Character.isDigit(line.charAt(i)))
                throw new InputException(InputExceptionMessage.MOVE_INPUT_ERROR);
        }
        int sz = Integer.parseInt(line);
        if (sz < 3 || sz > 20)
            throw new InputException(InputExceptionMessage.MOVE_INPUT_ERROR);

    }

    public void validateMovingInput(String line) {
        if (line.equals("U") || line.equals("D"))
            return;
        throw new InputException(InputExceptionMessage.MOVE_INPUT_ERROR);

    }

    public void validateGameInput(String line) {
        if (line.equals("R") || line.equals("Q"))
            return;
        throw new InputException(InputExceptionMessage.GAMECOMMAND_INPUT_ERROR);

    }
}
