package bridge.view;


import static bridge.enums.Message.COMMAND;
import static bridge.enums.Message.MOVE;
import static bridge.enums.Message.SIZE;
import static bridge.enums.Message.START;

public class OutputView {
    public void printStartMessage(){
        System.out.println(START.OF());
    }
    public void printSizeMessage(){
        System.out.println(SIZE.OF());
    }
    public void printMoveMessage(){
        System.out.println(MOVE.OF());
    }
    public void printCommandMessage(){
        System.out.println(COMMAND.OF());
    }
    public void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    }


    public void printResult(String result) {
        System.out.println(result);
    }
    public void printMap(String map) {
        System.out.println(map);
    }

}
