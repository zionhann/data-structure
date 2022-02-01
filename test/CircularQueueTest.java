import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CircularQueueTest {

    CircularQueue queue = new CircularQueue(3);

    @Test
    void 삽입() {
        int value = 7;

        queue.enqueue(value);

        assertThat(queue.peek()).isEqualTo(7);
    }

    @Test
    void 삭제() {
        int value = 7;
        queue.enqueue(value);

        queue.dequeue();

        assertThat(queue.peek()).isEqualTo(0);
        assertThat(queue.size()).isEqualTo(0);
    }

    @Test
    void 순환배열() {
        int[] values = {2, 3};
        for (int value : values) {
            queue.enqueue(value);
        }
        int target = queue.dequeue();

        queue.enqueue(7);

        assertThat(target).isEqualTo(2);
        assertThat(queue.peek()).isEqualTo(3);
    }
}
