package bridge.model;


import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Bridgelocation {
    ERROR(new Bridge(" ", " "), (userInput, match) -> !userInput.equals("U") && !userInput.equals("D")),
    UPO(new Bridge("O", " "), (userInput, match) -> userInput.equals("U") && match),
    UPX(new Bridge("X", " "), (userInput, match) -> userInput.equals("U") && !match),
    DOWNO(new Bridge(" ", "O"), (userInput, match) -> userInput.equals("D") && match),
    DOWNX(new Bridge(" ", "X"), (userInput, match) -> userInput.equals("D") && !match);

    private final Bridge bridge;
    private final BiPredicate<String, Boolean> isMatch;

    Bridgelocation(Bridge bridge, BiPredicate<String, Boolean> isMatch) {
        this.bridge = bridge;
        this.isMatch = isMatch;
    }

    public static Bridgelocation valueOf(String userInput, boolean match) {
        return Arrays.stream(Bridgelocation.values())
                .filter(bridgelocation -> bridgelocation.isMatch.test(userInput, match))
                .findAny()
                .orElse(ERROR);
    }

    public Bridge getBridge() {
        return bridge;
    }

}
