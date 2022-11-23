package model.bridge;

import model.TypeCheck;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PositionType implements TypeCheck {

    U(1),
    D(0);

    private static final String VALUE_ERROR = String.format("%d 또는 %d이 아닙니다.", U.getNumber(), D.getNumber());
    private static final String OTHER_TYPE_ERROR = "다른 타입을 찾을 수 없습니다.";
    private final int number;

    PositionType(int number) {
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

    public static List<PositionType> getListByStringList(List<String> bridge) {
        return bridge.stream()
                .map(PositionType::valueOf)
                .collect(Collectors.toList());
    }

    public static PositionType getOtherType(PositionType position) {
        return Arrays.stream(values())
                .filter(type -> type != position)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(OTHER_TYPE_ERROR));
    }

    @Override
    public boolean isEqualsMark(String mark) {
        return this.toString().equals(mark);
    }
}
