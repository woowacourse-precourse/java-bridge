package bridge.domain;

import java.util.Arrays;

public enum Status {
    SUCCESS("성공", "O", true),
    FAIL("실패","X", false);

    private String name;
    private String symbol;
    private boolean status;

    Status(String name, String symbol, boolean status) {
        this.name = name;
        this.symbol = symbol;
        this.status = status;
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public static Status getByStatus(boolean status) {
        return Arrays.stream(values())
                .filter(Status -> Status.status == status)
                .findFirst()
                .orElseThrow();
    }
}
