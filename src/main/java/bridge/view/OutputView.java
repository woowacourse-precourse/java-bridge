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
        System.out.println(packBrace(secondLine)+"\n");
        if(!pass){
            reset();
        }
    }
    public void printResult(int tryNumber, String result) {
        System.out.println("최종 게임 결과");
        System.out.println(packBrace(firstLine));
        System.out.println(packBrace(secondLine)+"\n");
        System.out.println("게임 성공 여부: "+result);
        System.out.println("총 시도한 횟수: "+tryNumber);
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
