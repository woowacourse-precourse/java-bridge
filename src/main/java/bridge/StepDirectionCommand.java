package bridge;

import java.util.Arrays;

public enum StepDirectionCommand {

    U(1),
    D(0);

    private int number;

    StepDirectionCommand(int number) {
        this.number = number;
    }

    public static String getByNumber(int number) {
        return Arrays.stream(StepDirectionCommand.values())
                .filter(value -> number == value.number)
                .findAny()
                .map(Object::toString)
                .orElse("");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
