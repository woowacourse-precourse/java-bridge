package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.InputMismatchException;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    static String alpha = "abcdefghijklmnopqrstuvwxyzABCEFGHIJKLMNOPQRSTVWXYZ1234567890!@#$%^&*()_+?.,<>~`\"|/";
    static String command = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPSTUVWXYZ1234567890!@#$%^&*()_+?.,<>~`\"|/";
    static List<String> isAlpha = List.of(alpha.split(""));
    static List<String> isCommand = List.of(command.split(""));


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.START_GAME);
        System.out.println(Message.INPUT_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        int BridgeSize = Integer.parseInt(bridgeSize);
        rangeErr(BridgeSize);
        return BridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.SELECT_MOVE);
        String move = Console.readLine();
        throwException(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String check = Console.readLine();
        commandError(check);
        return check;
    }
    public void throwException(String input){
        if(input.length()>1){
            throw new IllegalStateException();
        }
        if(input==""){
            throw new IllegalStateException();
        }
        for(int i = 0; i<isAlpha.size(); i++ ){
            if(isAlpha.contains(input)){
                throw new IllegalStateException();
            }
        }
    }
    public void commandError(String check){
        if(check.length()>1){
            throw new InputMismatchException();
        }
        if(check==""){
            throw new InputMismatchException();
        }
        for(int i=0; i<isCommand.size(); i++){
            if(isCommand.contains(check)){
                throw new InputMismatchException();
            }
        }
    }
    public void rangeErr(int BridgeSize){
        if(BridgeSize<3 || BridgeSize>20){
            throw new IllegalArgumentException();
        }
    }
}
