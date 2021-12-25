import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicArrayTests {

    private final int capa = 7;
    DynamicArray dynamicArray = new DynamicArray(capa);

    @Test
    public void 값_추가() {
        //given
        int arr[] = dynamicArray.getArr();
        int capacity = dynamicArray.getCapacity();

        //when
        for(int i=0; i< capacity; i++) {
            dynamicArray.push_back(i);
            //then
            assertEquals(i, arr[i]);
        }
    }

    @Test
    public void 재할당() {
        //given
        int arr[] = dynamicArray.getArr();
        int capacity = dynamicArray.getCapacity();

        for(int i=0; i< capacity; i++) {
            dynamicArray.push_back(i);
        }

        //when
        dynamicArray.push_back(7);

        //then
        assertEquals(capa*2, dynamicArray.getCapacity());
    }

    @Test
    public void 값_참조() {
        //given
        int arr[] = dynamicArray.getArr();

        //when
        int result = dynamicArray.getValue(3);

        //then
        assertEquals(arr[3], result);
    }

    @Test
    public void 값_변경() {
        //given
        int arr[] = dynamicArray.getArr();

        //when
        dynamicArray.setValue(3, 7);

        //then
        assertEquals(7, arr[3]);
    }

    @Test
    public void 값_검색() {
        //given
        int arr[] = dynamicArray.getArr();
        int target = 3;
        dynamicArray.push_back(target);

        //when
        int result = dynamicArray.search(target);
        int value = dynamicArray.getValue(result);

        //then
        assertEquals(arr[result], value);
    }
}