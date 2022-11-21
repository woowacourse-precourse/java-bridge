package bridge;

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

    public int getSize() {
        return bridgeRoute.size();
    }
}
