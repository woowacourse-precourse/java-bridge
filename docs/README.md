- **controller**
  - Controller
    - game() : 다리 건너기 전체의 흐름을 제어하는 메서드.
      - makeBridgeObject() : 건너갈 다리 객체를 생성.
      - doWhileGameEnd(int size) : 유저가 게임을 종료하거나, 다리를 건너갈때까지 건너기를 반복.
        - iterateToCrossEachBridge(int size, boolean retry) : 반복문에서 한칸씩 입력을 받으며 다리를 전진, 실패시 반복문 탈출.
          - makeChoice(int i) : 유저의 위/아래에 대한 입력을 유저 입력을 담는 컬렉션에 저장, 입력에 대한 결과 출력.
          - gamePass(int i, int size) : 게임이 성공적으로 끝났는가에 대한 boolean 반환.
      - printFinalResult(boolean pass , int tryNumbers) : 최종 결과를 출력.

  - InputController 
    - setBridgeSize() : 다리의 길이를 입력받고, 예외 발생시 이를 처리하고 다시 입력 받기 요청.
    - setMoveChoice() : 위/아래에 대한 유저의 선택을 입력받고, 예외 발생시 이를 처리하고 다시 입력 받기 요청.
    - setGameCommand() : 게임을 끝낼지/재시도할지 에 대한 유저의 선택을 입력받고, 예외 발생시 이를 처리하고 다시 입력 받기 요청.
    - checkMaxRecursion(int whichOne) : 유저의 반복되는 잘못된 입력을 캐치하고, 일정 수준이 넘었는지에 대한 boolean 반환.
    - checkIfRecursionExceed() : 잘못된 입력의 횟수를 최대 재귀 횟수 기준과 비교하여 이에 대한 결과 boolean 으로 반환.
    - init() : 재귀 횟수 기록 초기화.

- **domain**
  - Bridge : 건너갈 다리를 클래스화.
    - validateMove(String userDirection, int index) : 특정 위치에서 유저의 위/아래에 대한 선택이 유효한지를 검증.
    - returnCertainIndexUpOrDown(int index) : 특정 위치의 다리의 방향이 위/아래인지를 반환.
 
  - BridgeGame 
    - move(Bridge bridgeObject, String userChoice, int index)  : 특정 위치에서 유저의 입력을 통해 다리를 건널 수 있는지를 boolean 으로 반환.
    - retry(String retryInput) : 유저가 재시도를 원하면 참을, 원하지 않으면 거짓을 반환한다.

- **enums**
  - Retry : 재시도 여부에 대한 입력과, 이와 일치하는 boolean 을 묶은 Enum.
    - getRetryIntention(Retry retryEnum) : Enum을 입력받고, 이에 일치하는 재시도 의사를 boolean 으로 반환.
    - getProperRetryEnum(String givenInput) : 유저의 재시도에 대한 입력을 받아, 이에 일치하는 Enum을 반환.

- **view**
  - InputView
    - readBridgeSize() : 다리의 길이를 입력받고, 잘못된 입력에 대해서는 예외 발생시킴.
    - readMoving() : 이동할 칸(U / D)를 입력받고, 잘못된 입력에 대해서는 예외 발생시킴.
    - readGameCommand() : 게임 재시도 여부(R / Q)를 입력받고, 잘못된 입력에 대해서는 예외 발생시킴.
    - throwError(List<String> properElements, String input, String errorMessage) : properElements에 input이 포함되지 않은 경우 주어진 에러메시지를 기반으로 IllegalArgumentException 발생시킴

  - OutputView
    - InitialMessage() : 게임 시작 메시지 출력 .
    - printMap(final int ongoing, List<String> choices) : 현재 상태의 다리를 출력.
      - fillEachBuffer(StringBuffer buffer, int ongoing, String whereToPrint) : 다리의 위/아래를 나타내는 버퍼를 올바른 값으로 채움.
        - properOXSpace(String UpOrDown , String directionChoice, String whereToPrint) : 현재 위치와 유저 입력을 바탕으로 O/X/빈칸 출력.
      - clearBuffer() : 다리를 초기화하기 위하여 버퍼를 비움.
    - printResult(boolean pass, int tryNumber) : 다리 건너기가 종료된 이후 최종적인 결과를 출력.
      - printWinorLose(boolean pass) : 통과했다면 "성공"을, 아니라면 "실패"를 반환.
      - printTryNumbers(int tryNumber) : 몇번의 시도를 거쳤는지 출력.
        
- BridgeMaker
  - makeBridge(long size) : 주어진 크기의 Bridge 객체 생성.
    - upperOrDown(int randomNum) : Bridge의 특정 위치가 위인지/아래인지 결정.

- Constants : 자주 사용되는 상수들을 클래스로 모아놓고 용도에 따라 분류.



