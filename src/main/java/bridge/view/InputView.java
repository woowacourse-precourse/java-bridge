package bridge.view;

import bridge.constants.Message;
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
        System.out.println(Message.REQUEST_SIZE.getValue());
        int size = typeChange.ChangeStringToInteger(readLine());
        System.out.println(Message.EMPTY.getValue());
        valification.verifyBridgeSize(size);

        return size;
    }

    public String readMoving() {
        return repeatInputAfterException(this::inputMoving);
    }

    private String inputMoving() {
        System.out.println(Message.REQUEST_BRIDGE.getValue());
        String move = readLine();
        valification.verifyUorD(move);

        return move;
    }

    public String readGameCommand() {
        return repeatInputAfterException(this::inputGameCommand);
    }

    private String inputGameCommand() {
        System.out.println(Message.REQUEST_RETRY.getValue());
        String retry = readLine();
        valification.verifyQorR(retry);

        return retry;
    }

    private <T> T repeatInputAfterException(Supplier<T> inputMethod) {
        while (true) {
            try {
                return inputMethod.get();
            } catch (IllegalArgumentException exception) {
                System.out.println(Message.ERROR_PREFIX.getValue() + exception);
            }
        }
    }


}
