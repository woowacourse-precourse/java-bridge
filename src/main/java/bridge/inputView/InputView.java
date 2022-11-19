package bridge.inputView;

import bridge.inputView.exception.IllegalReadGameCommandException;
import bridge.inputView.exception.IllegalReadMovingException;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int SIZE = 1;


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            final String command = readLine();
            validateElseThrow(command.length() == SIZE, IllegalReadMovingException::new);
            validateElseThrow(command, Arrays.asList("U", "D"), IllegalReadMovingException::new);
            return command;
        } catch (IllegalReadMovingException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            final String command = readLine();
            validateElseThrow(command.length() == SIZE, IllegalReadGameCommandException::new);
            validateElseThrow(command, Arrays.asList("R", "Q"), IllegalReadGameCommandException::new);
            return command;
        } catch (IllegalReadGameCommandException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private void validateElseThrow(boolean isNotError, Supplier<? extends RuntimeException> exception) {
        if (isNotError) {
            return;
        }
        throw exception.get();
    }

    private void validateElseThrow(String readLine, List<String> keys, Supplier<? extends RuntimeException> exception) {
        for (String key : keys) {
            if (readLine.equals(key)) {
                return;
            }
        }
        throw exception.get();
    }


    protected String readLine() {
        return Console.readLine();
    }


}
