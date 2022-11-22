package bridge;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UserResponse {
    DOWN(0, "D"),
    UP(1, "U"),
    QUIT(-1, "Q"),
    RESTART(-1, "R"),
    ERROR(-1, "[ERROR]");

    private static final Map<String, Integer> CODE_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(UserResponse::getStateInfo, UserResponse::getStateCode))
    );
    final int stateCode;
    final String stateInfo;

    UserResponse(int stateCode, String stateInfo) {
        this.stateCode = stateCode;
        this.stateInfo = stateInfo;
    }

    public int getStateCode() {
        return stateCode;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
