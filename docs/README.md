## 구현 기능 목록
- --
- 게임 시작 및 종료 문구 출력


- 다리 길이 입력
    - 숫자 입력 확인
    - 3 이상 20 이하 값 확인


- 다리 생성
    - 길이(칸) 별 0과 1 무작위 값 설정


- 이동할 칸 입력
    - 문자(U와 D) 입력 확인


- 칸 이동
    - U 선택 시 위칸으로 이동
    - D 선택 시 아래칸으로 이동
    - 건널 수 있으면 O, 건널 수 없으면 X


- 게임 재시작/종료 입력
    - 문자(R과 Q) 입력 확인


- 잘못된 사용자 입력값을 경우, 에러 발생 및 다시 입력


## 기능 명세
- --
### BridgeGame 객체 클래스
#### : 게임 객체
  - ```setBridgeLength``` :  다리 길이 설정
  - ```setBridge``` : 랜덤 다리 설정



### GameRound 객체 클래스
#### : 게임 라운드 객체
  - ```winRound``` : 라운드 승리 여부 판단
  - ```isWin``` : 승리인지 구하기
  - ```isContinueRound``` : 라운드 진행 여부 판단
  - ```end``` : 라운드 종료

### BridgeGameEnd 메서드 클래스
#### : 다리 게임 종료/재시작 입력
  - ```isEnd``` : 다리 게임 종료/재시작
  - ```inputGameEnd``` : 종료/재시작 코드 입력
    - ```isValidateInputGameEnd``` : 종료/재시작 코드 입력값 확인
      - ```checkIsEndCode``` : 올바른 코드 입력 확인

### BridgeMaker 메서드 클래스
#### : 다리 생성
  - ```makeBridge``` : 다리 생성 및 반환
    - ```judgeRandomNumber``` : 랜덤값 다리 코드로 판단

### BridgeLength 메서드 클래스
#### : 다리 길이 입력
  - ```inputBridgeSize``` : 다리 길이 입력
    - ```isValidateInputBridgeSize``` : 다리 길이 입력값 확인
      - ```checkIsNumber``` : 숫자인지 확인
      - ```checkIsRightRange``` : 올바른 범위 값인지 확인

### BridgeMove 메서드 클래스
#### : 이동할 칸 입력
  - ```inputMoveBridge``` : 이동할 칸 입력
    - ```isValidateInputMoveBridge``` : 이동할 칸 입력값 확인
      - ```checkIsMoveCode``` : 올바른 코드 입력 확인

### Setting 클래스
#### : 프로그램 세팅
  - ```BRIDGE_COUNT``` : 다리 개수
  - ```MIN_BRIDGE_SIZE``` : 최소 다리 길이
  - ```MAX_BRIDGE_SIZE``` : 최대 다리 길이
  - ```GAME_EXIT``` : 게임 종료 코드(Q)
  - ```GAME_RE_START``` : 게임 재시작 코드(R)
  - ```PLAYER_MOVE_UP``` : 다리 이동 코드(U)
  - ```PLAYER_MOVE_DOWN``` : 다리 이동 코드(D)


### OutputView 클래스
#### : 사용자에게 게임 진행 상황과 결과를 출력
  - ```printGameStart``` : 게임 시작 문구 출력
  - ```printMap``` : 이동한 다리 상태 출력
  - ```printResult``` : 게임 최종 결과 출력 


### InputView 클래스
#### : 사용자로부터 입력을 받음
  - ```readBridgeSize``` : 다리 길이 문구 출력 및 입력
  - ```readMoving``` :  이동 문구 출력 및 입력
  - ```readGameCommand``` : 게임 재시작 혹은 종료 문구 출력 및 입력


### BridgeIllegalArgumentException 클래스
#### : IllegalArgumentException 예외처리
