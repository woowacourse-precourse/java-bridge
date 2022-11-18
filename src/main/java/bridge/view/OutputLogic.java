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
        for(int position = 0; position< user.getPosition();position++){
            printGlass(position,side);
            print(WALL);
        }
        printLastGlass(user.getPosition(),side);
        print(END);
    }
    private void printGlass(int position,String side){
        if(bridge.getBridgeListIndex(position).equals(side)) {
            print(CORRECT);
            return;
        }
        print(SPACE);
    }
    private void printLastGlass(int position, String side){
        if(!bridge.getBridgeListIndex(position).equals(side)) {
            print(SPACE);
            return;
        }
        if(user.getResult()){
            print(CORRECT);
            return;
        }
        if(!user.getResult()){
            print(WRONG);
        }
    }
}
