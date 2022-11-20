package bridge;

public class Application {

    public static void main(String[] args) {

        InputView userInput = new InputView();
        OutputView guideDocument = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        guideDocument.printStartDocs();
        guideDocument.printRequestBridgeLengthDocs();

        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(userInput.readBridgeSize()));

        guideDocument.printRequestSelectDocs();
        bridgeGame.move(userInput.readMoving());

        }
    }
