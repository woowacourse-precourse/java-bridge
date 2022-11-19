package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    InputView inputView = new InputView();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    OutputView outputView = new OutputView();
    boolean retryOrNot;
    private String failSuccess;


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> bridgeList) {
        // 몇개 만들지 숫자 받기
        // 랜덤 다리 만들기
        // 어디 건널지 입력 받기 (여기까지는 application에 만들어도 될듯?)
        // 맞는지 틀린지 확인
        this.retryOrNot = true;
        int tryNumber = 0;
        while(retryOrNot){
            outputView.resetMap();
            bridgeMainGame(bridgeList,retryOrNot);
            tryNumber++;
        }

        outputView.printResult(tryNumber,failSuccess);

    }



    private boolean bridgeMainGame(List<String> bridgeList, boolean retryOrNot){


        for (int order = 0; order <bridgeList.size(); order++) {

            String upDownUserInput = inputView.readMoving();

            if (Compare(bridgeList,upDownUserInput, order)){
                String ox = "O";
                outputView.printMap(ox,order,upDownUserInput);
                this.retryOrNot = true;
                if (order == bridgeList.size()-1){
                    this.retryOrNot = false;
                    this.failSuccess = "성공";
                }
                continue;
            }
            String ox = "X";
            outputView.printMap(ox,order,upDownUserInput);
            this.retryOrNot = retry();
            this.failSuccess = "실패";
            break;
        }

        return this.retryOrNot;
    }
    private boolean Compare(List<String> bridgeList, String upDownUserInput,int number) {
        if (bridgeList.get(number).equals(upDownUserInput)){
            /** get을 사용하지 않는다?
             *
             */
            //outputView사용

            return true;
        }
        return false;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean retry() {
        String retryUserInput = inputView.readGameCommand();
        if (retryUserInput.equals("R")){
            return true;
        }
        return false;
    }
}
