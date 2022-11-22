package constants;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Command {
    RETRY("R", true),
    END("Q", false);

    private final String choice;
    private final boolean value;

    Command(String choice, boolean value) {
        this.choice = choice;
        this.value = value;
    }

    public String getChoice() {
        return choice;
    }

    public boolean getValue() {
        return value;
    }

    private static final Map<String, Boolean> BY_CHOICE =
            Stream.of(values()).collect(Collectors.toMap(Command::getChoice, Command::getValue));

    public static boolean choiceToValue(String choice) {
        return BY_CHOICE.get(choice);
    }
}
