package bridge.domain;

import static java.text.MessageFormat.format;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class Command {

    private String message;
    private List<String> correctValues = new ArrayList<>();

    public Command(String message) {
        addCorrectValues(correctValues);
        validate(message);
        this.message = message;
    }

    abstract void addCorrectValues(List<String> correctValues);

    private void validate(String message) {
        if (isNotCorrectValue(message)) {
            throw new IllegalArgumentException(format("{0} 이외의 값은 허용되지 않습니다. 입력값 : {1}",
                    String.join(",", correctValues), message));
        }
    }

    private boolean isNotCorrectValue(String message) {
        return correctValues.stream()
                .noneMatch(Predicate.isEqual(message));
    }

    public String getMessage() {
        return message;
    }
}
