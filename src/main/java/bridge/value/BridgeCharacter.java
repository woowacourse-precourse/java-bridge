package bridge.value;

import java.util.Arrays;

public enum BridgeCharacter {
    UP(1,"U"),
    DOWN(0,"D");

    private final int value;
    private final String character;

    public static BridgeCharacter MakeBridgeCharacter(int value) {
        return Arrays.stream(BridgeCharacter.values())
                .filter(bridgeCharacter -> bridgeCharacter.value == value)
                .findAny().orElseThrow(() -> new IllegalArgumentException("입력한 값에 해당하는 글자가 존재하지 않습니다."));
    }

    public static BridgeCharacter MakeBridgeCharacter(String character) {
        return Arrays.stream(BridgeCharacter.values())
                .filter(bridgeCharacter -> bridgeCharacter.character.equals(character))
                .findAny().orElseThrow(() -> new IllegalArgumentException("입력한 문자가 존재하지 않습니다."));
    }

    BridgeCharacter(int value, String character) {
        this.value = value;
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
}
