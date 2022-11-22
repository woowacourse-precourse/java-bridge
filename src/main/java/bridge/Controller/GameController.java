package bridge.Controller;

import bridge.DTO.GameResultDTO;
import bridge.DTO.MoveCommandDTO;
import bridge.Domain.*;
import bridge.View.InputView;
import bridge.View.OutputView;
import bridge.Domain.RestartOrStop;

import java.util.List;
import java.util.Objects;

public class GameController {
    private final BridgeMaker bridgeMaker;
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private BridgeGame bridgeGame;

    public GameController(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }


    public void run(){
        outputView.printGameStart();
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        Answer answer = new Answer(bridge);
        bridgeGame = new BridgeGame(answer);
        User user = game(new User());
        printGameResult(user);
    }

    private User game(User user){
        while(continuePlaying()){
            userMove(user);
            checkRetry(user);
        }
        return user;
    }

    private void userMove(User user){
        String inputMoving = inputView.readMoving();
        MoveCommandDTO moveCommandDTO = gamePlay(user,inputMoving);
        outputView.printMap(moveCommandDTO);
    }

    private void printGameResult(User user){
        GameResultDTO gameResultDTO = gameOver(user);
        outputView.printResult(gameResultDTO);
    }

    public MoveCommandDTO gamePlay(User user, String inputMoving){
        if(!continuePlaying()){
            throw new IllegalArgumentException("[ERROR] 게임을 진행할 수 없습니다.");
        }
        user.userMove(bridgeGame, DirectionCommand.of(inputMoving));
        return new MoveCommandDTO(user.getUserGameResult());
    }

    public void restart(User user, String inputCommand){
        if(notMakeBridge() || stopGamePlay(inputCommand)){
            return;
        }
        user.userReset();
        bridgeGame.retry();
    }

    private boolean notMakeBridge(){
        return Objects.isNull(bridgeGame);
    }

    public GameResultDTO gameOver(User user){
        MoveCommandDTO moveCommandDTO = new MoveCommandDTO(user.getUserGameResult());
        return new GameResultDTO(user.checkUserProgress(),moveCommandDTO,user.getUserGameRound());
    }

    private boolean checkGameOver(User user){
        FinalGameResult finalGameResult = user.checkUserProgress();
        return !continuePlaying() && finalGameResult.successResult();
    }

    public void checkRetry(User user){
        if(checkGameOver(user) || continuePlaying()){
            return;
        }
        String command = inputView.readGameCommand();
        restart(user, command);
    }

    private boolean stopGamePlay(String inputMoving){
        RestartOrStop restartOrStop = RestartOrStop.of(inputMoving);
        return restartOrStop.stopUserGame();
    }

    public boolean continuePlaying(){
        if(notMakeBridge()){
            return false;
        }
        return bridgeGame.continueGame();
    }

}
