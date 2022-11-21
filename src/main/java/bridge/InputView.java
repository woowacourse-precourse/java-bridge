package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size_str = readLine();
        if (!ValidCheck.isString_in_1to9(size_str))
            throw new IllegalArgumentException(Exception.NotInteger.getMessage());
        int size = Integer.parseInt(size_str);
        if (!ValidCheck.isRange_3to20(size))
            throw new IllegalArgumentException(Exception.NotInRange.getMessage());
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String command = readLine();
        if (!ValidCheck.isUorD(command))
            throw new IllegalArgumentException(Exception.NotUorD.getMessage());
        if (!ValidCheck.isLength1(command))
            throw new IllegalArgumentException(Exception.NotCorrectSize.getMessage());
        return command;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = readLine();
        if (!ValidCheck.isRorQ(command))
            throw new IllegalArgumentException(Exception.NotRorQ.getMessage());
        if (!ValidCheck.isLength1(command))
            throw new IllegalArgumentException(Exception.NotCorrectSize.getMessage());
        return command;
    }
}
