package bridge.command;

import java.util.List;

public interface Command {
    List<String> executeAll(List<String> answer, List<String> history);
    void executeConditionUCorrect(int index);

    void executeConditionUInCorrect(int index);
    void executeConditionDCorrect(int index);
    void executeConditionDInCorrect(int index);
}
