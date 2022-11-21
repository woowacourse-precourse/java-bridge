package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int size;

        Announcement.start();
        size = InputView.readBridgeSize();
        start_game(make_bridge(size), size);
        // TODO: 프로그램 구현
    }
    public static List<String> make_bridge(int size){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        return bridge;
    }
    public static void start_game(List<String> bridge, int size){
        String re="R";
        int try_count = 1;
        boolean success = true;

        while(re.contains("R")) {
            success = try_cross(bridge, size);
            if(success_info(size))
                break;
            re = ask_retry();
            try_count = retry_cross(re, try_count);
        }

        print_result(success, try_count);
    }
    public static boolean success_info(int size){
        if(BridgeGame.getUp_bridge().size()==size)
            return true;
        return false;
    }
    public static boolean try_cross(List<String> bridge, int size){
        boolean success = true;
        String move;

        for (int i = 0; i < size; i++) {
            Announcement.move();
            move = InputView.readMoving();
            success = BridgeGame.move(bridge, move, i);
            OutputView.printMap(BridgeGame.getUp_bridge(), BridgeGame.getDown_bridge());
            if (success == false)
                break;
        }
        return success;
    }
    public static String ask_retry(){
        Announcement.restart();
        return InputView.readGameCommand();
    }
    public static int retry_cross(String re, int try_count){
        if(re.contains("R")) {
            try_count += 1;
            BridgeGame.retry();
        }
        return try_count;
    }
    public static void print_result(boolean success, int try_count){
        Announcement.bridge_result();
        OutputView.printMap(BridgeGame.getUp_bridge(), BridgeGame.getDown_bridge());
        OutputView.printResult(success, try_count);
    }
}
