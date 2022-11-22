package bridge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BridgeGame {

    protected static final String RETRY = "R";
    protected static final String QUIT = "Q";
    protected static final String O = "O";
    protected static final String X = "X";


    private final BridgeMaker bridgeMaker;


    private List<String> bridge;


    public BridgeGame() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    public void start(int size) {
        bridge = bridgeMaker.makeBridge(size);
    }

    public String move(String currBridgeIndex ,String input) {
        if (currBridgeIndex.equals(input)) {
            return O;
        }
        return X;
    }
    public boolean retry(String command) {
        return command.equals(RETRY);
    }

    public List<String> getBridge(){
        return this.bridge;
    }

}