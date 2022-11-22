package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String FORMAT_MESSAGE = "입력값은 숫자여야합니다.";
    PrintCommand printCommand = new PrintCommand();
    Validator validate = new Validator();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeLength;
        while(true){
            printCommand.getBridgeLength();
            bridgeLength=getInput();
            if(bridgeLength!=0){
                break;
            }
        }
        return bridgeLength;
    }

    public int getInput(){
        int bridgeLength;
        try{
            bridgeLength = Integer.valueOf(Console.readLine());
        }catch (NumberFormatException e){
            return showError();
        }
        return validate.bridgeLengthRange(bridgeLength);
    }
    public int showError(){
        System.out.println(ERROR_MESSAGE+FORMAT_MESSAGE);
        try {
            throw new IllegalArgumentException(ERROR_MESSAGE + FORMAT_MESSAGE);
        }
        catch (IllegalArgumentException error){
            return 0;
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movement;
        while(true){
            printCommand.getMovement();
            movement= Console.readLine();
            if(validate.isUpOrDown(movement)){
                break;
            }
        }
        return movement;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String restartOrQuit;
        while(true){
            printCommand.getRestart();
            restartOrQuit=Console.readLine();
            if(validate.isRestartOrQuit(restartOrQuit)){
                break;
            }
        }
        return restartOrQuit;
    }
}
