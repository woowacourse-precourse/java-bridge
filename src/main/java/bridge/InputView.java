package bridge;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */

public class InputView {

    InputView(){
        System.out.println(Constants.START_INFO);
        System.out.println();
    }

    public int readBridgeSize() {
        System.out.println(Constants.INPUT_LENGTH_INFO);
        int bridgeLength = 0;
        /**
         * 다리의 길이를 입력받는다.
         */
        while (true) {
            bridgeLength = Integer.valueOf(Console.readLine());
            if (checkBridgeLength(bridgeLength)){
                break;
            }
        }
        System.out.println(bridgeLength);
        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Constants.INPUT_MOVING_INFO);
        String movingCommand;

        while (true) {
            movingCommand = Console.readLine();
            if (checkCommand(movingCommand)){
                break;
            }
        }
        return movingCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Constants.RESTART_INFO);
        String restartCommand = Console.readLine();
        return restartCommand;
    }

    public boolean checkBridgeLength(int length){
        try{
        if (length<2 || length >20){
            throw new IllegalArgumentException();
        }
    }catch(IllegalArgumentException e){
            System.out.println(Constants.ERROR_RANGE_INFO);
            return false;
        }
        return true;
    }

    public boolean checkCommand(String command){
        try{
            if (!(command.equals("U") || command.equals("D"))){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            System.out.println(Constants.ERROR_COMMAND_INFO);
            return false;
        }
        return true;
    }
}
