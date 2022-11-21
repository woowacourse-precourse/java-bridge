package bridge.view;

import bridge.constant.BridgeConstant;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder firstLine,secondLine;
    public OutputView(){
        firstLine = new StringBuilder();
        secondLine = new StringBuilder();
    }
    private void addSignal(String Direction, String signal){
        if(Direction.equals(BridgeConstant.CAN_GO_UP.getString())){
            firstLine.append("| "+signal+" ");
            secondLine.append("|   ");
            return;
        }
        firstLine.append("|   ");
        secondLine.append("| "+signal+" ");
    }
    private StringBuilder packBrace(StringBuilder lineInformation){
        StringBuilder packBraceLine = new StringBuilder(lineInformation);
        packBraceLine.deleteCharAt(0);
        packBraceLine.insert(0,"[");
        packBraceLine.append("]");
        return packBraceLine;
    }
    private void reset(){
        firstLine = new StringBuilder();
        secondLine = new StringBuilder();
    }
    private void checkDirection(boolean pass, String Direction){
        if(pass){
            addSignal(Direction,"O");
            return;
        }
        addSignal(Direction,"X");
    }
    public void printMap(boolean pass, String Direction) {
        checkDirection(pass,Direction);
        System.out.println(packBrace(firstLine));
        System.out.println(packBrace(secondLine));
        if(!pass){
            reset();
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
    public void printStartMessage(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    public void printBridgeSizeInputMessage(){
        System.out.println("다리의 길이를 입력해 주세요.");
    }
    public void printMoveDirection(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래 : D)");
    }
}
