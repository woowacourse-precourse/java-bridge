package bridge;


public class BridgeGame {
    public static boolean move(String randomBridge, String upAndDown) {

        return randomBridge.equals(upAndDown);
    }
        public static void retry(String retry) {
        if(retry.equals("R")){
            Application.clearAndRetry();
        }
        if(retry.equals("Q")){
            Application.exit();
        }
        }
    }

