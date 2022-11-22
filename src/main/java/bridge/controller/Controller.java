package bridge.controller;

import bridge.dto.BridgeMapDto;
import bridge.dto.PrintResultDto;
import bridge.dto.RetryCountDto;
import bridge.model.value.OutMessage;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.model.value.OutMessage.*;
public class Controller {
    private final BridgeGame game;
    private final OutputView out;
    private final InputView input;
    public Controller(BridgeGame game, OutputView out, InputView input){
        this.game = game;
        this.out = out;
        this.input = input;
    }

    public void startGame() { //다리 게임 시작
        out.printMessage(START_MESSAGE);
        createBridge(); //다리 생성
        while(game.keepGoingGame()) { //사용자 문자가 "R"인가?
            moveAndResult();
        }
        printResult(game.getPrintResultDto());
    }

    private void moveAndResult() {
        moveBridge();   // 움직이기
        printState();   // 입력값 결과 출력
        if(!game.checkResult()){    // 정답 여부 맞았나 틀렸나
            retry();
        }
        else if(game.isEnd()){  // 끝까지 도달했나 안했나
            success();
        }
    }


    public void createBridge() {
        try {
            out.printMessage(INPUT_BRIDGE_MESSAGE);
            createGameField();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            createBridge();
        }
    }

    private void createGameField() {
        game.createBridge(input.readBridgeSize());
        game.createBridgeMap();
        game.createPlayer();
        game.createCount();
    }

    public void moveBridge() {
        try {
            out.printMessage(INPUT_MOVE_MESSAGE);
            game.move(input.readMoving());
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            moveBridge();
        }
    }

    public void printState() {
        out.printMap(BridgeMapDto.of(game.getBridgeMap()));
    }

    public void retry() {
        try {
            out.printMessage(INPUT_RETRY_MESSAGE);
            game.retry(input.readGameCommand());
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            retry();
        }

    }
    public void success() {
        game.success();
    }
    public void printResult(PrintResultDto dto) {
        out.printMessage(PRINT_RESULT_MESSAGE);
        out.printMap(dto.getMapDto());
        out.printSuccessOrNot(dto.getState());
        out.printTryCount(dto.getRetryCountDto());
    }
}
