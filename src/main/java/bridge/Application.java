package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {


    private static final BridgeMaker bridgeMaker = new BridgeMaker(null);
    private static final String BLANK = " ";
    public static void main(String[] args) {


        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();


        System.out.println("다리 건너기 게임을 시작합니다"); // Output
        System.out.println("다리의 길이를 입력해주세요."); // input 메세지

        int bridgeSize = InputView.inputBridgeSize(); // inputView에서 다리길이를 받는다.
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);


        List<String> bridgeResult = bridgeMaker.makeBridge(bridgeSize);
        int tryCount = 1;
        BridgeGame bridgeGame = new BridgeGame(bridgeResult, tryCount);
        System.out.println("다리 결과물 : " + bridgeResult);




        StringBuilder upSideResult = new StringBuilder("[");
        StringBuilder downSideResult = new StringBuilder("[");


        for (int i = 0; i < bridgeGame.size(); i++) {
            String moveWord = InputView.inputMoving();
            if (bridgeGame.matchMoving(i, moveWord) && moveWord.equals("U")) {
                upSideResult.insert(4*i+1, " ");
                upSideResult.insert(4*i+2, "O");
                upSideResult.insert(4*i+3, " ");
                downSideResult.insert(4*i+1, " ");
                downSideResult.insert(4*i+2, " ");
                downSideResult.insert(4*i+3, " ");
                if (i != bridgeGame.size() - 1) {
                    upSideResult.insert(4*i+4, "|");
                    downSideResult.insert(4*i+4, "|");
                }
                if (i == bridgeGame.size() - 1) {
                    upSideResult.insert(4*i+4, "]");
                    downSideResult.insert(4*i+4, "]");
                }
            }

            if (bridgeGame.matchMoving(i, moveWord) && moveWord.equals("D")) {
                upSideResult.insert(4*i+1, " ");
                upSideResult.insert(4*i+2, " ");
                upSideResult.insert(4*i+3, " ");
                downSideResult.insert(4*i+1, " ");
                downSideResult.insert(4*i+2, "O");
                downSideResult.insert(4*i+3, " ");
                if (bridgeGame.size() - 1 != i) {
                    upSideResult.insert(4*i+4, "|");
                    downSideResult.insert(4*i+4, "|");
                }
                if (bridgeGame.size() - 1 == i) {
                    upSideResult.insert(4*i+4, "]");
                    downSideResult.insert(4*i+4, "]");
                }
            }
            // 게임에서 졌을 떄
            if (!bridgeGame.matchMoving(i, moveWord) && moveWord.equals("U")) {
                upSideResult.insert(4*i+1, " ");
                upSideResult.insert(4*i+2, "X");
                upSideResult.insert(4*i+3, " ");
                upSideResult.insert(4*i+4, "]");
                downSideResult.insert(4*i+1, " ");
                downSideResult.insert(4*i+2, " ");
                downSideResult.insert(4*i+3, " ");
                downSideResult.insert(4*i+4, "]");
                bridgeGame.retry();
            }

            if (!bridgeGame.matchMoving(i, moveWord) && moveWord.equals("D")) {
                upSideResult.insert(4*i+1, " ");
                upSideResult.insert(4*i+2, " ");
                upSideResult.insert(4*i+3, " ");
                upSideResult.insert(4*i+4, "]");
                downSideResult.insert(4*i+1, " ");
                downSideResult.insert(4*i+2, "X");
                downSideResult.insert(4*i+3, " ");
                downSideResult.insert(4*i+4, "]");
                bridgeGame.retry();
                // 재시도 여부
            }
            OutputView.printMap(upSideResult, downSideResult);
        }
        OutputView.printResultMessage();
        OutputView.printMap(upSideResult, downSideResult);
        OutputView.printResult(tryCount, true);


    }
}
