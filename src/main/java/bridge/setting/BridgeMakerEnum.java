package bridge.setting;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeMakerEnum {
    DOWN(0, Setting.PLAYER_MOVE_DOWN, 1),
    UP(1, Setting.PLAYER_MOVE_UP, 0);

    private final int randomNumber; // 매칭되는 랜덤 number
    private final char bridge; // MOVE 코드
    private final int row; // 다리 row번째

    BridgeMakerEnum(int randomNumber, char bridge, int row) {
        this.randomNumber = randomNumber;
        this.bridge = bridge;
        this.row = row;
    }

    public Integer randomNumber() {
        return this.randomNumber;
    }

    public Character bridge() {
        return this.bridge;
    }

    private static final Map<Integer, BridgeMakerEnum> BY_RANDOM_NUMBER =
            Stream.of(values()).collect(Collectors.toMap(BridgeMakerEnum::randomNumber, Function.identity()));

    private static final Map<Character, BridgeMakerEnum> BY_MOVE_CODE =
            Stream.of(values()).collect(Collectors.toMap(BridgeMakerEnum::bridge, Function.identity()));

    public static char valuesOfBridge(int randomNumber) {
        return BY_RANDOM_NUMBER.get(randomNumber).bridge;
    }

    public static int valuesOfRandomNumber(Character bridge) {
        return BY_MOVE_CODE.get(bridge).row;
    }
}
