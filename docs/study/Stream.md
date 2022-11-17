## Stream API

- Stream API의 최상위 인터페이스는 `BaseStream` 인터페이스이지만 직접 사용하는 경우는 없음
- 주로 사용하는 인터페이스는 Stream 인터페이스이며 `BaseStream`을 상속하는 인터페이스
- 여러 메서드를 정의하며, 대부분 파라미터에 람다와 메서드 참조가 필요함
- Stream을 구현한 객체의 주요 특징은 불변성이며 Stream을 통해 얻은 결과는 새롭게 생성된 데이터

---

#### 예시

`long count()` 해당 스트림에 포함된 항목의 수를 반환

`Stream concat(Stream, Stream)` 파라미터로 전달되는 두 개의 스트림을 하나의 스트림으로 반환

`R collect(Collector)` 스트림의 항목들을 컬렉션 타입의 객체로 변환

`Stream filter(Predicate)` 스트림의 항목들을 파라미터의 조건에 따라 필터링하고 결과 항목들을 스트림 형태로 반환

`void forEach(Consumer)` 스트림 항목들에 대한 순회 (최종 연산)

`Optional reduce(BinaryOperator)` 람다 표현식을 기반으로 데이터를 소모하고 그 결과를 반환 (최종연산)

`Object[] toArray()` 스트림 항목들을 배열 객체로 반환

`Stream sorted()` 스트림 항목들에 대해 정렬하고 이를 스트림으로 반환

---

## Stream 객체 생성

1. `Collection` 객체를 통해 스트림을 생성
2. 스트림 빌더를 통해 스트림 생성 (잘 사용하지 않음)

한 번 생성한 스트림은 사용 후 다시 사용할 수 없으며 전체 데이터에 대한 처리가 이루어지면 종료된다.

## Stream 연산

- 각 연산의 연결을 통해 파이프라인을 구성할 수 있음 (다양한 연산을 조합할 수 있음)
- 스트림을 이용한 연산 처리는 스트림 객체의 생성부터 중간 연산, 최종 연산 단계로 구분할 수 있음

### 중간 연산
- 반환 타입이 `Stream`
- 예시: filter, map, limit, sorted, distinct, peek, skip

### 최종 연산
- 중간 연산을 통해 가공된 스트림을 최종 연산을 통해 소모하여 결과를 출력
- 예시: forEach, count, collect, sum, reduce