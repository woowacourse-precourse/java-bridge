package bridge.enums;

import java.util.Arrays;

public enum ErrorMessage {
    INVALID_BRIDGE_SIZE("잘못된 값이 입력되었습니다. 양의 정수만 입력해주세요."),
    OUT_OF_RANGE_BRIDGE_SIZE("다리 길이는 "
            + BridgeRange.getMinValue() + "보다 크거나 같고 " + BridgeRange.getMaxValue()
            + "보다 작거나 같아야 합니다."),
    INVALID_MOVING("잘못된 칸을 입력하셨습니다."),
    INVALID_GAME_COMMAND("재시작 여부를 다시 입력해주세요.");
    private String reference;

    ErrorMessage(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public static String getMessage(String name) {
        return "[ERROR] " +
                Arrays.stream(ErrorMessage.values())
                        .filter(error -> error.name().equals(name))
                        .findAny()
                        .get().getReference();
    }

}
