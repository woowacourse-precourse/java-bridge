package bridge;

import bridge.controller.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.controller.BridgeGame.gameCount;

public class Application {
    public static final InputView inputview = new InputView();
    public static final OutputView outputview = new OutputView();

    public static final BridgeGame bridgeGame = new BridgeGame();
    public static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    public static List<String> bridge;
    private static String result;
    private static List<String> upList;
    private static List<String> downList;
    private static int index;
    public static void main(String[] args) throws Exception {
        try { // TODO: 프로그램 구현

            bridge = bridgeMaker.makeBridge(inputview.readBridgeSize());
            playGame();
            showResult();
            outputview.printResult(result, gameCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    private static void playGame() {
        String ans = inputview.readMoving();
        String next = bridgeGame.move(bridge, ans, index);

        if(next.equals("F")){
           upList = outputview.falseUpList(ans,index);
           downList = outputview.falseDownList(ans,index);
           outputview.printMap(upList,downList);
           showResult();
        }

        upList = outputview.rightUpList(index);
        downList = outputview.rightDownList(index);
        outputview.printMap(upList,downList);
        index++;
        playGame();
        }


    private static void showResult() {
        String goOn = bridgeGame.restartGame(bridge, index);
        if (goOn.equals("GOON")) {
            playGame();
        }
        if (goOn.equals("FAIL")) {
            String endGame = bridgeGame.retry(inputview.readGameCommand());
            if (endGame.equals("R")) {
                index = 0;
                outputview.restart();
                playGame();
            }
            result = "실패";
        }
        if (goOn.equals("SUCCESS")) {
            result = "성공";
        }
    }

}
