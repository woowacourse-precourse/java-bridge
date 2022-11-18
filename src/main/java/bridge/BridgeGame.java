package bridge;

import bridge.domain.Game;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private List<String> bridge;

    private Game game;
    private Repository repository;

    public BridgeGame() {
        repository = new Repository();
        outputView = new OutputView();
        inputView = new InputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    private void createBridge() {
        try {
            outputView.printBridgeSize();
            int size = inputView.readBridgeSize();
            bridge = bridgeMaker.makeBridge(size);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            createBridge();
        }
    }

    public void play() {
        outputView.printStart();
        createBridge();
        do {
            newGame();
            move();
            repository.save(game);
        } while(endCheck());
        outputView.printResult(repository.getResult(), repository.getTimes());
    }
    private boolean endCheck(){
        repository.save(game);
        if (game.getSuccess().equals("실패") && retry().equals("R")){
            return true;
        }
        return false;
    }
    private void newGame() {
        game = new Game();
        repository.setTimes(repository.getTimes()+1);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void move() {
        while (true){
            int location = game.getLocation();
            if (checkGame(game, bridge.size())) break;
            moveChoice(location);
            game.forward();
        }
    }

    public boolean checkGame(Game game,int size) {
        if (game.getLocation() == size){
            game.setSuccess("성공");
            return true;
        }
        if (game.getLocation()>0 &&game.getCurrentAnswer().equals("X")) {
            return true;
        }
        return false;
    }

    private void moveChoice(int location) {
        try {
            outputView.printMove();
            String direction = inputView.readMoving();
            String match = match(direction, bridge.get(location));
            game.write(direction, match);
            outputView.printMap(game);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            moveChoice(location);
        }
    }

    public String match(String user, String answer) {
        if (!user.equals(answer)) return "X";
        return "O";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry() {
        String command ="";
        try {
            outputView.printGame();
            command = inputView.readGameCommand();
        } catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            retry();
        }
        return command;
    }
}
