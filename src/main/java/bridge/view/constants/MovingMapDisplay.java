package bridge.view.constants;

/**
 * 이동 현황 지도의 표현 기호를 저장하고 이동 결과에 따라 맞는 기호를 변환해주는 상수 클래스
 */
public enum MovingMapDisplay {

    SUCCESS("O"),
    FAIL("X"),
    NOTHING(" ");

    private final String display;

    MovingMapDisplay(String display) {
        this.display = display;
    }

    public static String convert(boolean isFailedMoving, boolean isSameStepMoving) {
        if (isSameStepMoving) {
            return convertResultToDisplay(isFailedMoving);
        }
        return NOTHING.getDisplay();
    }

    private String getDisplay() {
        return display;
    }

    private static String convertResultToDisplay(boolean isFailedMoving) {
        if (isFailedMoving) {
            return FAIL.getDisplay();
        }
        return SUCCESS.getDisplay();
    }
}
