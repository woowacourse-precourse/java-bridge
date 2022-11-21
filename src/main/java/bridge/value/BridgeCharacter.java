package bridge.value;

import static bridge.validate.BridgeValidation.validateBridgeCharacter;
import static bridge.validate.BridgeValidation.validateBridgeValue;

import java.util.Arrays;

public enum BridgeCharacter {
    UP(1,"U"),
    DOWN(0,"D");

    private final int value;
    private final String character;

    public static BridgeCharacter makeBridgeCharacter(int value) {
        validateBridgeValue(value);
        return Arrays.stream(BridgeCharacter.values())
                .filter(bridgeCharacter -> bridgeCharacter.value == value)
                .findAny().get();
    }

    public static BridgeCharacter makeBridgeCharacter(String character) {
        validateBridgeCharacter(character);
        return Arrays.stream(BridgeCharacter.values())
                .filter(bridgeCharacter -> bridgeCharacter.character.equals(character))
                .findAny().get();
    }

    public int getValue() {
        return value;
    }

    BridgeCharacter(int value, String character) {
        this.value = value;
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
}
