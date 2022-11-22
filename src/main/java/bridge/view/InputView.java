package bridge.view;

import bridge.constants.Error;
import camp.nextstep.edu.missionutils.Console;

import java.util.function.Supplier;

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
        return repeatInputAfterException(this::inputBridgeSize);
    }

    private int inputBridgeSize() {
        int size = typeChange.ChangeStringToInteger(readLine());
        valification.verifyBridgeSize(size);

        return size;
    }

    public String readMoving() {
        return repeatInputAfterException(this::inputMoving);
    }

    private String inputMoving() {
        String move = readLine();
        valification.verifyUorD(move);

        return move;
    }

    public String readGameCommand() {
        return repeatInputAfterException(this::inputGameCommand);
    }

    public String inputGameCommand() {
        String retry = readLine();
        valification.verifyQorR(retry);

        return retry;
    }

    private <T> T repeatInputAfterException(Supplier<T> inputMethod) {
        while (true) {
            try {
                return inputMethod.get();
            } catch (IllegalArgumentException exception) {
                System.out.println(Error.ERROR_PREFIX.getValue() + exception);
            }
        }
    }


}
