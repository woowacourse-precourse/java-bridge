package bridge.view;

import bridge.controller.BridgeGame;
import bridge.exception.inputError;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private final String LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private BridgeGame bridgeGame = new BridgeGame();
    private boolean allCorrect = false;

    public void readBridgeSize() {
        System.out.println(START_MESSAGE);
        System.out.println(LENGTH_MESSAGE);
        int size = verificationSize(Console.readLine());
        System.out.println();
        bridgeGame.startGame(size);
    }


    public boolean readMoving() {
        System.out.println(MOVE_MESSAGE);
        String moving = Console.readLine();
        verificationMove(moving);
        bridgeGame.move(moving);
        bridgeGame.setMatch();
        return bridgeGame.getMatchCorrect();
    }


    public boolean readGameCommand() {
        System.out.println(RETRY_MESSAGE);
        String command = Console.readLine();
        verificationCommand(command);
        if (command.equals("Q")) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }

    public boolean checkAllCorrect() {
        return bridgeGame.checkAllCorrect();
    }

    private void verificationCommand(String command){
        if (!command.equals("R") && !command.equals("Q")){
            System.out.println("[ERROR]");
            throw new IllegalArgumentException(inputError.RESTART.getMessage());

        }
    }

    private void verificationMove(String moving){
        if (!moving.equals("U") && !moving.equals("D")){
            System.out.println("[ERROR]");
            throw new IllegalArgumentException(inputError.INPUT_UP_DOWN.getMessage());
        }
    }
    private Integer verificationSize(String size){
        verificationToNumber(size);
        int returnSize = Integer.parseInt(size);

        if(returnSize < 3 || 20 < returnSize) {
            System.out.println("[ERROR]");
            throw new IllegalArgumentException(inputError.NUMBER_RANGE.getMessage());
        }
        return returnSize;
    }

    private void verificationToNumber(String size){
        try{
            Integer.parseInt(size);
        } catch (NumberFormatException numberFormatException){
            System.out.println("[ERROR]");
            throw new IllegalArgumentException(inputError.IS_NUMBER.getMessage());

        }
    }
}
