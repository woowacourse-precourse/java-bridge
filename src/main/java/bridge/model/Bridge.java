package bridge.model;

import bridge.utils.Mark;

import java.util.List;

public class Bridge {
    public static final int MIN = 3;
    public static final int MAX = 20;
    private final List<String> bridgeRoute;

    public Bridge(List<String> bridgeRoute) {
        this.bridgeRoute = bridgeRoute;
    }

    public Mark matchRoute(String inputDirection, int movingCount) {
        boolean isRight = bridgeRoute.get(movingCount).equals(inputDirection);
        return Mark.toMark(inputDirection, isRight);
    }

    public boolean isLast(int movingCount) {
        return bridgeRoute.size() == movingCount;
    }
}
