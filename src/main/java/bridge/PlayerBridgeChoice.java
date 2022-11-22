package bridge;

public class PlayerBridgeChoice {

    public static final String UPPER_BRIDGE = "U";
    public static final String LOWER_BRIDGE = "D";

    private final String playerBridgeChoice;

    public PlayerBridgeChoice(String playerBridgeChoice) {
        this.playerBridgeChoice = validate(playerBridgeChoice);
    }

    private String validate(String playerBridgeChoice) {
        validateEmpty(playerBridgeChoice);
        validateBlank(playerBridgeChoice);
        validatePlayerBridgeChoice(playerBridgeChoice);
        return playerBridgeChoice;
    }

    private void validateEmpty(String playerBridgeChoice) {
        if (playerBridgeChoice.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 입력을 하지 않았습니다.");
        }
    }

    private void validateBlank(String playerBridgeChoice) {
        if (playerBridgeChoice.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 입력 값의 공백이 포함 되어있습니다.");
        }
    }

    private void validatePlayerBridgeChoice(String playerBridgeChoice) {
        if (!(playerBridgeChoice.equals(UPPER_BRIDGE) || playerBridgeChoice.equals(LOWER_BRIDGE))) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 대문자 U 또는 D를 입력해주세요.");
        }
    }

    public String getPlayerBridgeChoice() {
        return this.playerBridgeChoice;
    }

}
