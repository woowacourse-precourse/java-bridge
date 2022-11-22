package bridge.domain;

import bridge.exception.MovingOptionNotAllowedException;
import java.util.Arrays;

public enum BridgeConverter {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String position;

    BridgeConverter(int number, String position){
        this.number = number;
        this.position = position;
    }

    public static String generatePosition(int number){
        BridgeConverter bridge = Arrays.stream(BridgeConverter.values())
                .filter(bridgeNumber -> number == bridgeNumber.number)
                .findAny()
                .orElseThrow(MovingOptionNotAllowedException::new);
        return bridge.position;
    }
}
