package bridge.Controller;

import static bridge.Utils.Constants.FALSE;
import static bridge.Utils.Constants.RIGHT;

import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.BridgeMaker;
import bridge.Domain.BridgeMap;
import bridge.View.InputView;
import bridge.View.OutputView;
import java.util.List;

public class BridgeController {

    OutputView output;
    InputView input;
    BridgeMaker bridgeMaker;
    BridgeMap result;

    public BridgeController() {
        output = new OutputView();
        input = new InputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        result = new BridgeMap();
    }

    public List<String> startAndGetAnswerBridge() {
        output.printStart();
        return getAnswerBridge();
    }

    private List<String> getAnswerBridge() {
        try {
            output.printGetBridgeSize();
            int bridgeSize = input.readBridgeSize();
            return bridgeMaker.makeBridge(bridgeSize);
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return getAnswerBridge();
        }
    }

    public String getMoving() {
        try {
            output.printGetMoving();
            return input.readMoving();
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return getMoving();
        }
    }

    public boolean checkMatching(List<String> answer, List<String> user) {
        int index = user.size() - 1;
        String answerAlphabet = answer.get(index);
        String userAlphabet = user.get(index);
        boolean matching = matching(answerAlphabet, userAlphabet);
        output.printMap(result.toString());
        return matching;
    }

    private boolean matching(String answerAlphabet, String userAlphabet) {
        if (answerAlphabet.equals(userAlphabet)) {
            result.add(userAlphabet, RIGHT);
            return true;
        }
        result.add(userAlphabet, FALSE);
        return false;
    }
}
