package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker= new BridgeMaker(bridgeRandomNumberGenerator);
    public static List<String> main_Bridge = new ArrayList<>();
    public static void main(String[] args) {
       StartGame.gameStart();
    }
}
