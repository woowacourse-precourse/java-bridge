package bridge.ui;


import bridge.model.ErrorMessage;
import bridge.model.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void startGame(){
        printStartMessage();
        System.out.println();
    }
    public int readBridgeSize() {
        printSizeMessage();
        String input = getInput();
        int size = getSizeInteger(input);
        isValidRange(size);
        return size;
    }

    public String readMoving() {
        printGetMoveMessage();
        return getInput();
    }

    public String readGameCommand() {
        printGetRestartMessage();
        return getInput();
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

    private int getSizeInteger(String size){
        try{
            return Integer.parseInt(size);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_VALUE.getOutput());
        }
    }

    private void isValidRange(int size){
        if(size < 3 || size > 20){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_VALUE.getOutput());
        }
    }
}
