
## 기능 목록
1. 생성할 다리의 길이를(n) input 으로 받는다 -> InputView : readBridgeSize
2. 위아래 두 칸으로 이루어진 길이(n) 만큼의 다리를 만든다 -> BridgeMaker : makeBridge 
   1. 매 nth 단계의 다리에서 위 칸과 아래 칸 중 건널수 있는 칸 무작위 선정 -> BridgeRandomNumberGenerator
3. 이동할 칸의 input을 받는다 (U=위칸, D=아래칸) -> InputView : readMoving
4. 이동 -> BridgeGame : move
5. 이동 칸에 대한 input을 기반으로, 해당 칸으로 움직일수 있는지 체크 -> ???
6. 이동 가능시 O, 불가능시 X 로 표현 -> OutPurView : printMap
7. 실패시 재시작 혹은 종료 input 받는다 -> InputView : readGameCommand
8. 개임 재시작 혹은 종료 -> BridgeGame : retry
9. 성공시 개임 종료 -> BridgeGame: end
10. 게임 종료 시 총 시도 쵯수 프린트 -> OutputView : printResult





## 🚀 기능 요구 사항(참조)
위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.
- 위아래 두 칸으로 이루어진 다리를 건너야 한다.
    - 다리는 왼쪽에서 오른쪽으로 건너야 한다.
    - 위아래 둘 중 하나의 칸만 건널 수 있다.
- 다리의 길이를 숫자로 입력받고 생성한다.
    - 다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 0과 1 중 무작위 값을 이용해서 정한다.
    - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다.
    - 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
- 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
    - 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.
    - 이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다.
- 다리를 끝까지 건너면 게임이 종료된다.
- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.
    - 재시작해도 처음에 만든 다리로 재사용한다.
    - 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.