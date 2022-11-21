package bridge;

import java.util.List;

public class Bridge {
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
