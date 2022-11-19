package bridge;

import java.util.List;

public class Application {
    static OutputView output = new OutputView();
    InputView input = new InputView();
    CheckError check = new CheckError();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridge = new BridgeGame();

        output.printStart();
        bridge.start();
    }

    public int firstStep(){
        output.printFirst();
        int size;
        try {
            size = input.readBridgeSize();
            check.checkBridgeSize(size);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return firstStep();
        }
        return size;
    }
    public String secondStep(){
        String input_temp = "";
        output.printSecond();
        try {
            input_temp = input.readMoving();
            check.checkChoice(input_temp);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return secondStep();
        }
        return input_temp;
    }
    public String thirdStep(){
        String input_temp = "";
        output.printRetry();
        try {
            input_temp = input.readGameCommand();
            check.checkRetry(input_temp);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return thirdStep();
        }
        return input_temp;
    }

    public String[] printMap(List<String> bridge_input, String choice, boolean same){
        return output.printMap(bridge_input, choice, same);
    }
    public void printResult(String[] Bridge_out,boolean result,int count){
        output.printResult(Bridge_out,result,count);
    }

}
