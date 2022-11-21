package bridge.validator;

import java.util.List;

public class RestartCommandValidator implements CommandValidator {
    final List<String> commands = List.of("R", "Q");

    @Override
    public boolean isCorrectCommand(String target) {
        return commands.contains(target);
    }

    @Override
    public String getValidCommand(String target) {
        if (!isCorrectCommand(target)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 재시작 및 종료 명령어는 %s만 입력할 수 있습니다.", getCommandsDescription())
            );
        }
        return target;
    }

    @Override
    public String getCommandsDescription() {
        StringBuilder commandsDescription = new StringBuilder();
        commands.forEach(command -> {
            commandsDescription.append(command);
        });
        return String.join(COMMAND_SEPARATOR, commandsDescription.toString());
    }
}
