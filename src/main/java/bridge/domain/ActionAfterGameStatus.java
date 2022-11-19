package bridge.domain;

import java.util.Arrays;

public enum ActionAfterGameStatus {
    RESTART("R"), QUIT("Q");

    public String userInput;

    ActionAfterGameStatus(String userInput) {
        this.userInput = userInput;
    }

    public static ActionAfterGameStatus findByUserInput(String userInput) {
        return Arrays.stream(ActionAfterGameStatus.values())
                .filter(each -> each.userInput.equals(userInput))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("R, Q만 입력 가능합니다"));
    }

}
