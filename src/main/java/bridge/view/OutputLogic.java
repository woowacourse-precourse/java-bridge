package bridge.view;

import bridge.model.Bridge;
import bridge.model.User;

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
    private Bridge bridge;
    private User user;
    OutputLogic(Bridge bridge,User user){
        this.bridge = bridge;
        this.user = user;
    }
    private void print(String string){
        System.out.print(string);
    }
    public void printMapLogic(String side){
        print(START);
        for(int position = 0; position< user.getPosition()-1;position++){
            printGlass(position,side,NOT_LAST);
            print(WALL);
        }
        printGlass(user.getPosition(),side,LAST);
        print(END);
    }
    private void printGlass(int position,String side,Boolean last){
        outPut = CORRECT;
        if(last&!user.getResult()) outPut = WRONG;
        if(bridge.getBridgeListIndex(position).equals(side)) {
            print(outPut);
            return;
        }
        print(SPACE);
    }
}
