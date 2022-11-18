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
    private String outPut;
    private List<String> bridgeList;
    private boolean userResult;
    OutputLogic(List<String> bridgeList,boolean userResult){
        this.bridgeList = bridgeList;
        this.userResult = userResult;
    }
    private void print(String string){
        System.out.print(string);
    }
    public void printMapLogic(String side,int userPosition){
        print(START);
        for(int position = 0; position< userPosition;position++){
            printGlass(position,side);
            print(WALL);
        }
        printLastGlass(userPosition,side);
        print(END);
    }
    private void printGlass(int position,String side){
        if(bridgeList.get(position).equals(side)) {
            print(CORRECT);
            return;
        }
        print(SPACE);
    }
    private void printLastGlass(int position, String side){
        if(!bridgeList.get(position).equals(side)) {
            print(SPACE);
            return;
        }
        if(userResult){
            print(CORRECT);
            return;
        }
        if(!userResult){
            print(WRONG);
        }
    }
}
