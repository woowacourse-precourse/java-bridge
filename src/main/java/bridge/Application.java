package bridge;

import java.util.ArrayList;
import java.util.List;

// import static bridge.OutputView.*;

public class Application {

    static boolean move_Status = true;
    static int final_Map_Number = 1;
    static int bridge_Length = 0;
    static int trial_Number = 0;
    static OutputView OV = new OutputView();
    static InputView IV = new InputView();
    static BridgeNumberGenerator BNG = new BridgeRandomNumberGenerator();
    static BridgeMaker BM = new BridgeMaker(BNG);
    static BridgeGame BG = new BridgeGame();

    public static void gameStart(){
        OV.startGuidance();
        List<String> bridge = BM.makeBridge(IV.readBridgeSize());
        bridge_Length = bridge.size();

        BG.retry(bridge);
        result(OV);
    }

    public static void result(OutputView OV){
        OV.printResult();
        OV.resultGuidance();
    }

    public static void repeatMoving(int num, List<String> bridge) {
        OV = new OutputView();
        List<String> result = new ArrayList<>();

        while(move_Status && num < bridge.size()) {
            OV.moveGuidance();
            String currentMoving = IV.readMoving();
            moving(result, num, bridge, currentMoving);
            OV.printMap(result, num);
            num++;
        }
        final_Map_Number = --num;
    }

    public static void moving(List<String> result, int num, List<String> bridge, String currentMoving){
        List<String> movement;
        movement = BG.move(bridge.get(num), currentMoving);
        addElement(movement.get(0), movement.get(1), result);
    }

    public static void restart(List<String> bridge){
        if(!move_Status){
            OV.restartGuidance();
            String gameCommand = IV.readGameCommand();
            if(gameCommand.equals("R")) BG.retry(bridge);
        }
    }

    private static List<String> addElement(String element_1, String element_2, List<String> object){
        object.add(element_1);
        object.add(element_2);
        return object;
    }

    public static void main(String[] args) {
        gameStart();
    }
}
