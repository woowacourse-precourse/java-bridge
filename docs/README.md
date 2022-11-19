## 자바다리게임 기능구현 목록
- BridgeApp, ViewController, BridgeGame, Bridge, BridgeMaker,
### BridgeApp 기능 구현목록
- BridgeApp 은 다리게임 시작, 플레이, 종료 역할을 하는 객체이다
- 게임시작 하는 start 메서드 구현
- 게임종료를 확인하는 메서드 구현
- 시도횟수를 카운트 해야함

### ViewController 기능 구현목록
- view 에 관련된 메시지를 받아 해당하는 view 메시지를 전송하는 객체
- `InputView` 에 관련된 메시지를 처리하는 메서드 구현
- `OputView` 에 관련된 메시지를 처리하는 메서드 구현

### BridgeGame
- BridgeGame 은 비지니스 로직을 포함하는 객체이다. `BridgeApp` 의 요청을받아 다리이동, 다리상태 확인, 결과확인을
담당하는 객체이다.
- 사용자가 다리이동시 선택하는 move 메서드 구현
    - 움직인 후 다리상태를 반환한다.
- 게임실패 시 재시도 여부를 확인하는 메서드 구현

### Bridge
- 생성된 리스트를 관리하는 객체이다.
- `BridgeMaker` 를 의존해 다리를 생성한다.
- 입력값에 대한 검증을 하는 메서드 구현
- 입력값에 따라 다리상태를 반환하는 메서드 구현

