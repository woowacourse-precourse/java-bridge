## 🛠 기능 목록

-[ ] InputView
    - [ ] "다리의 길이를 입력해주세요." 문구와 함께 사용자에게 다리 길이를 입력받는다. (readBridgeSize)
        - [ ] camp.nextstep.edu.missionutils.Console 의 readLine() 메소드를 이용한다.
        - [ ] BridgeSizeValidation클래스의 validate()메소드로 유효성 검사를 진행한다.
        - [ ] 입력받은 다리 길이를 반환한다.
    - [ ] "이동할 칸을 선택해주세요. (위: U, 아래: D)" 문구와 함께 사용자에게 움직임을 입력받는다.(readMoving)
        - [ ] camp.nextstep.edu.missionutils.Console 의 readLine() 메소드를 이용한다.
        - [ ] MovingValidation클래스의 validate()메소드로 유효성 검사를 진행한다.
        - [ ] 입력받은 움직임을 반환한다.
    - "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)" 문구와 함께 사용자에게 게임 커멘드를 입력받는다. (readGameCommand)
        - [ ] camp.nextstep.edu.missionutils.Console 의 readLine() 메소드를 이용한다.
        - [ ] GameCommandValidation클래스의 validate()메소드로 유효성 검사를 진행한다.
        - [ ] 입력받은 게임 커멘드를 반환한다.


- [ ] OutputView
    - [ ] "다리 건너기 게임을 시작합니다." 문구와 함께 게임을 시작한다. (printStartingPhrase)
    - [ ] 지금까지 입력받은 사용자의 움직임을 맵으로 출력한다.(printMap)
        - [ ] printUpperBridge(), printLowerBridge() 메소드를 활용한다.
    - [ ] 위칸을 출력한다. (printUpperBridge)
        - [ ] 출력의 시작은 '[' 이 기호로 시작한다.
        - [ ] 출력의 끝은 ']' 이 기호로 끝낸다.
        - [ ] 사용자가 U를 입력하고 그 입력이 맞음면 ' O ' 로 표시한다.
        - [ ] 사용자가 U를 입력하고 그 입력이 틀리면 ' X ' 로 표시한다.
        - [ ] 사용자가 D를 입력하였으면 '   '로 표시한다.
        - [ ] 다리와 다리 사이는 '|'로 구분한다.
    - [ ] 아래칸을 출력한다. (printLowerBridge)
        - [ ] 출력의 시작은 '[' 이 기호로 시작한다.
        - [ ] 출력의 끝은 ']' 이 기호로 끝낸다.
        - [ ] 사용자가 D를 입력하고 그 입력이 맞음면 ' O ' 로 표시한다.
        - [ ] 사용자가 D를 입력하고 그 입력이 틀리면 ' X ' 로 표시한다.
        - [ ] 사용자가 U를 입력하였으면 '   '로 표시한다.
        - [ ] 다리와 다리 사이는 '|'로 구분한다.
    - [ ] 지금까지 입력한 결과를 출력한다. (printResult)
        - [ ] '최종 게임 결과' 문구와 함께 출력한다.
        - [ ] printUpperBridge(), printLowerBridge() 메소드를 활용한다.
        - [ ] '게임 성공 여부: ' 문구와 함께 실패인지 성공인지 나타낸다.
        - [ ] '총 시도한 횟수: ' 문구와 함께 총 시도한 횟수를 나타낸다.


- [ ] BridgeMaker
    - [ ] 입력받은 다리 길이 만큼 Bridge를 생성한다. (makeBridge)
        - [ ] bridgeNumberGenerator를 이용하여 생성한다.
        - [ ] 1,0 을 U,D로 변환하여 Bridge를 생성한다. (convertToBridge)


- [ ] BridgeGame
    - [ ] 사용자의 입력을 userMoving에 더한다. (move)
        - [ ] 사용자의 입력이 생성된 Bridge와 일치하면 userMoving에 추가한다.
        - [ ] 사용자가 'U'를 입력하였을 때 일치하지 않으면 'UX'를, 'D'를 입력하였을 때 일치하지 않으면 'DX'를 입력한다. (canNotMove)
        - [ ] 일치하면 true, 일치하지 않으면 false를 반환한다.
    - [ ] 사용자의 게임 커맨드 입력이 R이면 ture를, Q이면 false를 반환한다. (retry)
    - [ ] 게임 재시작 시, userMoving을 초기화 한다. (resetUserMoving)
    - [ ] 사용자가 Bridge의 끝에 도달하였는지 true,false를 통해 알려준다. (isEndOfBridge)
    - [ ] 사용자가 게임에서 성공 하였는지 true,false를 통해 알려준다. (isSuccess)
        - [ ] Bridge의 끝에 도달하였고, 마지막 입력도 틀리지 않으면 성공했다고 판단한다.
    - [ ] 도전 횟수를 하나 더한다. (addAttemptCount)


- [ ] BridgeController
    - [ ] 게임의 시작과 진행, 결과를 컨트롤 한다. (startGame)
    - [ ] 시작 문구를 출력하고, 사용자에게 다리 길이를 입력받아 다리를 생성한다. (setUpBridgeGame)
      - [ ] exception이 발생하면 에러 메시지를 출력 후 다시 입력받는다.
    - [ ] BridgeGame을 진행한다. (proceedBridgeGame)
        - [ ] 시작 할 때 마다 userMoving을 초기화 해준다.
        - [ ] 시작 시 총 게임 횟수를 추가한다.
        - [ ] 사용자의 입력이 Bridge와 비교하여 다르거나, 끝까지 도달 할 때 까지 움직힌다. (move)
            - [ ] exception이 발생하면 에러 메시지를 출력 후 다시 입력받는다.
        - [ ] 게임을 승리하거나 실패하고 retry를 하지 않았을 때 게임을 종료한다. (decideEndOfGame)
    - [ ] 게임의 승패 여부와 결과, 총 도전 횟수를 출력한다.

## 🔧 기능 요구 사항

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
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## ⚠️ 유효성 체크

- [ ] bridgeSize
    - [ ] 숫자인지 검사
    - [ ] 3~20 사이의 숫자인지 검사

- [ ] gameCommand
    - [ ] Q 또는 R인지 검사

- [ ] moving
    - [ ] U 또는 D인지 검사

## 📌 추가 요구사항

- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
- 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- 아래 있는 InputView, OutputView, BridgeGame, BridgeMaker, BridgeRandomNumberGenerator 클래스의 요구사항을 참고하여 구현한다.
    - 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
    - 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다.
    - InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
    - BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.

## 📗학습 목록

- [ ] 인터페이스
- [ ] 클래스 분리

## 🖌️ 클래스 다이어그램

![bridge-2](https://user-images.githubusercontent.com/70315475/203196537-c15a46ad-1ac8-41b4-b4fd-550e0509ad20.jpeg)


