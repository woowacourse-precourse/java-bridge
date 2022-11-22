package bridge.controller;

import bridge.dto.BridgeMapDto;
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
    /*
1. startGame()
2. createBridge()
3. moveBridge()
4. printState()
5. retry()
6.success()
7. printResult()
     */
    public void startGame() { //다리 게임 시작
        out.printMessage(START_MESSAGE);
        createBridge(); //다리 생성
        while(game.keepGoingGame()) { //사용자 문자가 "R"인가?
            moveBridge();   // 움직이기
            printState();   // 입력값 결과 출력
            if(!game.checkResult()){    // 정답 여부 맞았나 틀렸나
                retry();
            }
            else if(game.isEnd()){  // 끝까지 도달했나 안했나 // TODO: 리펙토링 예정
                success();
            }
        }
        printResult(game.success(), BridgeMapDto.of(game.getBridgeMap()), RetryCountDto.of(game.getRetryCount()));
        // TODO: Refactoring 해줄것 Dto클래스로 만들어 전달할 것
    }


    public void createBridge() {
        try {
            out.printMessage(INPUT_BRIDGE_MESSAGE);
            game.createBridge(input.readBridgeSize());
            game.createBridgeMap();
            game.createPlayer();
            game.createCount();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            createBridge();
        }
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

    public void printState() { // TODO: Refactoring Service 계층에서 변환하여 전달해주자
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
    public void printResult(String State, BridgeMapDto mapDto, RetryCountDto retryCountDto) {// TODO: 변경 예정
        out.printMessage(PRINT_RESULT_MESSAGE);
        out.printMap(mapDto);
        out.printSuccessOrNot(State);
        out.printTryCount(retryCountDto.getRetryCount());

    }

}
