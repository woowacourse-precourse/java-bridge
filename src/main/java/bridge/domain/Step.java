package bridge.domain;

import java.util.Arrays;

public enum Step {

    UP("U", 1),
    DOWN("D", 0);

    private static final String ERROR_STEP = "방향은 %s와 %s 만 가능합니다.%n";
    private final String userInputDirection;
    private final Integer systemInputDirection;

    private Step(String userInputDirection, Integer systemInputDirection) {
        this.userInputDirection = userInputDirection;
        this.systemInputDirection = systemInputDirection;
    }

    public static Step findByUserInputDirection(String userInputDirection) {
        return Step.findBy((step) -> step.userInputDirection.equals(userInputDirection));
    }

    public static String findUserInputDirectionBySystemInputDirection(Integer systemInputDirection) {
        return findBySystemInputDirection(systemInputDirection).userInputDirection;
    }

    public static Step findBySystemInputDirection(Integer systemInputDirection) {
        return Step.findBy((step) -> step.systemInputDirection.equals(systemInputDirection));
    }

    private static Step findBy(Matcher matcher) {
        return Arrays.stream(Step.values())
                .filter(matcher::match)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format(ERROR_STEP, Step.UP.userInputDirection, Step.DOWN.userInputDirection)));
    }


    private interface Matcher {

        boolean match(Step step);
    }
}

