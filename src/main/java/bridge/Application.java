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
            index += 1; retry = Game_inf.retry;}
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
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
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
        BridgeGame game = new BridgeGame();
        Information info = new Information(0,Boolean.TRUE,"-");
        int trial = 1;
        Boolean win = Boolean.TRUE;
        while (Boolean.TRUE){
            info = instruction_on_bridge(game, BridgeSize, new_bridge, info);
            if (info.index == BridgeSize-1){
                win = info.retry;
                break;}
            String retry = game.retry();
            if (retry.equals("quit")){
                win = Boolean.FALSE;
                break;}
            trial += 1;}
        OutputView output = new OutputView();
        output.printResult(info.index, info.instruction, new_bridge, win, trial);

        // 여기서부터 끝맺음

        // TODO: 프로그램 구현
    }
}
