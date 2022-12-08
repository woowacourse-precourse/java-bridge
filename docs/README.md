## 입출력

### 입력

1. 다리 길이 (3 이상 20 이하)
2. 라운드마다 플레이어가 이동할 칸 (U, D)
3. 게임 재시작 / 종료 여부 (R, Q)

### 출력

1. 시작 문구
2. 라운드마다 결과 출력
3. 최종 게임 결과

## 기능 목록

#### 게임 초기 설정 `SETTING_GAME`

- [x] 시작 문구 출력

- [x] 다리 길이 입력 받기
- [x] 예외) 숫자가 아닌 경우
- [x] 예외) int 범위를 초과한 입력
- [x] 예외) 3 이상 20 이하의 숫자가 아닌 경우

#### 다리 만들기 `CREATING_BRIDGE`

- [x] 무작위 값을 다리 길이만큼 만들고, 0 - 아래칸 - D / 1 - 위 칸 - U 로 다리 만들기 `BridgeSign`

#### 게임 결과 변수 초기화 `GameVariable` `INITIALIZING_GAME_VARIABLE`

- [x] 총 시도 회수 => 0
- [x] 게임 성공 여부 => `false`
- [x] `Map` 초기화

#### START_GAME

- [x] 이동할 칸 입력
- [x] 예외) U, D 외의 입력
- [x] 매 이동 시 Map 출력

- [x] 칸 이동 성공 시, 다음 칸 입력 `ROUND_SUCCESS`
- [x] 칸 이동 실패 시, ROUND 실패 및 종료 `ROUND_FAIL`
- [x] 다리를 끝까지 이동한 경우 게임 성공 및 종료

#### 게임 재시작 (ROUND에서 실패한 경우)

- [x] 게임 재시작 / 종료 여부 입력 `RECEIVE_GAME_COMMAND`
- [x] 예외) R, Q 외의 입력

#### 게임 재시작 (R 입력) `RESTART_GAME`

- [x] 총 시도 회수 1 추가 (게임 재정비)
- [x] `Map` 초기화
- [x] START_GAME 실행

#### 게임 종료 (Q 입력) `QUIT_GAME`

- [x] 최종 게임 결과 출력 `PRINT_RESULT`

#### 게임에서 성공한 경우

- [x] 게임 성공 여부 => `true`
- [x] 최종 게임 결과 출력 `PRINT_RESULT`