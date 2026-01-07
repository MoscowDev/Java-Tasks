package dsa;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {


    @Test
    public void testThat_ListEmpty() {
        ArrayListFunction list = new ArrayListFunction();
        assertTrue(list.IsEmpty());

    }

    @Test
    public void pushIntoList_ListIsNotEmpty_Test() {
        ArrayListFunction list = new ArrayListFunction();
        list.push("element");
        list.push("element of kings");
        assertFalse(list.IsEmpty());
    }

    @Test
    public void pushIntoStack_PopStackIsEmpty_Test() {
        ArrayListFunction list = new ArrayListFunction();
        list.push("element");
        list.pop();
        assertTrue(list.IsEmpty());

    }

    @Test
    public void pushTwoElementsIntoList_PopOneElement_ListIsNotEmpty_Test() {
        ArrayListFunction list = new ArrayListFunction();
        list.push("element");
        list.push("element of kings");
        list.pop();
        assertFalse(list.IsEmpty());

    }

    @Test
    public void pushTwoElementsIntoList_PopTwoElements_ListIsEmpty_Test() {
        ArrayListFunction list = new ArrayListFunction();
        list.push("element");
        list.push("element of kings");
        list.pop();
        list.pop();
        assertTrue(list.IsEmpty());
    }

    @Test
    public void pushTwoElementsIntoList_PopTwoElements_ListIsNotEmpty_Test() {
        ArrayListFunction list = new ArrayListFunction();
        list.push("element");
        list.push("element of kings");
        list.pop();
        list.pop();
        assertTrue(list.IsEmpty());

    }

    @Test
    public void popTakesOffTheLastElementInTheList_Test() {
        ArrayListFunction list = new ArrayListFunction();
        list.push("element");
        list.push("element of kings");
        assertEquals("element of kings", list.pop());

    }

    @Test
    public void popReturnsTheLastElementWhenMoreElementsArePopped_Test() {
        ArrayListFunction list = new ArrayListFunction();
        list.push("element");
        list.push("element of kings");
        list.pop();
        assertEquals("element", list.pop());


    }

    @Test
    public void testThatYouCanNotAddMoreElements_inTheList_ifListIsFull() {
        ArrayListFunction list = new ArrayListFunction();
        list.push("element");
        list.push("element of kings");
        list.push("element of kings");
        list.push("element of kings");
        list.push("element of kings");


        assertThrows(StackOverflowError.class, () -> list.push("The man must furnish the will to succeed"));
    }

    @Test
    public void testThatYouCanAddElementsToThePeekOfTheListOnly() {
        ArrayListFunction list = new ArrayListFunction();
        list.push("element");
        list.push("first top");
        list.push("second top");

        assertEquals("second top", list.peek());
    }
    @Test
    public void ListReturnsTheSizeOfTheList_Test() {
        ArrayListFunction list = new ArrayListFunction();
        list.push("element");
        list.push("element of kings");
        list.push("element of kings");
        list.push("element of kings");
        list.push("element of kings");
        assertEquals(5, list.size());
    }


}
