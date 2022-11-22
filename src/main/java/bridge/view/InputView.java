package bridge.view;

import bridge.exception.constant.Exception;
import bridge.exception.input.InputException;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    OutputView outputView;
    public InputView(){
        outputView = new OutputView();
    }
    public String checkBridgeSize(){
        try{
            String bridgeLength = Console.readLine();
            InputException.checkBridgeLengthInput(bridgeLength);
            return bridgeLength;
        }catch (IllegalArgumentException illegalArgumentException){
            String errorMessage= Exception.getErrorMessage(illegalArgumentException.getMessage());
            outputView.printErrorMessage(errorMessage);
        }
        return null;
    }

    public int readBridgeSize() {
        String bridgeLength="";
        do {
            outputView.printEnterBridgeLength();
            bridgeLength=checkBridgeSize();
        }while (Objects.isNull(bridgeLength));
        return Integer.parseInt(bridgeLength);
    }
    
}
