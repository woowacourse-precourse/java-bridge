package bridge.model.domains.validator;

import bridge.model.domains.constants.BridgeSize;
import bridge.model.domains.constants.Step;

import java.util.List;

/**
 * 도메인 로직의 다리 관련 예외 사항을 검증하고 예외를 발생시키는 클래스
 */
public class BridgeValidator {

    private BridgeValidator() { }

    public static void validateBridge(List<String> bridge) {
        if (bridge == null) {
            throw new NullPointerException("다리 정보는 null일 수 없습니다.");
        }
        validateBridgeSize(bridge.size());
        validateBridgeSteps(bridge);
    }

    public static void validateBridgeSize(int size) {
        if (isOddBridgeSize(size)) {
            throw new IllegalArgumentException("다리의 길이는 3 이상 20 이하만 허용됩니다.");
        }
    }

    private static boolean isOddBridgeSize(int size) {
        return size < BridgeSize.MINIMUM.getValue() || size > BridgeSize.MAXIMUM.getValue();
    }

    public static void validateBridgeSteps(List<String> bridge) {
        for (String step : bridge) {
            validateStep(step);
        }
    }

    public static void validateStep(String step) {
        if (isOddStep(step)) {
            throw new IllegalArgumentException("다리의 칸 정보는 U 또는 D으로 표현해야 합니다.");
        }
    }

    private static boolean isOddStep(String step) {
        if (step == null) {
            return true;
        }
        return notEqualsWithAnyStep(step);
    }

    private static boolean notEqualsWithAnyStep(String step) {
        if (step.equals(Step.UP.getValue())) {
            return false;
        }
        return !step.equals(Step.DOWN.getValue());
    }
}
