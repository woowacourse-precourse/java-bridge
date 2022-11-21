package bridge.domain.vo;

import static java.text.MessageFormat.format;

import java.util.List;
import java.util.function.Predicate;

public abstract class Command {

    private final String message;

    public Command(String message) {
        validate(message, getCorrectValues());
        this.message = message;
    }

    protected abstract List<String> getCorrectValues();

    private void validate(String message,
                          List<String> correctValues) {
        if (isNotCorrectValue(message,correctValues)) {
            throw new IllegalArgumentException(format("{0} 이외의 값은 허용되지 않습니다. 입력값 : {1}",
                    String.join(",", correctValues), message));
        }
    }

    private boolean isNotCorrectValue(String message, List<String> correctValues) {
        return correctValues.stream()
                .noneMatch(Predicate.isEqual(message));
    }

    public String getMessage() {
        return message;
    }
}
