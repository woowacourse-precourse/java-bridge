package bridge.serviceImpl;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.service.GameService;
import bridge.validation.BridgeSizeValidation;
import bridge.validation.MovingValidation;
import bridge.validation.RestartQuickValidation;

import java.util.List;

public class BridgeGame implements GameService {
    private static InputView inputView;
    private static OutputView outputView;
    private static int gameTry;
    private static int count;

    public BridgeGame(){
        inputView = buildInputView();
        outputView = new OutputView();
        gameTry = 1;
        count = 0;
    }

    @Override
    public void startGame(){
        println("다리 건너기 게임을 시작합니다." + System.lineSeparator());
        println("다리의 길이를 입력해주세요.");
        int size = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);

        int count = doGame(bridge);

        boolean isSuccess = (count == size);
        outputView.printResult(isSuccess, gameTry);
    }

    private int doGame(List<String> bridge){
        int bridgeSize =  bridge.size();

        while (count < bridgeSize) {
            println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String inputMove = inputView.readMoving();

            boolean moving = move(count, inputMove, bridge);
            count++;

            if(!isRestart(moving)){
                break;
            }
        }
        return count;
    }

    private boolean isRestart(boolean moving){
        if(!moving) {
            println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String restartOrQuick = inputView.readGameCommand();
            if(!retry(restartOrQuick)){
                return false;
            }
            count = 0;
            gameTry++;
        }
        return true;
    }

    public boolean move(int count, String inputMove, List<String> bridge) {
        outputView.printMap(count, inputMove, bridge);
        if(bridge.get(count).equals(inputMove)){
            return true;
        }
        return false;
    }

    public boolean retry(String restartOrQuick) {
        return restartOrQuick.equals("R");
    }

    private static void println(String message) {
        System.out.print(message + System.lineSeparator());
    }

    private static InputView buildInputView() {
        InputView inputView = new InputView();
        inputView.builder()
                .setBridgeValidation(new BridgeSizeValidation())
                .setMovingValidation(new MovingValidation())
                .setRestartQuickValidation(new RestartQuickValidation())
                .build();
        return inputView;
    }
}
