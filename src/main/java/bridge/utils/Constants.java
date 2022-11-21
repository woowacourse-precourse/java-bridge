package bridge.utils;

import java.util.Arrays;
import java.util.Optional;

public class Constants {

    public static class BridgeSize{
        public static final String READ_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";

        public static final String ERROR_BRIDGE_SIZE_MESSAGE = "[ERROR] 옳바른 다리의 길이를 입력해주세요.";

        public static final String BRIDGE_SIZE_REGEX = "^[3-9]{1}$|^1[0-9]{1}$|^20$";
    }

    public enum BridgeRoute{
        UP(1, "U"),
        DOWN(0, "D");

        private final int routeCode;
        private final String routh;

        BridgeRoute(int routeCode, String routh){
            this.routeCode = routeCode;
            this.routh = routh;
        }

        public static Optional<BridgeRoute> getMatchRoute(int routeCode){
            return Arrays.stream(BridgeRoute.values())
                    .filter(route -> route.getRouteCode() == routeCode)
                    .findAny();
        }

        private int getRouteCode(){
            return this.routeCode;
        }

        public String getRouth(){
            return this.routh;
        }
    }
}
