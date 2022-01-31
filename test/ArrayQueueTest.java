import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayQueueTest {

    ArrayQueue queue = new ArrayQueue(3);

    @Test
    void 삽입() {
        //when
        int value = 7;

        //given
        queue.enqueue(value);

        //then
        assertThat(queue.peek()).isEqualTo(value);
    }

    @Test
    void 삭제() {
        int value1 = 6;
        int value2 = 7;
        queue.enqueue(value1);
        queue.enqueue(value2);

        int target = queue.dequeue();

        assertThat(target).isEqualTo(value1);
    }

    @Test
    void 재할당() {
        int value = 7;
        queue.enqueue(value);

        int[] newQueue = queue.reallocate(queue.length() * 2);

        assertThat(newQueue.length).isEqualTo(queue.capacity());
        System.out.println("length of queue: " + newQueue.length
                         + "\nsize of queue: " + queue.size()
                         + "\ncapacity of queue: " + queue.capacity());
    }

    @Test
    void capa_초과시_자동할당() {
        int value = 7;
        queue.enqueue(value);
        queue.enqueue(value);
        queue.enqueue(value);
        // 초과
        queue.enqueue(value);

        assertThat(queue.length()).isEqualTo(6);
    }

    @Test
    void dequeue시_empty_체크() {
        int value = 7;
        queue.enqueue(value);
        queue.dequeue();

        queue.dequeue();

        assertThat(queue.size()).isEqualTo(0);
    }
}
