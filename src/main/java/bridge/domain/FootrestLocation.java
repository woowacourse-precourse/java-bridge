package bridge.domain;

import java.util.Arrays;

public enum FootrestLocation {
    UP("U"),
    DOWN("D");

    private String userInput;

    FootrestLocation(String userInput) {
        this.userInput = userInput;
    }

    public static FootrestLocation findByUserInput(String userInput) {
        return Arrays.stream(FootrestLocation.values())
                .filter(each -> each.userInput.equals(userInput))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("U,D만 입력 가능합니다"));
    }

    public String getUserInput() {
        return userInput;
    }
}
