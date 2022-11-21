package bridge.Domain;

public class RestartValidator {
    private final String restartWord;

    public RestartValidator(String restartWord) {
        validate(restartWord);
        this.restartWord = restartWord;
    }

    private void validate(String bridgeSize) {
        if (!bridgeSize.equals("R") && !bridgeSize.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] \"R\" 또는 \"Q\"를 입력해야 합니다.");
        }
    }

    public String getRestartWord() {
        return restartWord;
    }
}
