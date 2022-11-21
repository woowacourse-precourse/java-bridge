package bridge.view.io;

import static bridge.domain.bridge.BridgeSize.makeBridgeSize;
import static bridge.value.BridgeCharacter.makeBridgeCharacter;
import static bridge.value.GameCommand.makeGameCommand;
import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.domain.bridge.BridgeSize;
import bridge.value.BridgeCharacter;
import bridge.value.GameCommand;

public class InputView {


    public BridgeSize readBridgeSize() {
        return makeBridgeSize(readLine());
    }

    public BridgeCharacter readMoving() {
        return makeBridgeCharacter(readLine());
    }

    public GameCommand readGameCommand() {
        return makeGameCommand(readLine());
    }
}
