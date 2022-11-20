package bridge.setting;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeMakerEnum {
    DOWN(0, Setting.PLAYER_MOVE_DOWN),
    UP(1, Setting.PLAYER_MOVE_UP);

    private final int randomNumber;
    private final char bridge;

    BridgeMakerEnum(int randomNumber, char bridge) {
        this.randomNumber = randomNumber;
        this.bridge = bridge;
    }

    public Integer randomNumber() {
        return this.randomNumber;
    }

    private static final Map<Integer, BridgeMakerEnum> BY_RANDOM_NUMBER =
            Stream.of(values()).collect(Collectors.toMap(BridgeMakerEnum::randomNumber, Function.identity()));

    public static char valuesOfBridge(int randomNumber) {
        return BY_RANDOM_NUMBER.get(randomNumber).bridge;
    }
}
