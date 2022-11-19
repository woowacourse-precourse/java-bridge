package bridge;

import dto.BridgeDto;
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
            BridgeGame bridgeGame = new BridgeGame();
            int bridgeSize = inputView.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
            BridgeDto bridgeDto = bridge.sendDto();
            Result totalResult = new Result();

            boolean guessResult = true;
            for (int currentPosition = 0; currentPosition < bridgeSize && guessResult; currentPosition++) {
                outputView.printEnterMove();
                String direction = inputView.readMoving();
                bridgeGame.move(direction);
                BridgeGameDto bridgeGameDto = bridgeGame.sendDto();
                guessResult = bridge.isCorrectGuess(bridgeGameDto);
                totalResult.update(guessResult);
                outputView.printMap(bridgeDto,totalResult.sendDto());
            }

            if (!guessResult) {
                bridgeGame.initializeValues();
                totalResult = new Result();
                bridgeGame.retry();
                outputView.printRestart();
                String command = inputView.readGameCommand();
                if(command=="R") {
                    //재시작
                }
            }

            outputView.printResult(bridgeDto,totalResult.sendDto());
            BridgeGameDto bridgeGameDto = bridgeGame.sendDto();
            outputView.printReport(guessResult,bridgeGameDto.totalTrial);

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }
}
