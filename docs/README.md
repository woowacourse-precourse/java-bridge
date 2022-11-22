## 전체 프로세스 정리 

### 1. 다리 생성

- 다리 길이 n 입력 받기
- 길이 n인 다리 생성

### 2. 다리 건너기 게임 프로세스

- 선택 횟수 (최소)n번 만큼:
    - 'U'/'D' 입력 하고 일치/불일치 여부 출력 
    
### 3. 게임 종료

- 게임 결과 출력하기 : 최종 게임 결과와, 게임 성공 여부, 총 시도 횟수

## 기능 명세

### 1. 다리 생성

- [X] 게임 시작 -> 시작 멘트 출력 (`다리 건너기 게임을 시작합니다.`)
- [X] 다리 길이 입력 받기
    - [X] 3 이상 20 이하의 숫자가 아니면 예외 발생 : `IllegalArgumentException` 
        - 에러 메세지 출력하고 입력 다시 받기
- [X] 다리 생성: n만큼의 "U", "D"로 이루어진 문자열 리스

### 2. 다리 건너기 게임 프로세스

- [X] 다리 건너기 시작 -> 시작 멘트 출력 (`이동할 칸을 선택해주세요. (위: U, 아래: D)`)
- [X] 이동할 칸 입력 받기 -> PlayersMove 반영 (선택)
    - [X] 'U', 'D' 이외의 입력 시, 예외 발생 : `IllegalArgumentException` 
        - 에러 메세지 출력하고 입력 다시 받기
- [X] 다리와 사용자 움직임 비교하기 -> BridgeGame
- [X] 비교 결과 출력하기 -> Controller
- 틀렸다면 재시도/종료 선택 프로세스 
    - [X] 재시도/종료 멘트 출력 (`게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)`)
    - [X] 재시도/종료 입력 받기: 'R', 'Q' 이외의 입력 시, 예외 발생 : `IllegalArgumentException`
        - 에러 메세지 출력하고 입력 다시 받기
- [X] 재시도 선택시, 재시도 프로세스
    - game context refresh (유저 입력 저장, 움직인 횟수 초기화)
    - 다리 건너기 게임 프로세스 시작 
- [X] 종료 선택 시, 종료 프로세스로 간다
        
### 3. 게임 종료

- [X] 최종 결과 출력하기 
    - 움직인 현황 (최종 게임 결과)
    - 게임 성공 여부 
    - 총 시도한 횟수 
    

## 구조 명세 (주요 클래스 중심)

- GameController : 게임의 흐름 총괄
    - member fields: InputView, OutputView, BridgeGame
    - member functions: 
        - executeGame : 메인 흐름 총괄
        - makeBridge : 다리 만들어서 반환
        - crossToOtherSide : 전체 다리 건너기 프로세스
        - moveNextStep : 한 칸 건너기
        - updateGameStatus : 입력 결과와 다리가 일치하지 않을 때, RETRY/QUIT에 따라 상태 결정
        - printFinalResult : 최종 결과 출력
        
- BridgeGame : 게임의 주요 로직
    - member fields: GameContext, Bridge, PlayersMove, moveCount
    - member functions:
        - move : 사용자가 한칸 움직임
        - matchResults, isMatch : 사용자와 다리의 움직임을 비교해서 결과 반환
        - isLastMoveSuccess : 사용자의 마지막 움직임이 다리와 일치했는지 
        - playerHasCrossed : 사용자가 다리를 다 건넜는지
        - getPlayersMove : 사용자가 현재까지 움직인 기록
        - retry, refreshGameContext : 게임 다시 시도할 때 
        - transitionTo : 사용자 입력값에 따라 상태 변환 (PLAYING/QUIT_PLAYING)
        - onPlay : 현재 PLAYING 상태인지 
        - getContextInfo
        
- GameContext : 전체 게임 현황 정보
    - member fields: retryCnt, State
    - member functions:
        - increaseRetry : retryCnt++
        - transition : 상태 정보 변환 (PLAYING/QUIT_PLAYING)
        - getRetryCnt
        - isPlaying: 현재 PLAYING 상태인지 
        
- Bridge : 다리
    - member fields: bridgeSize, bridge
    - member functions:
        - getBridgeSize
        - getBridgeMove : 특정 인덱스의 다리 움직임 반환
        - requestNewBridge : 새로운 다리 생성
        
- PlayersMove : 사용자의 움직임 현황
    - member fields: playersMove
    - member functions:
        - move : 사용자 한칸 움직임
        - initialize : 사용자 움직임 초기화
        - getPlayersMove
        - getPlayersMoveAtIdx
        