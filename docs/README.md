# ✔️ 구현할 기능 목록

## 설정(`Config`)

게임에 필요한 설정들을 가지고 있음

### 변수
- [x] 다리 길이의 숫자 범위 - RANGE_OF_BRIDGE_SIZE_START, RANGE_OF_BRIDGE_SIZE_END

## 명령어(`Command`)

사용자가 입력 가능한 명령어들의 모임

### 변수
- [x] 칸 방향 관련 명령어
  - [x] 위 - UP
  - [x] 아래 - DOWN
- [x] 게임 관련 명령어
  - [x] 종료 - QUIT
  - [x] 재시도 - RETRY

### 기능
- [x] 코드에 해당하는 명령어 값 반환 - convertKeyToValue

## 에러 메시지(`ErrorMessage`)

게임에서 발생하는 에러 메시지들의 모임

### 변수
- [x] 입력 관련 에러 메시지
  - [x] 입력값이 숫자 형태가 아닐 때 - NO_NUMERIC_STRING
  - [x] 입력된 다리의 길이가 범위 안에 존재하지 않을 때 - NO_RANGE_OF_BRIDGE_SIZE
  - [x] 유효하지 않은 칸 이동 명령일 때 - NO_VALID_MOVING
  - [x] 유효하지 않은 게임 관련 명령일 때 - NO_VALID_GAME_COMMAND
- [x] 게임 실행 도중 발생하는 에러 메시지
  - [x] 칸의 방향이 올바르지 않을 때 - NO_SUCH_DIRECTION
  - [x] 다리의 길이가 범위 안에 없을 때 - NO_RANGE_OF_BRIDGE_SIZE
  - [x] 존재하지 않은 명령어일 때 - NO_SUCH_COMMAND
  - [x] 아직 이동하지 않은 칸 위치일 때 - NO_SUCH_ROAD_POSITION

## 칸(`Road`)

다리에 존재하는 여러 칸 중에 하나

### 기능
- [x] 칸의 방향 유효성 확인 - validate
- [x] 칸의 방향과 주어진 방향 일치 여부 확인 - matchDirection
- [x] 현재 칸과 주어진 칸 일치 여부 확인 - matchRoad

## 로드맵(`RoadMap`)

이동했던 칸의 경로나 이동할 수 있는 칸의 정보

### 기능
- [x] 현재 가지고 있는 칸의 개수 반환 - getSize
- [x] 지정된 칸의 방향과 일치 여부 확인 - matchPositionWithDirection
- [x] 지정된 칸과 다른 칸의 방향 일치 여부 확인 - matchPositionWithRoad
- [x] 다리 관련 로드맵
  - [x] 칸의 개수가 범위 안에 있는지 확인 - validate
  - [x] 마지막 이동이 실패했는지 확인 - isFail
  - [x] 사용자가 다리 끝에 도달했는지 확인 - isEnd
- [x] 사용자 이동 관련 로드맵
  - [x] 위치에 해당하는 칸을 반환 - getRoad
  - [x] 이동했던 칸을 모두 삭제 - clear
  - [x] 이동할 칸에 대해 생성 및 저장 - addRoad

## 다리 게임(`BridgeGame`)

다리 건너기 게임을 관리

### 기능
- [x] 사용자가 칸을 이동 - move
- [x] 사용자가 게임을 다시 시도 - retry

## 다리 게임 매니저(`BridgeGameManager`)

다리 건너기 게임의 흐름을 담당

### 기능
- [x] 게임 실행 - play
  - [x] 게임 초기화 - initialize
  - [x] 다리 건너기 - run
  - [x] 재시작 여부 확인 - isRetry
  - [x] 게임 종료 - finish

## 다리 생성자(`BridgeMaker`)

다리의 길이를 입력 받아서 다리를 생성

### 기능
- [x] 다리 생성 - makeBridge

## 입력뷰(`InputView`)

사용자로부터 입력을 받음

### 기능
- [x] 다리의 길이를 입력 - readBridgeSize
  - [x] 사용자의 입력값이 숫자 형태인지 확인 - checkNumericString
  - [x] 주어진 다리 크기가 유효한지 확인 - checkRangeOfBridgeSize
- [x] 사용자가 이동할 칸을 입력 - readMoving
  - [x] 사용자의 입력값이 칸 이동 명령어인지 확인 - checkValidMoving
- [x] 사용자가 게임을 다시 시도할지 종료할지 여부를 입력 - readGameCommand
  - [x] 사용자의 입력값이 게임 관련 명령어인지 확인 - checkValidGameCommand

## 출력뷰(`OutputView`)

사용자에게 게임 진행 상황과 결과를 출력

### 기능
- [x] 게임 시작 메시지 출력 - printGameStart
- [x] 다리 길이 입력 메시지 출력 - printInputBridgeSize
- [x] 이동할 칸 입력 메시지 출력 - printInputMove
- [x] 게임 재시작 여부 입력 메시지 출력 - printInputRetry
- [x] 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력 - printMap
  - [x] 위치하고 있는 방향(위, 아래)과 다리의 상태를 비교하여 형식에 맞게 출력 - printDirectionRoadStateMap 
    - [x] 칸 위치에 따른 구분자 출력 - printRoadSeparation
    - [x] 칸의 위치를 기준으로 정답과 해답을 비교하여 O, X 출력 - printOorX
- [x] 게임의 최종 결과를 정해진 형식에 맞춰 출력 - printResult
  - [x] 정답과 해답을 비교해 성공 여부를 출력 - printSuccessOrFail
- [x] 에러 메시지 출력 - printErrorMessage

## 무한 입력(`InfiniteInput`)

사용자로부터 입력을 받음(특정 조건을 만족할때까지)

### 기능
- [x] 사용자가 올바른 입력을 할 때까지 계속해서 입력 - getInput

## 검증자(`Validator`)

값이 형식에 맞춰져 있는지 확인

### 기능
- [x] 값이 숫자 문자열인지 확인 - isInRangeOfString
- [x] 문자열로된 범위 안에 값이 존재하는지 확인 - isInRangeOfString
- [x] 숫자로된 범위 안에 값이 존재하는지 확인 - isInRangeOfNumber