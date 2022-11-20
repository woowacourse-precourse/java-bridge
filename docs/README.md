# 프로그램 플로우
1. 다리 길이 입력받기
2. 랜덤으로 다리 구성을 생성
3. 이동할 칸을 입력받기 <br>

 3-1. 다리가 있는 곳이면, 다리의 끝부분인지 확인
 - 그렇다면 4로 이동
 - 그렇지 않다면 다음 단계로 넘어가고 3 반복 
<br>

 3-2. 다리가 없는 곳으면, 재시작/종료 입력받기
 - 재시작 시, 첫 단계로 돌아가고 3 반복
 - 종료 시, 4로 이동
4. 게임 결과 출력 후 프로그램 종료

# 기능 목록

## InputView 클래스
 - 사용자의 입력을 관리하는 클래스

1. readBridgeSize() : 다리의 길이를 입력받는다.
2. readMoving() : 사용자가 이동할 칸을 입력받는다.
3. readGameCommand() : 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
4. validateBridgeSizeInput() : 다리 길이 입력의 유효성을 검증한다.
5. validateMovingInput() : 이동 칸 입력의 유효성을 검증한다.
6. validateGameCommand() : 재시작/종료 여부 입력을 검증한다.

## OutputView 클래스
 - 출력을 관리하는 클래스
1. START_MESSAGE : 다리 건너기 게임을 시작합니다.
2. MOVE_MESSAGE : 이동할 칸을 선택해주세요. (위: U, 아래: D) 
3. RETRY_MESSAGE : 게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
4. printStartMessage() : 게임 시작 메세지를 출력한다.
5. printMoveMessage() : 이동 메세지를 출력한다.
6. printRetryMessage() : 재시도 메세지를 출력한다. -> 4, 5, 6은 input단에서 사용
7. printMap() : 현재까지 이동한 다리의 상태를 출력한다.
8. printResult() : 게임의 최종 결과를 출력한다.
9. printErrorMessage() : 오류 메세지를 출력한다.
10. formatMoveStatus() : List를 정해진 형식의 string으로 변환한다.

## BridgeGame 클래스
 - 실제 게임 진행과 관련된 기능 관리 클래스
 - 이 단에서 Bridge의 상황을 유지한다.

1. moveStatus : 다리의 게임 진행 상황을 저장하는 map
2. realBridge : U, D로 이루어진 정답 배열
3. currentLocation : 현재 위치를 저장하는 정수
4. restartNumber : 재시작 횟수를 저장하는 정수
5. move() : 사용자의 칸 이동을 반영한다
6. retry() : 사용자가 게임을 다시 시도할 때 변경사항을 유지
8. reflectMovement() : 이동을 moveStatus 변수에 반영한다. 

## BridgeMaker 클래스 (변경 불가)

## BridgeRandomNumberGenerator 클래스 (변경 불가)