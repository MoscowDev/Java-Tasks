package dsa;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testThat_StackIsEmpty() {
        StackFunctions strings = new StackFunctions();
        assertTrue(strings.IsEmpty());

    }

    @Test
    public void pushIntoStack_StackIsNotEmpty_Test() {
        StackFunctions strings = new StackFunctions();
        strings.push("element");
        strings.push("element of kings");
        assertFalse(strings.IsEmpty());
    }

    @Test
    public void pushIntoStack_PopStackIsEmpty_Test() {
        StackFunctions strings = new StackFunctions();
        strings.push("element");
        strings.pop();
        assertTrue(strings.IsEmpty());

    }

    @Test
    public void pushTwoElementsIntoStack_PopOneElement_StackIsNotEmpty_Test() {
        StackFunctions strings = new StackFunctions();
        strings.push("element");
        strings.push("element of kings");
        strings.pop();
        assertFalse(strings.IsEmpty());

    }

    @Test
    public void pushTwoElementsIntoStack_PopTwoElements_StackIsEmpty_Test() {
        StackFunctions strings = new StackFunctions();
        strings.push("element");
        strings.push("element of kings");
        strings.pop();
        strings.pop();
        assertTrue(strings.IsEmpty());
    }

    @Test
    public void pushTwoElementsIntoStack_PopTwoElements_StackIsNotEmpty_Test() {
        StackFunctions strings = new StackFunctions();
        strings.push("element");
        strings.push("element of kings");
        strings.pop();
        strings.pop();
        assertTrue(strings.IsEmpty());

    }

    @Test
    public void popTakesOffTheLastElementInTheStack_Test() {
        StackFunctions strings = new StackFunctions();
        strings.push("element");
        strings.push("element of kings");
        assertEquals("element of kings", strings.pop());

    }

    @Test
    public void popReturnsTheLastElementWhenMoreElementsArePopped_Test() {
        StackFunctions strings = new StackFunctions();
        strings.push("element");
        strings.push("element of kings");
        strings.pop();
        assertEquals("element", strings.pop());


    }

    @Test
    public void testThatYouCanNotAddMoreElements_inTheStack_ifStackIsFull() {
        StackFunctions strings = new StackFunctions();
        strings.push("element");
        strings.push("element of kings");
        strings.push("element of kings");
        strings.push("element of kings");
        strings.push("element of kings");


        assertThrows(StackOverflowError.class, () -> strings.push("The man must furnish the will to succeed"));
    }

    @Test
    public void testThatYouCanAddElementsToThePeekOfTheStackOnly() {
        StackFunctions strings = new StackFunctions();
        strings.push("element");
        strings.push("first top");
        strings.push("second top");

        assertEquals("second top", strings.peek());
    }
    @Test
    public void StackReturnsTheSizeOfTheStack_Test() {
        StackFunctions strings = new StackFunctions();
        strings.push("element");
        strings.push("element of kings");
        strings.push("element of kings");
        strings.push("element of kings");
        strings.push("element of kings");
        assertEquals(5, strings.size());
    }

    }

