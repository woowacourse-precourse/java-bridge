package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        try {
            System.out.println(Constants.INPUT_BRIDGE_SIZE);
            String input = Console.readLine();
            if (!input.matches(Constants.CHECK_IS_NUMBER)) {
                throw new IllegalArgumentException(Constants.BRIDGE_SIZE_ERROR_MESSAGE);
            }
            int bridgeSize = Integer.parseInt(input);
            if (!(bridgeSize >= 3 && bridgeSize <= 20)) {
                throw new IllegalArgumentException(Constants.BRIDGE_SIZE_ERROR_MESSAGE);
            }
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public String readMoving() {
        try {
            System.out.println(Constants.INPUT_MOVING_SPACE);
            String movingSpace = Console.readLine();
            if (movingSpace.length() != 1 || !movingSpace.equals(Constants.UPSIDE) && !movingSpace.equals(Constants.DOWNSIDE)) {
                throw new IllegalArgumentException(Constants.USER_MOVE_SPACE_ERROR_MESSAGE);
            }
            return movingSpace;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Constants.ERROR;
        }
    }

    public String readGameCommand() {
        try {
            System.out.println(Constants.INPUT_RETRY_CHOICE);
            String status = Console.readLine();
            if (status.length() != 1 || !status.equals(Constants.RESTART) && !status.equals(Constants.QUIT)) {
                throw new IllegalArgumentException(Constants.USER_RESTART_ERROR_MESSAGE);
            }
            return status;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Constants.ERROR;
        }
    }
}
