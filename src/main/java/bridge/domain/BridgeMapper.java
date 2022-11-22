package bridge.domain;

import java.util.Arrays;

public enum BridgeMapper {
    UP(1, "U"), DOWN(0, "D");

    private int number;
    private String upDownInformation;

    BridgeMapper(final int number, final String upDownInformation) {
        this.number = number;
        this.upDownInformation = upDownInformation;
    }

    public int getNumber() {
        return this.number;
    }

    public String getUpDownInformation() {
        return this.upDownInformation;
    }

    public static BridgeMapper findUpDownStatus(final int number) {
        return Arrays.stream(values())
                .filter(element -> element.number == number)
                .findAny()
                .orElse(null);
    }
}
