# 프리코스 4주차 기능목록

# Class

## `Application`

```
main 클래스 
게임 시작
```

## `BridgeGame`

```
List<String> bridge
처음 생성한 다리 U, D
List<String> gameState
유저의 입력 U, D

boolean move()
main에서 호출시켜서 끝날때까지 반복문을 돌려서 
성공 -> true
실패 -> false

boolean retry() 
move 에서 호출당하면 게임을 재시작할껀지 종료할껀지 선택

boolean crossFail()
다리 건너기 실패했을 때

boolean endOfInput()
사용자의 입력이 끝났을 때
 
```

## `BridgeMaker`

```
List<String> makeBridge(int size)
size를 받아서 다리를 생성

List<String> makeBridgeIntegerList(int size)
size 를 List<Integer>로 변경 0과 1

List<String> makeBridgeStringList(List<Integer> bridgeNum)
makeBridgeIntegerList에서 호출하여 0과 1을 변경시켜준다.

String randNumToString(int num)
0과 1을 D와 U로 변경
```

## `BridgeRandomNumberGenerator`

```
generate() 
랜덤으로 숫자를 정해주는 메서드 0 or 1 반환
```

## `InputView`

```
readBridgeSize()
다리길이를 입력받고 다리 길이를 호출해준다.

readMoving()
유저가 이동할 칸을 입력받는다.

readGameCommand()
사용자가 게임을 다시 시도할 지 종료할 지 여부를 입력

모두 Exeption 클래스를 통해 예외처리 진행
```

## `OutputView`

```
전체적으로 매개변수
List<String> userState : 유저의 입력 U or D
boolean continueGame : 게임이 진행중인지 종료된건지
boolean isSuccess : 종료되었을 때 성공 or 실패
를 이용하여 경우의 수를 따져 출력하게 된다.

printMap()
현재까지 이동한 다리의 상태를 정해진 형식으로 출력
매번 출력해줘야함 !!!!

printResult() 
게임의 최종 결과를 출력해준다.

void judgeGameStatement(List<String> userState, boolean continueGame, boolean isSuccess)
출력 결과의 경우의 수를 나누어 줌 
- 게임 진행중 or 끝 -> 메서드 연결
- 게임 끝 AND 성공 -> 메서드 연결
- 게임 끝 AND 실패 -> 메서드 연결
```

## `Exeption`

```
입력에 대한 예외처리를 해주는 클래스
예외처리 (오버로딩 활용하기)
- 다리길이 입력
숫자가 아닐 때
3과 20사이의 숫자가 아닐 때

- 이동할 칸을 입력 
U or D 가 아닐 때 만 처리해주면 될듯, , ?

- 게임 다시시도 여부 
R or Q 가 아닐 때

```

## `GameStarter` : 전체 게임을 관리하는 메서드

```
GameStarter() 생성자 호출 시
 bridge : 생성

boolean startGame(List<String> bridge, int totalCount)
게임 시작 메서드

boolean gameInProgress(boolean continueGame, BridgeGame bridgeGame)
게임 진행 여부를 판단해주는 메서드

boolean retryCheck(boolean continueGame, BridgeGame bridgeGame)
재시도 여부를 판단

boolean inputReTry(OutputView outputView, BridgeGame bridgeGame, boolean continueGame)
R과 Q를 판단 하는 메서드

boolean moveForward(BridgeGame bridgeGame)
U와 D를 판단하는 메서드

List<String> makeBridge()
다리 생성 메서드 및 게임 시작 출력
```

## `BridgeTest`

```
다리_개수_예외_발생_테스트_확인
다리 개수에서 문자를_입력_했을_때
숫자_범위를_잘못_입력_했을_떄1
숫자_범위를_잘못_입력_했을_떄2
숫자_범위_잘못_입력_했을_때_IllegalArgumentExcption_발생
유저_입력_물음에_잘못된_값을_넣으면_IllegalArgumentExcption_발생
재시작_물음에_잘못된_값을_넣으면_IllegalArgumentExcption_발생
네개_한번에_성공_테스트
다섯개_재시도_테스트
실패_후_종료_테스트
```