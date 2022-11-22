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

    public static void gameStart(){
        OV.startGuidance();
        InputView IV = new InputView();
        BridgeNumberGenerator BNG = new BridgeRandomNumberGenerator();
        BridgeMaker BM = new BridgeMaker(BNG);
        List<String> bridge = BM.makeBridge(IV.readBridgeSize());
        BridgeGame BG = new BridgeGame();
        bridge_Length = bridge.size();

        BG.retry(bridge, OV, IV, BNG, BM, BG);
        result(OV);
    }

    public static void result(OutputView OV){
        OV.printResult();
        OV.resultGuidance();
    }

    public static void repeatMoving(int num, List<String> bridge, InputView IV, BridgeGame BG){
        OV = new OutputView();
        List<String> result = new ArrayList<>();

        while(move_Status && num < bridge.size()) {
            OV.moveGuidance();
            String currentMoving = IV.readMoving();
            List<String> movement = BG.move(bridge.get(num), currentMoving);
            addElement(movement.get(0), movement.get(1), result);
            OV.printMap(result, num);
            num++;
        }
        final_Map_Number = --num;
    }
    public static void restart(OutputView OV, InputView IV, BridgeGame BG, List<String> bridge, BridgeNumberGenerator BNG, BridgeMaker BM){
        if(!move_Status){
            OV.restartGuidance();
            String gameCommand = IV.readGameCommand();
            if(gameCommand.equals("R")) BG.retry(bridge, OV, IV, BNG, BM, BG);
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
