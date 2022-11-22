# 📑 기능 목록

### 입력(InputView)
- [x] 다리 길이 입력
- [x] 다리 이동할 칸 입력
- [x] 게임 재시작 및 종료 입력

### 출력(OutputView)
- [x] 게임 시작 문구 출력
- [x] 다리 현황 출력
- [x] 게임 결과 출력

### 다리 게임(BridgeGame)
- [x] 게임 시작
- [x] 다리 이동
- [x] 다리 이동 성패 여부 판단
- [x] 현재 다리 상황 기록
- [x] 게임 재시작
- [x] 게임 종료

### 다리 생성(BridgeMaker)
- [x] 다리 생성
- [x] 다리 저장
- [x] 다리 불러오기
- [x] 현재 다리 상황 생성
- [x] 현재 다리 상황 저장
- [x] 현재 다리 상황 불러오기

### 예외 처리(InputBridgeGameValidator)
- [x] 다리 길이 입력 예외 처리
  - [x] 숫자가 아닐 경우
  - [x] 빈 문자열을 입력했을 경우
  - [x] 3 이상 20 이하의 숫자가 아닐 경우
- [x] 다리 이동할 칸 입력 예외 처리
  - [x] U or D가 아닐 경우
  - [x] 빈 문자열을 입력했을 경우
- [x] 게임 재시작 및 종료 입력 예외 처리
  - [x] R or Q가 아닐 경우
  - [x] 빈 문자열을 입력했을 경우

# Refactoring 후, 기능 목록

## Controller

### 다리 게임(BridgeGameController)
- [x] 다리 셋팅
- [x] 게임 시작
- [x] 게임 종료

## View

### 입력(InputView)
- [x] 다리 길이 입력
- [x] 다리 이동할 칸 입력
- [x] 게임 재시작 및 종료 입력

### 출력(OutputView)
- [x] 게임 시작 문구 출력
- [x] 다리 현황 출력
- [x] 게임 결과 출력

## Model

### 명령 실행(BridgeGame)
- [x] 게임 시작
- [x] 다리 이동
- [x] 현재 다리 상황 기록
- [x] 게임 재시작
- [x] 게임 종료

### 명령 판단(JudgeCommand)
- [x] 다리 이동 성패 여부 판단
- [x] 게임 재시작 / 종료 여부 판단

### 다리 생성(BridgeMaker)
- [x] 다리 생성
- [x] 다리 저장
- [x] 다리 불러오기

### 다리 현황(PresentBridgeMaker)
- [x] 현재 다리 상황 초기화
- [x] 현재 다리 상황 저장
- [x] 현재 다리 상황 불러오기

### 게임 정보(GameStatus)
- [x] 게임 정보 저장 및 불러오기
  - [x] 다리 크기
  - [x] 현재 인덱스
  - [x] 게임 시도 횟수
  - [x] 게임 결과

## Valid

### 예외 처리(InputBridgeGameValidator)
- [x] 다리 길이 입력 예외 처리
  - [x] 숫자가 아닐 경우
  - [x] 빈 문자열을 입력했을 경우
  - [x] 3 이상 20 이하의 숫자가 아닐 경우
- [x] 다리 이동할 칸 입력 예외 처리
  - [x] U or D가 아닐 경우
  - [x] 빈 문자열을 입력했을 경우
- [x] 게임 재시작 및 종료 입력 예외 처리
  - [x] R or Q가 아닐 경우
  - [x] 빈 문자열을 입력했을 경우

## Enum

### 명령어(Commands)
- [x] UP(1, "U"), DOWN(0, "D"), RETRY(-1, "R"), QUIT(-1, "Q")

### 이동 결과(MoveResults)
- [x] SUCCESS(true, "O"), FAILURE(false, "X")

### 반대 이동(ReverseMoves)
- [x] REVERSE_UP("U", "D"), REVERSE_DOWN("D", "U")