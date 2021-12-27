import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackUsingArrayTests {

    StackUsingArray stackUsingArray = new StackUsingArray(3);

    @Test
    void 삽입() {
        //given
        int value = 7;


        //when
        stackUsingArray.push(value);


        //then
        assertEquals(value, stackUsingArray.getTop());
    }

    @Test
    void 삭제() {
        //given
        int value = 7;
        stackUsingArray.push(value);
        stackUsingArray.push(value+1);

        //when
        int result = stackUsingArray.pop();


        //then
        assertEquals(value, stackUsingArray.getTop());
        assertEquals(value+1, result);
    }

    @Test
    void 삭제_empty() {
        //given
        int value = 7;

        //when
        int result = stackUsingArray.pop();


        //then
        assertEquals(-1, result);
    }

    @Test
    void 검색() {
        //given
        int value = 7;
        stackUsingArray.push(value);
        stackUsingArray.push(value+1);

        //when
        int result = stackUsingArray.search(value);
        int index = stackUsingArray.indexOf(result);


        //then
        assertEquals(value, result);
        assertEquals(0, index);
    }

    @Test
    void indexOf() {
        //given
        int value = 7;
        stackUsingArray.push(value);
        stackUsingArray.push(value+1);

        //when
        int result = stackUsingArray.indexOf(value);
        int result2 = stackUsingArray.indexOf(value+1);
        int result3 = stackUsingArray.indexOf(value+100);


        //then
        assertEquals(0, result);
        assertEquals(1, result2);
        assertEquals(-1, result3);
    }

    @Test
    void 재할당() {
        //given
        int value = 7;
        stackUsingArray.push(value);
        stackUsingArray.push(value+1);
        stackUsingArray.push(value+2);

        //when
        stackUsingArray.push(value+3);
        stackUsingArray.push(value+4);

        //then
        assertEquals(6, stackUsingArray.getCapacity());
        assertEquals(value+4, stackUsingArray.getTop());
    }
}