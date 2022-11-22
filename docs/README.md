# 다리건너기

## 프로젝트 설명

- bridge
  + BridgeGame: 게임 로직 수행/ 이동 진행 상태, 시도 횟수, 다리 값 저장
  + NumberConvertor: 생성된 숫자값을 U,D로 변환
  + BridgeMaker: U,D로 변환된 값으로 다리생성
- status
  + GameResult: 게임 성공 여부 enum 값
  + PassOrNot: 다리 건너기 성공, 실패 여부 enum 값
  + RetryOrQuit: 재시작, 종료 여부 enum 값
  + UpDown: U와 D 값 enum 값
- view
  + GameMapMaker: 이동 진행 상태를 형식에 맞춰 만드는 객체
    + 위 칸과 아래 칸을 각각 만든다
  + InputView: 입력값을 받는 뷰
  + OutputView: 진행상태와 최종결과를 보여주는 뷰
  + StaticView: 정해져 있는 문구를 출력하는 뷰
  + TemplateLetters: 다리 모양 형식을 만드는데 쓰이는 기호들
  + ViewConstants: 정해져 있는 문구들을 상수화 한 것
- Controller: 객체 간의 연결, 프로그램 진행 로직

## 기능목록

- [x] 입력 받은 값에 맞는 길이의 다리를 생성하는 기능

- [x] 다리 각 칸의 값과 입력값을 비교하는 기능
  - 일치 / 불일치 여부를 리턴
  
- [x] 인덱스, 일치불일치값, 입력값으로 결과 출력하는 기능

- [x] 재시작/종료 기능
  - 입력값에 따라 게임을 재시작/종료 하는 기능

- [x] 중간 결과 출력하는 기능
- [x] 최종 결과 출력하는 기능

- [x] 입력값 검증 실패시 해당 값 다시 받기
- [x] 입력값 검증 기능

  - [x] 다리 길이
    - [x] 3이상 20이하 값만 가능
    - [x] 문자 입력 불가

  - [x] U,D
    - U, D 중 하나만 입력 가능

  - [x] R,Q
    - R, Q 중 하나만 입력 가능

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