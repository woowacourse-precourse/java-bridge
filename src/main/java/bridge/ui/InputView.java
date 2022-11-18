package bridge.ui;


import bridge.model.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void startGame(){
        printStartMessage();
        System.out.println();
    }
    public String readBridgeSize() {
        printSizeMessage();
        return getInput();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void printStartMessage(){
        System.out.println(GameMessage.START_GAME.getOutput());
    }

    private void printSizeMessage(){
        System.out.println(GameMessage.GET_SIZE.getOutput());
    }

    private void printGetMoveMessage(){
        System.out.println(GameMessage.GET_DIRECTION.getOutput());
    }

    private void printGetRestartMessage(){
        System.out.println(GameMessage.GET_RESTART.getOutput());
    }

    private String getInput(){
        return Console.readLine();
    }
}
