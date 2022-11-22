## 🚀 기능 목록

클래스를 기준으로 기능 목록을 정리했다.

### InputView | 입력 클래스

- [x] askBridgeSize() : 다리 size 입력 | 예외 처리
  - [x] readBridgeSize()
      - 다리의 size를 입력받는다
- [x] askMoving() : 이동 방향 입력 | 예외 처리
  - [x] readMoving()
      - 사용자가 이동할 칸을 입력받는다.
- [x] askRestart() : 재시작 여부 입력 | 예외 처리
  - [x] readGameCommand()
      - 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.

### OutputView | 출력 클래스

- [x] 메시지 출력
    - [x] 게임 시작 메시지
    - [x] 이동할 칸 선택 메시지
    - [x] 재시작 여부 메시지
    - [x] 최종 게임 결과 메시지
    - [x] 게임 성공 여부 메시지
- [x] printMap() : 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
  - [x] createRow(): 각 행(upper, lower)의 문자열 생성
    - [x] getSign(): 입력에 따라 'O', 'X', ' ' 중 하나를 반환 
- [x] printResult() : 게임의 최종 결과를 정해진 형식(메시지, 다리 상태, 성공 여부, 총 시도 횟수)에 맞춰 출력한다.

### ValidCheck | 유효 입력 확인 클래스

- [x] 다리 size 입력시 예외 확인
    - [x] 정수인지 확인
    - [x] 3~20인지 확인
- [x] 커맨드 입력시 예외 확인
    - [x] U 또는 D 인지 확인
    - [x] R 또는 Q 인지 확인
    - [x] size가 1인지 확인 (ex: UU 처럼 커맨드에는 해당 되지만 문자가 하나 이상인 경우 방지하기 위해)

### BridgeMaker | 다리 생성 클래스

- [x] makeBridge()
    - 입력받은 size의 다리 생성
    - BridgeNumberGenerator 사용해서 랜덤으로 위아래 설정

### BridgeGame | 다리 건너기 게임 관리 클래스

- [x] move()
    - 사용자가 칸을 이동할 때 사용하는 메서드
    - 입력받은 이동 칸(U or D)을 유저가 입력했던 문자열에 추가
- [x] retry()
    - 사용자가 게임을 다시 시도할 때 사용하는 메서드
    - 유저가 입력했던 문자열 clear
- [x] isEnd()
    - 정답인지 아닌 지 확인하는 매서드
    - return True: 정답을 맞추고, 마지막이 아닐 경우
    - return False: 정답을 틀리거나, 정답이 맞더라도 마지막인 경우
- [x] isSuccess()
    - 게임 성공 여부를 확인하는 매서드

### GameController | 게임 진행 클래스

- [x] start() : 전체적인 게임을 진행하는 매서드
    - [x] 게임시작 메시지
    - [x] 다리 size 입력
    - [x] 정답 다리 생성
    - [x] move() : 끝까지 성공하거나 중간에 실패하기전까지 이동
      - [x] move1step() : 한번 이동하는 매서드
    - [x] userWin() : 성공이면 결과출력하고 게임 종료
    - [x] userRetry() : 재시작 매서드
      
      - [x] checkRetry() : R 입력시 재시작, Q 입력시 결과 출력 후 종료
- [x] trials
    - 총 시도 횟수 확인