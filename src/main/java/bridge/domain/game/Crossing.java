package bridge.domain.game;

public enum Crossing {
    SUCCESS("O", "성공"),
    FAIL("X", "실패");

    final String value;
    final String success;

    Crossing(String value, String success) {
        this.value = value;
        this.success = success;
    }


}
