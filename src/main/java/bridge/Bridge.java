package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<Command> answers;

    public Bridge(List<Command> answers) {
        this.answers = answers;
    }

    //비교 할 수 있는 메서드.
    public Result compare(Command command, int index) {
        if (this.answers.get(index).equals(command)) {
            return Result.SUCCESS;
        }
        return Result.FAIL;
    }

    private static Command handleRandomStringToCommand(String command) {
        if (command.equals("0")) {
            return Command.DOWN;
        } else if (command.equals("1")) {
            return Command.UP;
        }
        throw new IllegalArgumentException("Internal Server Error - 다리 생성 (0,1)");
    }

    public static Bridge mapToBridge(List<String> random) {
        List<Command> commands = new ArrayList<>();
        for (String command : random) {
            commands.add(handleRandomStringToCommand(command));
        }
        return new Bridge(commands);
    }
}
