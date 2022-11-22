package bridge;


/**
 * 다리 건너기 게임 컨트롤러
 */
public class BridgeController {

    private static final String MESSAGE_GAME_START = "다리 건너기 게임을 시작합니다.\n";

    private BridgeGame game;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    /**
     * 게임 시작 메서드
     */
    public void start() {
        outputView.printMessage(MESSAGE_GAME_START);
        initGame();
        while (true) {
            if (tryRound()) {
                outputView.printResult(game, "성공", game.getRound());
                break;
            }
            if (!getRestart()) {
                outputView.printResult(game, "실패", game.getRound());
                break;
            }
        }
    }

    /**
     * 게임 초기화 메서드
     */
    private void initGame() {
        try {
            game = new BridgeGame(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            initGame();
        }
    }

    /**
     * 라운드 실행 메서드
     */
    private boolean tryRound() {
        while (true) {
            if (game.isSuccess()) {
                return true;
            }
            moveUser();
            if (!game.isRightMove()) {
                return false;
            }
        }
    }

    /**
     * 사용자 이동 메서드
     */
    private void moveUser() {
        try {
            game.move(inputView.readMoving());
            outputView.printMap(game.getBridge(), game.getMovingUser());
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            moveUser();
        }
    }

    /**
     * 사용자 재시도 여부 메서드
     */
    private boolean getRestart() {
        try {
            String gameCommand = inputView.readGameCommand();
            if (gameCommand.equals("R")) {
                game.retry();
            }
            return gameCommand.equals("R");
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            getRestart();
            return false;
        }
    }
}