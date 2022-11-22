package bridge;

public class BridgeSizeGenerator {

    private static final String RANGE_OUT_ERROR_MSG = "다리 길이는 3-20 사이의 숫자 입니다";

    public Integer generate(Integer bridge_size) {
        validate(bridge_size);
        return bridge_size;
    }

    private void validate(Integer bridge_size) {
        if (bridge_size >= 3 && bridge_size <= 20) return;
        throw new IllegalArgumentException(RANGE_OUT_ERROR_MSG);
    }
}
