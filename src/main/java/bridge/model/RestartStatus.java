package bridge.model;

public class RestartStatus {

    private final String restart;

    public RestartStatus(String userInput) {
        this.restart = userInput;
        validate();
    }

    private void validate() {
        if (!restart.equals("R") && !restart.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값입니다.");
        }
    }

    public String getRestart() {
        return restart;
    }


}