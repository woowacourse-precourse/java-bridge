package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constant.Config.ERROR;

public enum BridgeType {
    U(1),
    D(0);

    private static final String VALUE_ERROR = ERROR + String.format("%d 또는 %d이 아닙니다.", U.getNumber(), D.getNumber());
    private final int number;

    BridgeType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static String getStringByNumber(int number) {
        return Arrays.stream(values())
                .filter(type -> type.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(VALUE_ERROR))
                .toString();
    }

    public static List<BridgeType> getListByStringList(List<String> bridge) {
        return bridge.stream()
                .map(BridgeType::valueOf)
                .collect(Collectors.toList());
    }

    public boolean isEquals(BridgeType type) {
        return this.equals(type);
    }

    public boolean isEqualsMark(String mark) {
        return this.equals(valueOf(mark));
    }
}
