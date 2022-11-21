package bridge;

import java.util.List;

public class Application {

    public static class Information {
        int index;
        Boolean retry;
        String instruction;
        int trial;

        public Information(int index, Boolean retry, String instruction){
            this.index = index;
            this.retry = retry;
            this.instruction = instruction;
        }
    }

    public static String input_instruction(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String instruction = "back";
        while (instruction.equals("back")) {instruction = new InputView().readMoving();}
        return instruction;
    }

    public static String input_restart(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String instruction = "back";
        while (instruction.equals("back")) {instruction = new InputView().readGameCommand();}
        return instruction;
    }

    public static void output_printmap(int index_bridge, List<String> bridge, String instruction){
        OutputView output = new OutputView();
        output.printMap(index_bridge, instruction, bridge);
    }

    public static Information instruction_on_bridge(BridgeGame game, int BridgeSize, List<String> bridge, Information info){
        int index = 0;
        Boolean retry = Boolean.TRUE;
        while(index < BridgeSize && retry == Boolean.TRUE){
            String instruction = input_instruction();
            BridgeGame.Information Game_inf = game.move(index, bridge, instruction);
            info.index = index; info.retry = Game_inf.retry; info.instruction = instruction;
            output_printmap(index, bridge, instruction);
            index += 1; retry = Game_inf.retry;
        }
        return info;
    }



    public static int BridgeSize_initial(int BridgeSize){
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        InputView input = new InputView();
        while (BridgeSize == 0){
            BridgeSize = input.readBridgeSize();}
        return BridgeSize;
    }

    public static List<String> BridgeGame_initial(int Bridgesize){
        BridgeNumberGenerator rn = new BridgeRandomNumberGenerator();
        BridgeMaker answer_bridge = new BridgeMaker(rn);
        List<String> new_bridge = answer_bridge.makeBridge(Bridgesize);
        return new_bridge;
    }

    public static Information game_result(BridgeGame game, int BridgeSize, List<String> new_bridge, Information info){
        while (info.retry) {
            info = instruction_on_bridge(game, BridgeSize, new_bridge, info);
            if (info.index == BridgeSize - 1 && info.retry == Boolean.TRUE) {
                break;}
            String retry = input_restart();
            retry = game.retry(retry);
            if (retry.equals("quit")) {
                info.retry = Boolean.FALSE;
                break;}
            info.retry = Boolean.TRUE; info.trial += 1;}
        return info;
    }


    public static void main(String[] args) {
        int BridgeSize = BridgeSize_initial(0);
        List<String> new_bridge = BridgeGame_initial(BridgeSize);
        BridgeGame game = new BridgeGame();
        Information info = new Information(0,Boolean.TRUE,"-");
        info.trial = 1;

        info = game_result(game, BridgeSize, new_bridge, info);
        OutputView output = new OutputView();
        output.printResult(info.index, info.instruction, new_bridge, info.retry, info.trial);
    }
}
