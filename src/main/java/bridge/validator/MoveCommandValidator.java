package bridge.validator;

import java.util.ArrayList;
import java.util.List;

public class MoveCommandValidator implements CommandValidator {
    final List<String> commands = List.of("U", "D");

    @Override
    public boolean isCorrectCommand(String target) {
        return commands.contains(target);
    }

    @Override
    public String getValidCommand(String target) {
        if (!isCorrectCommand(target)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 이동할 칸은 %s만 입력할 수 있습니다.", getCommandsDescription())
            );
        }
        return target;
    }

    @Override
    public String getCommandsDescription() {
        List<String> validCommands = new ArrayList<>();
        commands.forEach(command -> {
            validCommands.add(command);
        });
        return String.join(COMMAND_SEPARATOR, validCommands);
    }
}
