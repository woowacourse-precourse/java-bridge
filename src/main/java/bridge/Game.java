package bridge;

import java.util.List;

public class Game {
    private InputView inputView = new InputView();


    public boolean run() {
        Bridge bridge = new Bridge(inputView.readBridgeSize());
        for (String str : bridge.getBridge()) {
            System.out.println(str);
        }
        return false;
    }

}
