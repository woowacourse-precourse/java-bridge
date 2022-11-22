package bridge.view;


import java.util.List;

public class OutputLogic {
    private final String START = "[";
    private final String END = "]";
    private final String WALL = "|";
    private final String CORRECT = " O ";
    private final String SPACE = "   ";
    private final String WRONG = " X ";
    private String side;

    private String input;
    private String output = CORRECT;
    private List<String> bridgeList;
    OutputLogic(List<String> bridgeList){
        this.bridgeList = bridgeList;
    }
    private void print(String string){
        System.out.print(string);
    }
    public void printMapLogic(String side,int userPosition,Boolean userResult){
        this.side = side;
        print(START);
        printGlasses(userPosition);
        printLastGlass(userResult);
        print(END);
    }
    private void printGlasses(int userPosition){
        for(int position = 0; position< userPosition;position++){
            printGlass(position);
            print(WALL);
        }
    }
    private void printGlass(int position){
        if(bridgeList.get(position).equals(side)) {
            print(CORRECT);
            return;
        }
        print(SPACE);
    }
    private void printLastGlass(Boolean userResult){
        output = CORRECT;
        if(!userResult)output = WRONG;
        if(!input.equals(side)) {
            print(SPACE);
            return;
        }
        print(output);
    }
    public void setInput(String input){this.input = input;}
}
