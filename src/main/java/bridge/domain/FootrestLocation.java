package bridge.domain;

import java.util.Arrays;

public enum FootrestLocation {
    UP(1, "U"),
    DOWN(0, "D");

    private Integer boardStatus;
    private String userInput;

    FootrestLocation(Integer boardStatus, String userInput) {
        this.boardStatus = boardStatus;
        this.userInput = userInput;
    }

    public Integer getBoardStatus() {
        return boardStatus;
    }

    public String getUserInput() {
        return userInput;
    }

    public static FootrestLocation valueOfUsingUserInput(String userInput) {
        return Arrays.stream(FootrestLocation.values())
                .filter(each -> each.userInput.equals(userInput))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("U,D만 입력 가능합니다"));
    }
}
