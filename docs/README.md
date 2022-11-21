# Application.java
### public static void define()
    각 클래스들을 생성하는 함수
### public static boolean returnSuccess(int i, int size)
    main함수 안의 for문을 끝까지 다 돌았을 때, 다리를 다 건넜음을 리턴해주는 함수
### public static int wrongMove(int size)
    사용자의 입력에 따라 사용자가 완주를 실패했을 경우 종료할지, 다시 시도할지 확인하는 함수
    -재시도 할 경우 -1을 리턴하여 main함수의 for문의 i값을 초기화 시킴
    -종료할 경우 size + 1 값을 리턴하여 main함수의 for문을 종료함
### public static void main(String[] args)
    정의한 함수들과 클래스들을 활용하여 동작하도록 구현.


# BridgeGame.java
### public BridgeGame()
    생성자.
    private 변수인 tryCount를 1로 초기화한다.
### public int getTryCount()
    private 변수인 tryCount의 값을 얻는다.
###  public boolean move(List<String> bridgeInfo, String userInput, int currentPos)
    유저의 입력에 따라 해당 입력에 다리를 건넜을 경우 true를 리턴.
### public boolean retry(String userInput)
    재시도 할 경우 private 변수인 tryCount를 1 증가시킨후 true를 반환



# BridgeMaker.java
### public List<String> makeBridge(int size)
    size만큼 다리를 생성하여 list에 저장
### private String returnStrForMakeBridge(int num)
    random숫자에 따라서 0일 경우 D를 리턴
    1일 경우 U를 리턴



# InputView.java
### public int readBridgeSize()
    다리 길이를 입력받고 해당 길이를 리턴해준다.

### private void inputCheckCorrect(String input)
    입력 받은 값에 숫자 이외의 값이 들어 갔을 경우 IllegalArgumentException를 발생시킨다.
    -> 예외처리 테스트에서 이 부분에서 예외처리가 안된다고 뜨는데 이유를 알 수 없음..
### private int checkLenSize(String input)
    입력받은 길이가 유효 범위 안에 있는지 확인한다.
### public String readMoving()
    사용자가 이동할 칸을 입력 받고 리턴해준다.
### private void checkInputStr(String str)
    유효한 입력인지 확인한다.
### public String readGameCommand()
    사용자가 게임을 다시 시도할지 종료할지 여부를 입력받고 리턴해준다.
### private void inputCheckReadGameCommand(String str)
    유효한 입력인지 확인한다.


# OutputView.java
###  public OutputView(BridgeGame bridgeGame)
    생성자.
    bridgame변수를 정의해준다.

### public void printMap(List<String> bridgeInfo, int currentPos, String userChoice)
    진행중인 다리를 출력해주기 위함
    윗부분과 아랫부분으로 출력을 나누었다.
### private void printUpperMap(List<String> bridgeInfo, int currentPos, String userChoice)
    다리의 윗부분을 출력해준다.
### private String returnOorBlankForUpper(List<String> bridgeInfo, int i)
    윗부분의 다리를 출력해주기 위한 도구로 user의 선택 이전단계 까지의 다리를 출력해준다.
### private String printUpperUserChoice(List<String> bridgeInfo, int currentPos, String userChoice)
    사용자의 선택에 따라 발생한 다리게임의 진행 상태를 출력해주기 위한 함수이다.
### private void printLowerMap(List<String> bridgeInfo, int currentPos, String userChoice)
    다리의 아랫부분을 출력해준다.
### private String returnOorBlankForLower(List<String> bridgeInfo, int i)
    아랫부분의 다리를 출력해주기 위한 도구로 user의 선택 이전단계 까지의 다리를 출력해준다.

### private String printLowerUserChoice(List<String> bridgeInfo, int currentPos, String userChoice)
    사용자의 선택에 따라 발생한 다리게임의 진행 상태를 출력해주기 위한 함수이다.

### public void printResult(boolean isSuccess, List<String> bridgeInfo, int currentPos, String userChoice, BridgeGame bridgeGame)
    게임이 완료된 이후. 성공 여부에 따라 최종 게임 결과를 출력한다.
### private String successOrFail(boolean isSuccess)
    성공 여부에 따라 성공 또는 실패를 리턴해준다.
