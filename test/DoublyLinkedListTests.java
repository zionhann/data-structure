import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DoublyLinkedListTests {

    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

    @Test
    void 마지막_노드_추가() {
        //given
        int value = 7;

        //when
        doublyLinkedList.push_back(value);
        doublyLinkedList.push_back(value+1);

        //then
        assertEquals(value, doublyLinkedList.getHead().value);
        assertEquals(value+1, doublyLinkedList.getCurr().value);

    }

    @Test
    void 마지막_노드_삭제() {
        //given
        int value = 7;
        doublyLinkedList.push_back(value);
        doublyLinkedList.push_back(value+1);

        //when
        doublyLinkedList.pop_back();

        //then
        assertEquals(value, doublyLinkedList.getCurr().value);

    }

    @Test
    void 노드_검색() {
        //given
        int value = 7;
        doublyLinkedList.push_back(value);
        doublyLinkedList.push_back(value+1);

        //when
        DoublyLinkedList.Node result1 = doublyLinkedList.search(value+1);
        DoublyLinkedList.Node result2 = doublyLinkedList.search(value+2);

        //then
        assertEquals(value+1, result1.value);
        assertNull(result2);
    }

//    @Test
//    void 노드_삽입() {
//        //given
//        int value = 7;
//        int target = value;
//        doublyLinkedList.push_back(value);
//        doublyLinkedList.push_back(value+1);
//
//        //when
//        doublyLinkedList.insert(target, value+2);
//
//        //then
//        assertEquals(value, doublyLinkedList.search(value+2).prev.value);
//        assertEquals(value+1, doublyLinkedList.search(value+2).next.value);
//    }

    @Test
    void 노드_삽입_포지션() {
        //given
        int value = 7;
        int position = 0;
        doublyLinkedList.push_back(value);
        doublyLinkedList.push_back(value+1);

        //when
        doublyLinkedList.insert(position, value+2);

        //then
        assertEquals(value, doublyLinkedList.search(value+2).prev.value);
        assertEquals(value+1, doublyLinkedList.search(value+2).next.value);
    }

    @Test
    void 노드_지정_삭제_첫번째노드() {
        //given
        int value = 7;
        doublyLinkedList.push_back(value);
        doublyLinkedList.push_back(value+1);

        //when
        doublyLinkedList.delete(0);

        //then
        assertNull(doublyLinkedList.search(value));
        assertEquals(value+1, doublyLinkedList.getHead().value);
        assertEquals(value+1, doublyLinkedList.getCurr().value);
    }

    @Test
    void 노드_지정_삭제_중간노드() {
        //given
        int value = 7;
        doublyLinkedList.push_back(value);
        doublyLinkedList.push_back(value+1);
        doublyLinkedList.push_back(value+2);

        //when
        doublyLinkedList.delete(1);

        //then
        assertNull(doublyLinkedList.search(value+1));
    }

    @Test
    void 노드_지정_삭제_마지막노드() {
        //given
        int value = 7;
        doublyLinkedList.push_back(value);
        doublyLinkedList.push_back(value+1);
        doublyLinkedList.push_back(value+2);

        //when
        doublyLinkedList.delete(2);

        //then
        assertNull(doublyLinkedList.search(value+2));
        assertEquals(value+1, doublyLinkedList.getCurr().value);
    }


    @Test
    void 첫번째_노드_삭제() {
        //given
        int value = 7;
        doublyLinkedList.push_back(value);
        //linkedList.push_back(value+1);

        //when
        doublyLinkedList.pop_front();

        //then
        //assertEquals(value+1, linkedList.getHead().value);
        assertNull(doublyLinkedList.getHead());
    }

    @Test
    void 첫번째_노드_추가() {
        //given
        int value = 7;
        //linkedList.push_back(value);

        //when
        doublyLinkedList.push_front(value+1);

        //then
        assertEquals(value+1, doublyLinkedList.getHead().value);
    }

    @Test
    void 값_반환() {
        //given
        int value = 7;
        int position = 1;
        doublyLinkedList.push_back(value);
        doublyLinkedList.push_back(value+1);
        doublyLinkedList.push_back(value+2);

        //when
        int result = doublyLinkedList.getValue(position);

        //then
        assertEquals(value+1, result);
    }
}
