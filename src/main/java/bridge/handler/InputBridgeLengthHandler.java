package bridge.handler;

import bridge.view.PrintView;

public class InputBridgeLengthHandler {

    public String checkValidator(String bridgeLength){
        checkNonInput(bridgeLength);
        checkIsNumber(bridgeLength);
        checkInRange(bridgeLength);
        checkOverIntegerRange(bridgeLength);

        return bridgeLength;
    }

    public void checkOverIntegerRange(String bridgeLength) {
        PrintView printView = new PrintView();
        long length = Long.parseLong(bridgeLength);

        if(length > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(printView.ERROR_ORDER+" 받아들일 수 있는 정수값을 초과하였습니다.");
        }
    }

    public void checkNonInput(String bridgeLength) {
        PrintView printView = new PrintView();

        if(bridgeLength.length() == 0) {
            throw new IllegalArgumentException(printView.ERROR_ORDER+" 다리 길이의 값이 입력되지 않았습니다.");
        }
    }

    public void checkIsNumber(String bridgeLength) {
        PrintView printView = new PrintView();

        boolean checkNumeric = bridgeLength.matches("[+-]?\\d*(\\.\\d+)?");

        if(!checkNumeric) {
            throw new IllegalArgumentException(printView.ERROR_ORDER + " 다리 길이 입력값은 숫자여야 합니다.");
        }
    }

    public void checkInRange(String bridgeLength) {
        PrintView printView = new PrintView();

        int bridgeLengthNumber = Integer.parseInt(bridgeLength);

        if(bridgeLengthNumber < 3 || bridgeLengthNumber > 20){
            throw new IllegalArgumentException(printView.ERROR_ORDER + " 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}