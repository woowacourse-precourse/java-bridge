## 🚀 기능 목록

클래스를 기준으로 기능 목록을 정리했다.

### InputView / 입력 클래스

- [x] readBridgeSize
    - 다리의 길이를 입력받는다
- [x] readMoving
    - 사용자가 이동할 칸을 입력받는다.
- [x] readGameCommand
    - 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.

### OutputView / 출력 클래스

- [x] 메시지 출력
    - [x] 게임 시작 메시지
    - [x] 이동할 칸 선택 메시지
    - [x] 재시작 여부 메시지
    - [x] 최종 게임 결과 메시지
    - [x] 게임 성공 여부 메시지
- [x] printMap
    - 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
- [x] printResult
    - 게임의 최종 결과를 정해진 형식(메시지, 다리 상태, 성공 여부, 총 시도 횟수)에 맞춰 출력한다.

### BridgeMaker / 다리 생성 클래스

- [x] makeBridge
    - 입력받은 size의 다리 생성
    - BridgeNumberGenerator 사용해서 랜덤으로 위아래 설정

### BridgeGame / 다리 건너기 게임 관리 클래스

- [x] move
    - 사용자가 칸을 이동할 때 사용하는 메서드
    - 입력받은 이동 칸(U or D)을 처리
- [x] retry
    - 사용자가 게임을 다시 시도할 때 사용하는 메서드
- [x] isEnd
    - 정답인지 아닌 지 확인하는 매서드
    - True: 정답을 맞추고, 마지막이 아닐 경우
    - False: 정답을 틀리거나, 정답이 맞더라도 마지막인 경우
- [x] isSuccess
    - 게임 성공 여부를 확인하는 매서드
- [x] trials
    - 총 시도 횟수 확인

### GameController / 게임 진행 클래스

- [x] begin
    - 전체적인 게임을 진행하는 매서드