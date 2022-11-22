package bridge;

enum OutputGameMessage{
    gameStartMessage("다리 건너기 게임을 시작합니다."),
    rangeInputMessage("다리의 길이를 입력해주세요."),
    moveInputMessage("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    retryInputMessage("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private String outputMessage;
    OutputGameMessage(String outputMessage){
        this.outputMessage = outputMessage;
    }

    public void printMessage(){
        System.out.println(outputMessage);
    }
}
