# 🚗 미션 - 다리 건너기


## 👀 문제 확인하기
- 우아한테크코스 4주차 과제 '**다리 건너기**'의 구현 기능과 구현 로직을 담은 문서입니다.
- 문제는 [여기](https://github.com/woowacourse-precourse/java-bridge)에서 확인해 주세요.

---

## 🌟 구현 기능 목록

### [☑️] 사용자 입력 기능
- 사용자로부터 값을 입력받는다.
  - *InputView#readBridgeLength()*

### [☑️] 콘솔 출력 기능
- 게임 진행에 필요한 안내 멘트를 출력한다.
  - `다리 건너기 게임을 시작합니다.`
    - *OutputView#printStartMessage()*
  - `다리의 길이를 입력해주세요.`
    - *OutputView#printBridgeLengthMessage()*

- 사용자가 이동할 칸에 대한 안내 멘트를 출력한다.
  - `이동할 칸을 선택해주세요. (위: U, 아래: D)`
    - *OutputView#printPlayerMoveMessage()*

- 게임 종료에 대한 안내 멘트를 출력한다.
  - `게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)`
    - *OutputView#printPlayControlMessage()*

- 다리의 상태를 출력한다.
  - 사용자가 입력한 값과 건널 수 있는 다리인지에 따라 다리 맵을 출력한다.
    - *OutputView#printMap()*

- 게임의 최종 결과 및 성공 여부를 출력한다.
  - `최종 게임 결과` 멘트와 함께 최종적으로 다리 맵을 출력한다.
  - `게임 성공 여부: (성공/실패)` 및 `총 시도한 횟수: x`를 출력한다.
    - *OutputView#getGameResult()*

### [☑️] 제한사항 검증 기능
- 사용자가 입력한 값에 대한 검증 기능을 제공한다. 다음과 같은 경우 예외 사항으로 판단한다.
  - [예외] 입력받은 다리의 길이가 숫자인지 검증한다.☑️
    - *ValidationUtil#checkNumberType()*
  - [예외] 입력받은 다리의 길이가 3~20 사이의 값을 가지는지 검증한다.
    - *ValidationUtil#checkNumberRange()*
  - [예외] 입력받은 플레이어가 이동할 칸이 U 혹은 D인지 검증한다.
    - *ValidationUtil#validatePlayerMoveInput()*
  - [예외] 입력받은 재시작/종료 여부가 R 혹은 Q인지 검증한다. 
    - *ValidationUtil#validatePlayControlInput()*
- 예외 사항에 대해서는 `IllegalArgumentException`을 발생시킨다.

### [☑️] 다리에 대한 랜덤 숫자 부여 기능
- 0과 1 중 랜덤으로 값을 생성한 뒤, 해당 값에 따라 건널 수 있는 칸에 대해 U 혹은 D로 정의한다.
  - *BridgeMaker#makeBridge()*

### [☑️] 사용자의 움직임 확인 기능
- 사용자가 있는 위치의 다리를 체크하여 사용자가 건널 수 있는 다리를 선택했는지 체크한다.
- 건널 수 있다면 사용자의 위치를 이동하고, 성공 플래그를 true로 세팅한다. 
- 건널 수 없다면 성공 플래그를 false로 설정한다.
  - *BridgePlayer#checkMove()*

### [☑️] 게임 재시작 기능
- 사용자가 게임을 재시작하면 시도 횟수를 증가시키고 재시작 플래그를 설정한다.
  - *BridgeGame#retry()*

### [☑️] 게임 진행 확인 기능
- 사용자의 위치가 다리의 끝이 아닌지 체크한다.
  - *BridgeGame#isNotGameEnd()*

### [☑️] 재시작한 게임에 대한 판단 기능
- 재시작한 게임의 결과를 확인하고, 성공했다면 재시작 플래그를 다시 false로 변경한다.
  - *BridgeGame#checkRetryGameResult()*

---

## 💡 구현 로직
~~~

~~~

---

## 🔍 소감