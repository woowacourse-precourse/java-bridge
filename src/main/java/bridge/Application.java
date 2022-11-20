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

    public String[] beforeMap(List<String> bridge_input){
        String[] Bridge_out = new String[2];
        Bridge_out[0] = ""; Bridge_out[1] ="";
        for(int i = 0 ; i < bridge_input.size() - 1 ; i++){
            Bridge_out = addResult(Bridge_out,bridge_input.get(i));
            Bridge_out[0] += "|";
            Bridge_out[1] += "|";
        }
        return Bridge_out;
    }

    public String[] addResult(String[] Bridge_out , String choice){
        if(choice.equals("U")){
            Bridge_out[0] += " O ";
            Bridge_out[1] += "   ";
        } else if(choice.equals("D")){
            Bridge_out[0] += "   ";
            Bridge_out[1] += " O ";
        }
        return Bridge_out;
    }

    public String[] addNow(String[] Brdige_out, String choice ,boolean same){
        if(same == true){
            Brdige_out = add_OorX(Brdige_out,choice," O ");
        }else if(same == false){
            Brdige_out = add_OorX(Brdige_out,choice," X ");
        }
        return Brdige_out;
    }
    public String[] add_OorX(String[] Bridge_out,String choice, String OorX){
        if(choice.equals("U")){
            Bridge_out[0] += OorX;
            Bridge_out[1] += "   ";
        }else if(choice.equals("D")){
            Bridge_out[0] += "   ";
            Bridge_out[1] += OorX;
        }
        return Bridge_out;
    }

}
