package bridge.domain.exception;

import bridge.domain.resources.Bridge;

public class SizeIllegalArgumentException extends IllegalArgumentException{

    private static final String BETWEEN_3_AND_20 = String.format("[ERROR] 다리 길이의 범위는 %d ~ %d 입니다.", Bridge.MIN_SIZE, Bridge.MAX_SIZE);

    public SizeIllegalArgumentException() {
        super(BETWEEN_3_AND_20);
    }
}
