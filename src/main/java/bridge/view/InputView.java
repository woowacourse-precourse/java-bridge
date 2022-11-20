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
        System.out.println("다리의 길이를 입력해주세요.");
        return read(
                () -> validate(Integer::parseInt, readLine(), "숫자를 입력하세요"),
                exceptionHandler);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(Consumer<IllegalArgumentException> exceptionHandler) {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return read(
                () -> validate(Validation::validateMove, readLine(), "U와 D 중 하나만 입력하세요"),
                exceptionHandler
        );
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(Consumer<IllegalArgumentException> exceptionHandler) {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return read(
                () -> validate(Validation::validateCommand, readLine(), "R와 Q 중 하나만 입력하세요"),
                exceptionHandler
        );
    }

    private <T> T validate(Function<String, T> callback, String input, String message) {
        try {
            return callback.apply(input);
        } catch (NumberFormatException | CommandException | MoveException e) {
            throw new IllegalArgumentException(message);
        }
    }

    private <T> T read(Supplier<T> readFunction, Consumer<IllegalArgumentException> exceptionHandler) {
        T inputValue = null;
        while (inputValue == null) {
            inputValue = input(readFunction, exceptionHandler);
        }
        return inputValue;
    }

    private <T> T input(Supplier<T> readFunction, Consumer<IllegalArgumentException> exceptionHandler) {
        try {
            return readFunction.get();
        } catch (IllegalArgumentException e) {
            exceptionHandler.accept(e);
            return null;
        }
    }

    private String readLine() {
        return Console.readLine();
    }
}
