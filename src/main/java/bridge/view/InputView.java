package bridge.view;

import bridge.constants.Message;
import camp.nextstep.edu.missionutils.Console;

import java.util.function.Supplier;

public class InputView {

    private final Verification verification;
    private final TypeChange typeChange;

    public InputView(Verification verification, TypeChange typeChange) {
        this.verification = verification;
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
        verification.verifyBridgeSize(size);

        return size;
    }

    public String readMoving() {
        return repeatInputAfterException(this::inputMoving);
    }

    private String inputMoving() {
        System.out.println(Message.REQUEST_BRIDGE.getValue());
        String move = readLine();
        verification.verifyUorD(move);

        return move;
    }

    public String readGameCommand() {
        return repeatInputAfterException(this::inputGameCommand);
    }

    private String inputGameCommand() {
        System.out.println(Message.REQUEST_RETRY.getValue());
        String retry = readLine();
        verification.verifyQorR(retry);

        return retry;
    }

    private <T> T repeatInputAfterException(Supplier<T> inputMethod) {
        while (true) {
            try {
                return inputMethod.get();
            } catch (IllegalArgumentException exception) {
                System.out.println(Message.ERROR_PREFIX.getValue() + exception.getMessage());
            }
        }
    }


}
