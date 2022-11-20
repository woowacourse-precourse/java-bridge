package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class Application {
    public static Information instruction_on_bridge(BridgeGame game, int BridgeSize, List<String> bridge, Information info){
        int index = 0;
        Boolean retry = Boolean.TRUE;
        while(index < BridgeSize && retry == Boolean.TRUE){
            BridgeGame.Information Game_inf = game.move(index, bridge);
            info.index = index; info.retry = Game_inf.retry; info.instruction = Game_inf.instruction;
            index += 1; retry = Game_inf.retry;
            if (retry == Boolean.FALSE){game.retry();}}
        return info;
    }

    public static class Information {
        int index = 0;
        Boolean retry = Boolean.TRUE;
        String instruction;
        public Information(int index, Boolean retry, String instruction){
            this.index = index;
            this.retry = retry;
            this.instruction = instruction;
        }
    }



    public static void main(String[] args) {

        InputView input = new InputView();
        int BridgeSize = 0;
        while (BridgeSize == 0){
            BridgeSize = input.readBridgeSize();
        }

        BridgeNumberGenerator rn = new BridgeRandomNumberGenerator();
        BridgeMaker answer_bridge = new BridgeMaker(rn);
        List<String> new_bridge = answer_bridge.makeBridge(BridgeSize);

        // 게임 시작
        // while 문에는 틀리면 다시 시작할 것인지 물어봄
        Boolean retry = Boolean.TRUE;
        BridgeGame game = new BridgeGame();
        Information info = new Information(0,Boolean.TRUE,"-");
        while (retry){
            info = instruction_on_bridge(game, BridgeSize, new_bridge, info);
            if (retry == Boolean.FALSE){
                // 다시 할 것인지 정해야 함
            }
        }



        // TODO: 프로그램 구현
    }
}
