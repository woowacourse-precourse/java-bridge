package bridge;


public class OutputView {

    public final BridgeGame bridgeGame;
    public String upperResult;
    public String downResult;

    public OutputView(BridgeGame bridgeGame){
        this.bridgeGame = bridgeGame;
    }

    public void setUpperResult(String upperResult)  {this.upperResult = upperResult;}

    public void setDownResult(String downResult)  {this.downResult = downResult;}

    public String getUpperResult()  {return this.upperResult;}

    public String getDownResult()  {return this.downResult;}

    public BridgeGame getBridgeGame(){
        return this.bridgeGame;
    }

    public void printMap() {
        int size = getBridgeGame().getInputList().size();
        this.upperResult = printBasicMap(size);
        this.downResult = printBasicMap(size);
        for(int i=0; i<size; i++){
            String input = bridgeGame.inputList.get(i);
            String answer = bridgeGame.getAnswerList().get(i);
            changeResult(input, answer, i);
        }
        System.out.println(this.getUpperResult() + "\n" + this.getDownResult());
    }

    public String printBasicMap(int size){
        String result = "";
        result += ("[ ");
        for(int i=0; i<(size-1); i++) result += (i + " | ");
        result += ((size-1) + " ]");
        return result;
    }

    public void changeResult(String input, String answer, int index){
        if(answer.equals("U") && answer.equals(input)) upperEqualsU(index);
        if(answer.equals("D") && answer.equals(input)) upperEqualsD(index);
        if(answer.equals("U") && !answer.equals(input)) upperNotEqualsU(index);
        if(answer.equals("D") && !answer.equals(input)) upperNotEqualsD(index);
    }

    public void printResult(int count, int total, int totalCount) {
        System.out.println("최종 게임 결과");
        printMap();
        String succeed = isSucceed(count, total);
        System.out.println("게임 성공 여부: " + succeed);
        System.out.println("총 시도한 횟수: " + totalCount);
    }

    public String isSucceed(int count, int total){
        if(count < total) return "실패";
        return "성공";
    }

    private void upperEqualsU(int index){
        setUpperResult(getUpperResult().replace(String.valueOf(index), "O"));
        setDownResult(getDownResult().replace(String.valueOf(index), " "));
    }

    private void upperEqualsD(int index){
        setUpperResult(getUpperResult().replace(String.valueOf(index), " "));
        setDownResult(getDownResult().replace(String.valueOf(index), "O"));
    }

    private void upperNotEqualsU(int index){
        setUpperResult(getUpperResult().replace(String.valueOf(index), " "));
        setDownResult(getDownResult().replace(String.valueOf(index), "X"));
    }

    private void upperNotEqualsD(int index){
        setUpperResult(getUpperResult().replace(String.valueOf(index), "X"));
        setDownResult(getDownResult().replace(String.valueOf(index), " "));
    }

}
