package bridge.view.input;

import bridge.domain.value.BridgeSize;
import camp.nextstep.edu.missionutils.Console;

import static bridge.utils.ViewMessages.BRIDGE_SIZE;
import static bridge.view.OutputView.printNewLine;

public class BridgeSizeInput implements Input<BridgeSize> {
    @Override
    public BridgeSize read() {
        System.out.println(BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        printNewLine();
        return new BridgeSize(bridgeSize);
    }
}
