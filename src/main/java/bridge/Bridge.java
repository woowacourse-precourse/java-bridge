package bridge;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private int pos = 0;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean matchBridge(String uOrD) {
        return bridge.get(pos).equals(uOrD);
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public boolean checkResult() {
        return bridge.size() == pos;
    }

    public int getPos() {
        return pos;
    }
    public void increasePos() {
        this.pos++;
    }
    public String inputMoving() {
        while(true){
            try{
                return InputView.readMoving();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
    public String inputGameCommand() {
        while(true){
            try{
                return InputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public String getBridgeValue(int idx) {
        return bridge.get(idx);
    }
}
