package bridge;

import java.util.List;

/*
public class Space {
    private List<String> up;
    private List<String> down;
    private List<String> bridgeMap;

    public Space() {
    }

    public Space(List<String> bridgeMap) {
        this.bridgeMap = bridgeMap;
        for (String block : bridgeMap) {
            expandSpace(block);
        }
    }

    public void expandSpace(String block) {
        if (block.equals("U")) {
            up += "O";
            down += " ";
        }
        up += " ";
        down += "O";
    }

    public Space compareRoute(Space userMovingRoute) {
        List<String> userRoute = userMovingRoute.bridgeMap;
        for (int blockNum = 0; blockNum < userRoute.size(); blockNum++) {
            String bridgeBlock = bridgeMap.get(blockNum);
            String userRouteBlock = userRoute.get(blockNum);
            String result;
            if(bridgeBlock.equals(userRouteBlock)) {

            }
        }
    }

    private void drawRoute(String userBlock, boolean equalsBlock) {
        Space route = new Space();
        String result = "O";
        if (equalsBlock) {
            result = "X";
        }

        if (userBlock.equals("U")) {
            route.up += result;
            route.down += " ";
        }

        if (userBlock.equals("D")) {
            route.up += " ";
            route.down += result;
        }
    }

    public String toString() {
        return up + "\n" + down;
    }
}

 */
