package bridge.view;

import bridge.Exception.CommandException;
import bridge.Exception.MoveException;
import bridge.Exception.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(Consumer<IllegalArgumentException> exceptionHandler) {
        return inputUntilValid(
                () -> validateInput(Integer::parseInt, Console.readLine(), "R와 Q 중 하나만 입력하세요"),
                exceptionHandler);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(Consumer<IllegalArgumentException> exceptionHandler) {
        return inputUntilValid(
                () -> validateInput(Validation::validateMove, Console.readLine(), "U와 D 중 하나만 입력하세요"),
                exceptionHandler
        );
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(Consumer<IllegalArgumentException> exceptionHandler) {
        return inputUntilValid(
                () -> validateInput(Validation::validateCommand, Console.readLine(), "R와 Q 중 하나만 입력하세요"),
                exceptionHandler
        );
    }

    private <T> T validateInput(Function<String, T> callback, String input, String message) {
        try {
            return callback.apply(input);
        } catch (NumberFormatException | CommandException | MoveException e) {
            throw new IllegalArgumentException(message);
        }
    }

    private <T> T inputUntilValid(Supplier<T> readFunction, Consumer<IllegalArgumentException> exceptionHandler) {
        T inputValue = null;
        while (inputValue == null) {
            inputValue = readInput(readFunction, exceptionHandler);
        }
        return inputValue;
    }

    private <T> T readInput(Supplier<T> readFunction, Consumer<IllegalArgumentException> exceptionHandler) {
        try {
            return readFunction.get();
        } catch (IllegalArgumentException e) {
            exceptionHandler.accept(e);
            return null;
        }
    }
}
