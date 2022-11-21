# 다리건너기

## 기능목록

- [x] 입력 받은 값에 맞는 길이의 다리를 생성하는 기능

- [x] 다리 각 칸의 값과 입력값을 비교하는 기능
  - 일치 / 불일치 여부를 리턴
  
- [x] 인덱스, 일치불일치값, 입력값으로 결과 출력하는 기능

- [x] 재시작/종료 기능
  - 입력값에 따라 게임을 재시작/종료 하는 기능

- [x] 중간 결과 출력하는 기능
- [x] 최종 결과 출력하는 기능

---
- get input of bridge length[class InputView - readBridgeSize()]
- generate bridge of the length 
  - bridge with 
    - (up - 1) OR (down - 0) value for ONE EACH Part.
      -  the value of a part is randomly given. - 주어진 코드.

- get input of [UP] OR [DOWN] / == U OR D [class InputView - readMoving()]
- 비교
  - printMap


### 일치
#### 결과 출력 - 다리와 O 출력 / 다음 것 진행 [class OutputView - printMap()]
    

#### 마지막에 일치 (== 게임 성공) 
  - 결과 출력 - [class OutputView - printMap()]
  - 최종 게임 결과 출력 [class OutputView - printResult()]
    - [게임 성공 여부] 출력, [총 시도한 횟수] 출력


### 불일치
  - 결과 출력 - 다리와 X 출력
  [class OutputView - printMap()] &
  [printResult()]
  - 다시시도 여부 출력

#### 다시시도 여부 input 받기 [class InputView - readGameCommand()]
  - R == 재시작
    - 같은 다리 재사용
  - Q == 그만두기 (== 실패)
    - 최종 게임 결과 출력 [class OutputView - printResult()]
      - [게임 성공 여부] 출력, [총 시도한 횟수] 출력