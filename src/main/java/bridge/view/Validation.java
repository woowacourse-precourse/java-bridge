package bridge.view;

public class Validation {

    private void checkNull(String bridgeSize) throws NullPointerException {

        if (bridgeSize == null) {
            throw new NullPointerException();
        }
    }

    private void checkNumberOfBridgeSize(String bridgeSize) throws IllegalArgumentException {

        int translatedBridgeSize = Integer.parseInt(bridgeSize);

        if (translatedBridgeSize < 3 || translatedBridgeSize > 20) {
            throw new IllegalArgumentException();
        }
    }

    private void checkLengthOfBridgeSize(String bridgeSize) throws IllegalArgumentException {

        int stringLength = bridgeSize.length();

        if (stringLength < 1 || stringLength > 2) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInteger(String bridgeSize) throws IllegalArgumentException {

        for (char argument : bridgeSize.toCharArray()) {
            if (argument < '0' || argument > '9') {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkValueOfMoveCommand(String inputMoveCommand) throws IllegalArgumentException {

        char translatedMoveCommand = inputMoveCommand.charAt(0);

        if (translatedMoveCommand == 'D' || translatedMoveCommand == 'U') {
            return;
        }
        throw new IllegalArgumentException();
    }

    private void checkLengthOfCommand(String inputCommand) throws IllegalArgumentException {

        if (inputCommand.length() != 1) {
            throw new IllegalArgumentException();
        }
    }

    private void checkValueOfGameCommand(String inputGameCommand) throws IllegalArgumentException {
        char translatedMoveCommand = inputGameCommand.charAt(0);

        if (translatedMoveCommand == 'R' || translatedMoveCommand == 'Q') {
            return;
        }
        throw new IllegalArgumentException();
    }

    public void checkIntegrationBridgeSize(String bridgeSize) throws IllegalArgumentException, NullPointerException {

        checkNull(bridgeSize);
        checkLengthOfBridgeSize(bridgeSize);
        checkInteger(bridgeSize);
        checkNumberOfBridgeSize(bridgeSize);
    }

    public void checkIntegrationMoveCommand(String inputMoveCommand) throws IllegalArgumentException, NullPointerException {

        checkNull(inputMoveCommand);
        checkLengthOfCommand(inputMoveCommand);
        checkValueOfMoveCommand(inputMoveCommand);
    }

    public void checkIntegrationGameCommand(String inputGameCommand) throws IllegalArgumentException, NullPointerException {

        checkNull(inputGameCommand);
        checkLengthOfCommand(inputGameCommand);
        checkValueOfGameCommand(inputGameCommand);
    }
}
