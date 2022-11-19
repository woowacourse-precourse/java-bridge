package bridge;

import dto.BridgeGameDto;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printStart();
        outputView.printEnterBridgeSize();
        try {
            int bridgeSize = inputView.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
            Result totalResult = new Result();

            boolean guessResult = true;
            for (int currentPosition = 0; currentPosition < bridgeSize && guessResult; currentPosition++) {
                BridgeGame bridgeGame = new BridgeGame();
                outputView.printEnterMove();
                String direction = inputView.readMoving();
                bridgeGame.move(direction);
                BridgeGameDto bridgeGameDto = bridgeGame.sendDto();
                guessResult = bridge.isCorrectGuess(bridgeGameDto);
                totalResult.update(guessResult);
                //현재까지의 결과 출력
            }

            /*
            if (!guessResult) {
                현 위치 초기화, totalResult 초기화
                재시작 여부 결정
            }
            최종 결과 출력
            게임 종료
            */

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }
}
