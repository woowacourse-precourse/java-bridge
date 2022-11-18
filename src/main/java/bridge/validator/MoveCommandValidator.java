package bridge.validator;

import java.util.List;

public class MoveCommandValidator implements CommandValidator {
    final List<String> commands = List.of("U", "D");

    @Override
    public boolean isCorrectCommand(String target) {
        return commands.contains(target);
    }

    public String getValidCommand(String target) {
        if (!isCorrectCommand(target)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U또는 D만 입력할 수 있습니다.");
        }
        return target;
    }
}
