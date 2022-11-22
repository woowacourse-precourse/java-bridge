package bridge.Validate;

import bridge.Exception.ErrorType;
import bridge.OutputView;

public class ValidateInput {
    OutputView outputView = new OutputView();

    public void isInputSizeOneOrTwo(String bridgeSizeInput){
        if(bridgeSizeInput == null || bridgeSizeInput.length() > 3 ){
            // 에러 메세지 출력 후 예외 출력
            outputView.printException(ErrorType.NOT_THREE_TO_TWENTY);
            throw new IllegalArgumentException();
        }
    }

    public void isNumber(String bridgeSizeInput){
        char[] inputs = bridgeSizeInput.toCharArray();

        for(char input : inputs){
            if(input < '0' || input > '9'){
                outputView.printException(ErrorType.NOT_THREE_TO_TWENTY);
                throw new IllegalArgumentException();
            }
        }
    }

    public void isNumberThreeToTwenty(int bridgeSize){
        if(bridgeSize < 3 || bridgeSize > 20){
            outputView.printException(ErrorType.NOT_THREE_TO_TWENTY);
            throw new IllegalArgumentException();
        }
    }
}
