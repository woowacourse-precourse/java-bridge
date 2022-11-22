package bridge;

import data.BridgeData;
import data.ExceptionData;
import view.InputView;

/**
 * Inputview를 관리하는 클래스.
 * <p>
 * 입력 예외도 여기에서 처리함.
 */
public class InputParser {
    private InputView inputView = new InputView();

    /**
     * 다리길이를 받아서 예외를 검출하고 BridgeGame에 전달.
     * @return 다리 길이
     */
    public int getBridgeSize(){
        int bridgeSize;
        while(true) {
            try{
                bridgeSize = Integer.parseInt(inputView.readBridgeSize());
                return validateSize(bridgeSize);
            }catch(IllegalArgumentException e ){
                ExceptionData.EXCEPTION_SIZE.printExceptionData();
            }
        }
    }

    /**
     * 어디로 움직일지 입력받음
     * @return U면 위, D면 아래.
     */
    public String getMoveCommand(){
        String moveCommand;
        while(true) {
            try{
                moveCommand = inputView.readMoving();
                return validateMove(moveCommand);
            }catch(IllegalArgumentException e){
                ExceptionData.EXCEPTION_MOVE.printExceptionData();
            }
        }
    }

    /**
     * 게임을 재시작할지 입력.
     * @return R이면 재시작, Q면 결과 출력.
     */
    public String getGameCommand(){
        String gameCommand;
        while(true) {
            try{
                gameCommand = inputView.readGameCommand();
                return validateGameCommand(gameCommand);
            }catch(IllegalArgumentException e){
                ExceptionData.EXCEPTION_RESTART.printExceptionData();
            }
        }
    }


    /**
     * 다리 길이 예외 검출
     * @param bridgeSize 입력받은 문자열
     * @return 3이상 20 이하의 정수
     * @throws IllegalArgumentException 3보다 작거나 20보다 클 경우
     */
    private int validateSize(int bridgeSize) throws IllegalArgumentException{
        if(bridgeSize < BridgeData.MINIMUM_LENGTH || bridgeSize > BridgeData.MAXIMUM_LENGTH){
            throw new IllegalArgumentException();
        }
        return bridgeSize;
    }


    /**
     * 다리 선택 예외 검출
     * @param moveCommand 입력받은 문자열
     * @return 문자열 "U", 또는 "D"
     * @throws IllegalArgumentException U나 D가 아닐 경우
     */
    private String validateMove(String moveCommand) throws IllegalArgumentException {
        try {
            if (!moveCommand.equals(BridgeData.UP) && !moveCommand.equals(BridgeData.DOWN)) {
                throw new IllegalArgumentException();
            }
            return moveCommand;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 재시작 여부 예외 검출
     * @param gameCommand 입력받은 문자열
     * @return 문자열 "R", 또는 "Q"
     * @throws IllegalArgumentException R이나 Q가 아닐 경우
     */
    private String validateGameCommand(String gameCommand) throws IllegalArgumentException {
        try {
            if (!gameCommand.equals(BridgeData.RESTART) && !gameCommand.equals(BridgeData.QUIT)) {
                throw new IllegalArgumentException();
            }
            return gameCommand;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

}
