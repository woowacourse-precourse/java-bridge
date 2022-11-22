package domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public MoveStatus getStatus(int index, String input) {
        if(bridge.get(index).equals(input)) {
            return equalsToString(input);
        }
        return notEqualsToString(input);
    }

    private MoveStatus notEqualsToString(String answer) {
        if(answer.equals(MoveCommand.UP.getCommandString())){
            return MoveStatus.UP_X;
        }
        return MoveStatus.DOWN_X;
    }

    private MoveStatus equalsToString(String answer) {
        if(answer.equals(MoveCommand.UP.getCommandString())){
            return MoveStatus.UP_O;
        }
        return MoveStatus.DOWN_O;
    }

    public int size(){
        return bridge.size();
    }
}
