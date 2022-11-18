package bridge.view;

import bridge.model.Bridge;
import bridge.model.User;

import java.util.List;

public class OutputLogic {
    private static final String START = "[";
    private static final String END = "]";
    private static final String WALL = "|";
    private static final String CORRECT = " O ";
    private static final String SPACE = "   ";
    private static final String WRONG = " X ";
    private static final Boolean LAST = Boolean.TRUE;
    private static final Boolean NOT_LAST = Boolean.FALSE;
    private String outPut = CORRECT;
    private List<String> bridgeList;
    OutputLogic(List<String> bridgeList){
        this.bridgeList = bridgeList;
    }
    private void print(String string){
        System.out.print(string);
    }
    public void printMapLogic(String side,int userPosition,Boolean userResult){
        print(START);
        for(int position = 0; position< userPosition;position++){
            printGlass(position,side);
            print(WALL);
        }
        printLastGlass(userPosition,side,userResult);
        print(END);
    }
    private void printGlass(int position,String side){
        if(bridgeList.get(position).equals(side)) {
            print(CORRECT);
            return;
        }
        print(SPACE);
    }
    private void printLastGlass(int position, String side,Boolean userResult){
        if(!userResult){outPut = WRONG;}
        if(bridgeList.get(position).equals(side)) {
            print(outPut);
            return;
        }
        print(SPACE);
    }
}
