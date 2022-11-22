package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    OutputView outputView = new OutputView();
    Exceptions exceptions = new Exceptions();
    public int readBridgeSize() {
        outputView.bridgeMakingMessage();
        String input = Console.readLine();
        checkIfFormatableType(input);
        int number = Integer.valueOf(input);
        checkIfAvailableNumber(number);
        System.out.println();
        return number;
    }

    public String readMoving() {
        outputView.readMovingMessage();
        String alphabet = Console.readLine();
        return alphabet;
    }

    public String readGameCommand() {
        outputView.readGameCommandMessage();
        String alphabet = Console.readLine();
        return alphabet;
    }

    public void checkIfAvailableNumber(int number) {
        if (exceptions.checkNumber(number) == false) {
            readBridgeSize();
        }
    }

    public void checkIfFormatableType(String input) {
        if (exceptions.checkNumberIfFormatable(input) == false) {
            readBridgeSize();
        }
    }
}
