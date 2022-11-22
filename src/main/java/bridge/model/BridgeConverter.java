package bridge.model;

import java.util.List;
import java.util.stream.Collectors;

public class BridgeConverter {

    public static final String UP = "U";
    public static final String DOWN = "D";

    public List<String> convert(List<Integer> numberBridge) {
        return numberBridge.stream()
                .map(this::convertString)
                .collect(Collectors.toList());
    }

    private String convertString(int number) {
        if (number == 1) {
            return UP;
        }
        return DOWN;
    }
}
