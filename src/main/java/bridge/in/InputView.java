package bridge.in;

import bridge.domain.Command;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Optional;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    final List<Command> RETRY_COMMAND = List.of(Command.RETRY, Command.EXIT);
    final List<Command> MOVE_COMMAND = List.of(Command.UP, Command.DOWN);
    final int VALID_SIZE = 1;
    private String input;

    /**
     * 다리의 길이를 입력받는다.
     * */
    // 일단 여기서 데이터 검증 로직 추가.
    // 추후 DTO 같은 곳에서 검증 할 수 도 있음.
    // View 에서 검증을 하는게 맞나?
    public int readBridgeSize() {
        try {
            input = Console.readLine();
            validateBridgeSizeInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            input = Console.readLine();
            validateCommand(MOVE_COMMAND, input, VALID_SIZE);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            readMoving();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        try {
            input = Console.readLine();
            validateCommand(RETRY_COMMAND, input, VALID_SIZE);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            readGameCommand();
        }
        return convertInputToCommand(input, RETRY_COMMAND);
    }

    public void validateBridgeSizeInput(String input) {
        validateBridgeSizeRange(validateParseInteger(input));
    }

    private int validateParseInteger(String input) {
        int result = 0;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("다리 길이는 숫자여야합니다.");
        }
        return result;
    }

    private void validateBridgeSizeRange(int input) {
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException("다리 길이 범위를 확인해주세요");
        }
    }

    public void validateCommand(List<Command> commands, String inputCommand, int validSize) {
        checkNotLargeThenValidSize(inputCommand, validSize);
        checkValidateCommandInput(commands, inputCommand);
    }

    private Command convertInputToCommand(String input, List<Command> commands) {
        Optional<Command> optionalCommand = commands.stream().filter(
                command -> command.getKey().equals(input)).findFirst();
        if (optionalCommand.isPresent()) {
            return optionalCommand.get();
        }
        throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
    }

    //확장성을 고려. [좀 더 서비스에 핏하게 짜는것이 맞나 라는 고민. -> ==1]
    private void checkNotLargeThenValidSize(String input, int validSize) {
        if (input.length() > validSize) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }

    //로직 다시 한번 생각해보자.
    //띄어쓰기도 맞는지 확인.
    private void checkValidateCommandInput(List<Command> commands, String input) {
        long count = commands.stream().filter(
                command -> command.getKey().equals(input)).count();
        if (count == 0) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }
}
