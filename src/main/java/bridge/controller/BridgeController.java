package bridge.controller;

import bridge.BridgeMakerInf;
import bridge.domain.Bridge;
import bridge.dto.BridgeMove.Request;
import bridge.dto.BridgeMove.Response;
import bridge.dto.PrintMapDto;
import bridge.dto.PrintResultDto;
import bridge.service.BridgeGameInf;
import bridge.type.BridgeSpaceStatus;
import bridge.util.InputContext;
import bridge.validation.InputValidationChain;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeMakerInf bridgeMaker;
    private final BridgeGameInf bridgeGame;
    private final InputValidationChain validator;
    private final InputContext inputContext;

    public BridgeController(BridgeMakerInf bridgeMaker, BridgeGameInf bridgeGame,
        InputValidationChain validator, InputContext inputContext) {
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
        this.validator = validator;
        this.inputContext = inputContext;
    }

    public void play() {
        OutputView.printStart();
        final Bridge bridge = makeBridge();
        Response response = crossBridge(bridge);
        printResult(bridge, response);
    }

    private void printResult(final Bridge bridge, final Response response) {
        OutputView.printResult(new PrintResultDto(bridge.getSequence(), response.isSuccess(),
            response.getAttemptCount(), response.getIndex()));
    }

    private Response crossBridge(final Bridge bridge) {
        Response initResponse = new Response(false, false, 1, 0);
        return getCrossBridgeResult(bridge, initResponse);
    }

    private Response getCrossBridgeResult(final Bridge bridge, Response response) {
        while (true) {
            Request request = new Request(response.getIndex(), response.getAttemptCount(), getMove());
            response = getAndPrintResponse(bridge, request);
            if (response.isSuccess() || (!response.isPossible() && !getGameCommand())) {
                break;
            }
            response = retryCheck(response, request);
        }
        return response;
    }

    private Response getAndPrintResponse(final Bridge bridge, final Request request) {
        Response response = bridgeGame.move(request, bridge);
        OutputView.printMap(new PrintMapDto(bridge.getSequence(), response.isPossible(), request.getIndex()));
        return response;
    }

    private Response retryCheck(Response response, final Request request) {
        if (!response.isPossible()) {
            response = bridgeGame.retry(request);
        }
        return response;
    }

    private Bridge makeBridge() {
        final int size = getSize();
        return new Bridge(bridgeMaker.makeBridge(size));
    }


    private Integer getSize() {
        return inputContext.workWithInputStrategy(validator, InputView::readBridgeSize);
    }

    private BridgeSpaceStatus getMove() {
        return inputContext.workWithInputStrategy(validator, InputView::readMoving);
    }

    private Boolean getGameCommand() {
        return inputContext.workWithInputStrategy(validator, InputView::readGameCommand);
    }
}
