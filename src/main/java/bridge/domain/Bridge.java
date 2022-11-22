package bridge.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Bridge {
    private List<Command> answers;

    public Bridge(List<Command> answers) {
        this.answers = answers;
    }

    public List<Command> getAnswers() {
        return answers;
    }

    //비교 할 수 있는 메서드.
    public Result compare(Command command, int index) {
        if (this.answers.get(index).equals(command)) {
            return Result.SUCCESS;
        }
        return Result.FAIL;
    }

    private static Command handleRandomStringToCommand(String commandKey) {
        Optional<Command> optionalCommand = Arrays.stream(Command.values()).filter(
                command -> command.getKey().equals(commandKey)).findFirst();
        if (optionalCommand.isPresent()) {
            return optionalCommand.get();
        }
        throw new IllegalArgumentException("Internal Server Error - 다리 생성 (0,1)");
    }

    public static Bridge mapToBridge(List<String> commandKey) {
        List<Command> commands = new ArrayList<>();
        for (String command : commandKey) {
            commands.add(handleRandomStringToCommand(command));
        }
        return new Bridge(commands);
    }
}
