# 프리코스 4주차 미션 - 다리게임

---

![Generic badge](https://img.shields.io/badge/precourse-week4-green.svg)
![Generic badge](https://img.shields.io/badge/test-6_passed-blue.svg)
![Generic badge](https://img.shields.io/badge/version-1.2.0-brightgreen.svg)

> 우테코 5기 4주차 미션 다리게임을 구현한 저장소입니다

## 목차

> I. 프로그램 작동 개요
>
> II. 주요 기능 파악
>
> III. 세부 기능분석 및 구현현황

___

### I. 프로그램 작동 개요

위, 아래 두 칸으로 이루어진 판자를 가로로 N개 이어붙여 만든 다리를 좌에서 우로 건너가는 게임이다.

한 판자에서 다음 판자로 넘어가기 전, 다음 판자의 위, 아래 둘중 하나의 칸만 고를 수 있으며 두 칸 중 하나만 정답이고 다른 하나(오답)를 고를 경우 실패로 간주한다.
즉, 게임을 성공하려면 정답 판자만 골라서 최우측 판자에 도달해야 한다.

### II. 주요 기능 파악

1. 다리 길이 입력
2. 다리 생성(정답루트 내포)
3. 이동 선택 **(Up or Down)**
4. 선택의 정오 판단
5. 결과 출력
6. 재시작 여부 결정

---

### III. 세부 기능 분석 및 구현현황

#### 1. 전반적인 가이드 메시지 : OutputView

- [x] 시작 메시지
- [x] 길이 입력 메시지
- [x] 이동할 칸 선택 메시지 <span style="color:red">**[Loop 내부에 사용]**
- [x] 결과 출력 메시지 <span style="color:red">**[Loop 내부에 사용]**
- [x] 게임 재시작 메시지
- [X] 에러 출력 메시지

#### 2. 전반적인 입력받기 및 그것의 유효성 검사: InputView

- [x] 다리길이 입력
    * 예외: 숫자가 아님 -> 정수가 아님
- [x] 이동할 칸 입력
- [x] 재시작 여부 입력
    * 예외: 알파벳이 아님

#### 3. 다리생성( Class: BridgeMaker )

- [X] 길이 유효성 검사: 3~20 사이 정수가 아님
- [X] 다리에 대응되는 배열 선언
- [X] 랜덤생성을 통해 정답루트 입력(U,D)

#### 4. 위치 이동 ( Class: BridgeGame -> Bridge ) <span style="color:red">**[Loop 내부 로직]**

- [X] 위치이동 입력값 유효성 검사 :  UD가 아님 (대소문자..는 고민)
- [X] 현 위치저장 변수, 시도횟수저장 변수 선언 및 조절 필요

~~- 정오판단 메소드에 현 위치 및 입력값 전달~~

- [X] 위치저장 변수, 시도횟수 저장 변수 값 참조 위한 dto 클래스

#### 5. 정오 판단 ( Class: Bridge -> Result ) <span style="color:red">**[Loop 내부 로직]**

* 메인 로직
    1) [X] "다리"의 해당 인덱스에 해당 문자 있는지 체크
    2) [x] RESULT의 List<bool>에 Add
* 추후 조치
    - [x] 정답으로 끝난 경우: MAP의 SIZE와 다리길이 비교해 탈출여부 결정
    - [x] 오답으로 중도에 끝난 경우: 결과 출력 / 현위치, 결과 MAP 초기화 / 재시작결정함수 호출

#### 6. 결과 출력 ( Class: Result -> OutputView )

- [x] 진행 중(기본 출력 로직) <span style="color:red">**[Loop 내부 로직]**
    - 루프: 두번 List를 돌며 출력(한번은 UP, 한번은 DOWN)
        * 한 줄 내에서: START -> HIT, MISS -> END
          (LOOP는 전달받은 현위치까지 출력)
- [X] 게임 종료
    * [X] 성공조건 : MAP-SIZE 다리길이 도달 && 마지막 VALUE는 TRUE
    * [X] 실패조건 : 재시작함수에서 Q눌렀을 때

#### 7. 재시작 ( Class : BridgeGame )

- 선 조치
- [X] 유효성 검사: RQ가 아님 (대소문자..는 고민)
- 추후 조치
- [X] R 선택 시 : 현 위치 초기화 -> 루프 선두(위치 이동)부터 재시작
- [X] Q 선택 시 : 결과 출력 후 게임 종료
