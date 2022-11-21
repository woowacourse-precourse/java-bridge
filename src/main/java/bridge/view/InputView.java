package bridge.view;

import bridge.service.TypeChange;
import bridge.service.Valification;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final Valification valification;
    private final TypeChange typeChange;

    public InputView(Valification valification, TypeChange typeChange) {
        this.valification = valification;
        this.typeChange = typeChange;
    }

    private String readLine() {
        return Console.readLine();
    }

    public int readBridgeSize() {
        int size = typeChange.ChangeStringToInteger(readLine());
        valification.verifyBridgeSize(size);

        return size;
    }

    public String readMoving() {
        String move = readLine();
        valification.verifyUorD(move);

        return move;
    }

    public String readGameCommand() {
        String retry = readLine();
        valification.verifyQorR(retry);

        return retry;
    }
}
