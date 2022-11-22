package bridge.in;

import bridge.domain.Command;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    final List<Command> RETRY_COMMAND = List.of(Command.RETRY, Command.EXIT);
    final List<Command> MOVE_COMMAND = List.of(Command.UP, Command.DOWN);
    final int VALID_SIZE = 1;

    /**
     * 다리의 길이를 입력받는다.
     * */
    // 일단 여기서 데이터 검증 로직 추가.
    // 추후 DTO 같은 곳에서 검증 할 수 도 있음.
    // View 에서 검증을 하는게 맞나?
    public int readBridgeSize() {
        String inputSize = Console.readLine();
        for (int i = 0; i < inputSize.length(); i++) {
            if (!Character.isDigit(inputSize.charAt(i))) {
                throw new IllegalArgumentException("다리 길이는 양의숫자 여야 합니다.");
            }
        }
        return Integer.parseInt(inputSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Command readMoving() {
        String inputCommand = Console.readLine();
        try {
            validateCommand(MOVE_COMMAND, inputCommand, VALID_SIZE);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            readMoving();
        }
        return convertInputToCommand(inputCommand, MOVE_COMMAND);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        String inputCommand = Console.readLine();
        try {
            validateCommand(RETRY_COMMAND, inputCommand, VALID_SIZE);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            readGameCommand();
        }
        return convertInputToCommand(inputCommand, RETRY_COMMAND);
    }

    private void validateCommand(List<Command> commands, String inputCommand, int validSize) {
        checkNotLargeThenValidSize(inputCommand, validSize);
        checkValidateCommandInput(inputCommand, commands);
    }

    private Command convertInputToCommand(String input, List<Command> commands) {
        return commands.stream().filter(command -> command.getKey().equals(input)).findFirst().get();
    }

    //확장성을 고려. [좀 더 서비스에 핏하게 짜는것이 맞나 라는 고민. -> ==1]
    private void checkNotLargeThenValidSize(String input, int validSize) {
        if (input.length() > validSize) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }

    //로직 다시 한번 생각해보자.
    //띄어쓰기도 맞는지 확인.
    private void checkValidateCommandInput(String input, List<Command> commands) {
        Boolean isPresent = commands.stream().map(
                command -> command.getKey().equals(input)).findFirst().get();
        if (!isPresent) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }
}
