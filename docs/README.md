# 프로그램 설명
위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.

## 1. 종료 조건
- 게임을 성공하거나, 실패하고 재시도를 포기할 경우

## 2. 비정상적인 값 처리
- 사용자가 터미널에 입력한 값이 비정상적인 값일 경우
    1. 다리 길이 입력
        - 숫자가 아닌 문자를 입력할 경우
        - 3이상 20인 숫자가 아닐 경우
    2. 사용자가 이동할 칸 입력
        - U, D가 아닐 경우
    3. 게임 다시 시작 여부 입력
        - R,Q가 아닐 경우
- 이 모든 경우, IllegalArgumentException을 발생시킨 후 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
## 3. class 설명

### Application
- 프로그램을 실행하고, 예외 발생시 에러메시지를 출력한다.

### service/GameLauncher
#### run
- 기능 요구 사항에서 요구한 순서대로 다리 건너기 게임을 구현한다.
#### doGame
- 어디로 건널지 사용자에게 예측을 요구하고, 예측에 따른 결과를 보여준다.
#### endGame
- 최종 게임 결과를 출력하고 게임을 종료한다.

### service/BridgeGame
#### OX
- 만들어진 bridge와 사용자의 예측이 동일하면 O, 틀리면 X를 반환한다.
#### move
- 사용자가 예측한 방향으로 움직였을때, OutputView.printMap으로 출력할 결과를 List<String> 형태로 반환한다.
#### retry
- 게임에 실패했을때, 사용자가 종료를 원하지 않는다면 true를, 그렇지 않으면 false를 반환한다.
### service/BridgeMaker

#### makeBridge
- U,D로 이루어진 List<String>을 만든다.
### service/BridgeRandomNumberGenerator
- Interface BridgeNumberGenerator를 implement한다.
#### generate
- 0혹은 1을 무작위로 리턴한다.

### view/InputView
- 사용자의 입력을 처리한다.
#### readBridgeSize
- 다리의 길이를 입력받는다. 3이상 20이하가 아니면 다시 입력받는다.
#### readMoving
- 다리의 위(U)로 갈지 아래(D)로 갈지 입력받는다. U,D가 아니면 다시 입력받는다.
#### readGameCommand
- 게임에 실패했을때, 다시시도(R) 할 것인지, 종료(Q)할 것인지 입력받는다. R,Q가 아니면 다시 입력받는다.

### view/OutputView
- 사용자에게 적절한 결과를 보여준다.
#### startBridge
- 다리 건너기 게임 시작을 알리는 메시지를 출력한다.
#### printMap
- 사용자가 이동함에 따른 다리 상황을 괄호, O, X를 통해 표현, 출력한다.
#### printResult
- 마지막 다리의 결과, 성공&실패 여부, 시도횟수를 포함한 최종 게임 결과를 출력한다. 