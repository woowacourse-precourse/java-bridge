package bridge.UI;

import bridge.Domain.ValidCheck;
import bridge.UI.Resource.Exceptions;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int askBridgeSize() {
        try {
            outputView.bridgeSizeMessage();
            return readBridgeSize();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            return askBridgeSize();
        }
    }

    public int readBridgeSize() {
        String size_str = readLine();
        if (!ValidCheck.isString_in_0to9(size_str))
            throw new IllegalArgumentException(Exceptions.NotInteger.getMessage());
        int size = Integer.parseInt(size_str);
        if (!ValidCheck.isRange_3to20(size))
            throw new IllegalStateException(Exceptions.NotInRange.getMessage());
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String askMoving() {
        try {
            outputView.moveMessage();//move message 출력
            return readMoving();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            return askMoving();
        }
    }

    public String readMoving() {
        String command = readLine();
        if (!ValidCheck.isUorD(command))
            throw new IllegalArgumentException(Exceptions.NotUorD.getMessage());
        if (!ValidCheck.isLength1(command))
            throw new IllegalStateException(Exceptions.NotCorrectSize.getMessage());
        return command;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String askRestart() {
        try {
            outputView.restartMessage();
            return readGameCommand();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            return askRestart();
        }
    }

    public String readGameCommand() {
        String command = readLine();
        if (!ValidCheck.isRorQ(command))
            throw new IllegalArgumentException(Exceptions.NotRorQ.getMessage());
        if (!ValidCheck.isLength1(command))
            throw new IllegalArgumentException(Exceptions.NotCorrectSize.getMessage());
        return command;
    }


}
