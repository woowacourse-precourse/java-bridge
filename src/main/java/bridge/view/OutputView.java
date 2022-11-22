package bridge.view;

import bridge.constant.BridgeConstant;
import bridge.constant.ResultConstant;

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
    public void reset(){
        firstLine = new StringBuilder();
        secondLine = new StringBuilder();
    }
    private void checkDirection(boolean pass, String Direction){
        if(pass){
            addSignal(Direction, ResultConstant.SUCCESS.getMark());
            return;
        }
        addSignal(Direction,ResultConstant.FAIL.getMark());
    }
    public void printMap(boolean pass, String Direction) {
        checkDirection(pass,Direction);
        System.out.println(packBrace(firstLine));
        System.out.println(packBrace(secondLine)+"\n");
    }
    public void printResult(int tryNumber, String result) {
        System.out.println("최종 게임 결과");
        System.out.println(packBrace(firstLine));
        System.out.println(packBrace(secondLine)+"\n");
        System.out.println("게임 성공 여부: "+result);
        System.out.println("총 시도한 횟수: "+tryNumber);
    }
    public void printStartMessages(){
        System.out.println("다리 건너기 게임을 시작합니다."+"");
        System.out.println("다리의 길이를 입력해 주세요.");
    }
    public void printMoveDirection(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래 : D)");
    }
    public void printRetry(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
