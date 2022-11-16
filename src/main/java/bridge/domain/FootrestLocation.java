package bridge.domain;

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
}
