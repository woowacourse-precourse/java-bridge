package bridge.handler;

import bridge.view.OrderView;

public class InputBridgeLengthHandler {
    OrderView orderView = new OrderView();

    public String checkException(String bridgeLength){
        checkNonInput(bridgeLength);
        checkIsNumber(bridgeLength);
        checkInRange(bridgeLength);
        checkOverRange(bridgeLength);

        return bridgeLength;
    }

    private void checkOverRange(String bridgeLength) {
        long length = Long.parseLong(bridgeLength);

        if(length > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(orderView.ERROR_ORDER+" 받아들일 수 있는 정수값을 초과하였습니다.");
        }
    }

    private void checkNonInput(String bridgeLength) {
        if(bridgeLength.length() == 0) {
            throw new IllegalArgumentException(orderView.ERROR_ORDER+" 다리 길이의 값이 입력되지 않았습니다.");
        }
    }

    private void checkIsNumber(String bridgeLength) {
        boolean checkNumeric = bridgeLength.matches("[+-]?\\d*(\\.\\d+)?");

        if(!checkNumeric) {
            throw new IllegalArgumentException(orderView.ERROR_ORDER + " 다리 길이 입력값은 숫자여야 합니다.");
        }
    }

    private void checkInRange(String bridgeLength) {
        int bridgeLengthNumber = Integer.parseInt(bridgeLength);

        if(bridgeLengthNumber < 3 || bridgeLengthNumber > 20){
            throw new IllegalArgumentException(orderView.ERROR_ORDER + " 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
