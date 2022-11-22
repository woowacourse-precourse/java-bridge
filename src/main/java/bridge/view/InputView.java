package bridge.view;

import bridge.model.CheckValidation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static CheckValidation check = new CheckValidation();

    public int readBridgeSize() {
        String inputData;
        int bridgeSize;

        System.out.println(PrintSentence.LENGHT_REQUEST.getSentence());
        inputData = Console.readLine();
        System.out.println();
        check.checklenght(inputData);
        bridgeSize = Integer.parseInt(inputData);
        return bridgeSize;
    }

    public String readMoving() {
        String inputData;

        inputData = Console.readLine();
        check.checkMove(inputData);
        return inputData;
    }

    public String readGameCommand() {
        String inputData;

        inputData = Console.readLine();
        check.checkRetry(inputData);
        return inputData;
    }
}
