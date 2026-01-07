package dsa;
import dsa.ArrayListFunctionTwo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListFunctionTest{

    @Test
    void newListIsEmpty() {
        ArrayListFunctionTwo<String> list = new ArrayListFunctionTwo<>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void addElementsIncreasesSize() {
        ArrayListFunctionTwo<String> list = new ArrayListFunctionTwo<>();
        list.add("A");
        list.add("B");
        assertEquals(2, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    void getReturnsCorrectElement() {
        ArrayListFunctionTwo<String> list = new ArrayListFunctionTwo<>();
        list.add("A");
        list.add("B");
        assertEquals("B", list.get(1));
    }

    @Test
    void addByIndexInsertsCorrectly() {
        ArrayListFunctionTwo<String> list = new ArrayListFunctionTwo<>();
        list.add("A");
        list.add("C");
        list.add(1, "B");
        assertEquals("B", list.get(1));
        assertEquals(3, list.size());
    }

    @Test
    void removeByIndexRemovesCorrectElement() {
        ArrayListFunctionTwo<String> list = new ArrayListFunctionTwo<>();
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("C", list.get(1));
    }

    @Test
    void removeByValueWorks() {
        ArrayListFunctionTwo<String> list = new ArrayListFunctionTwo<>();
        list.add("A");
        list.add("B");
        assertTrue(list.remove("A"));
        assertFalse(list.contains("A"));
        assertEquals(1, list.size());
    }

    @Test
    void containsReturnsCorrectResult() {
        ArrayListFunctionTwo<String> list = new ArrayListFunctionTwo<>();
        list.add("A");
        list.add("B");
        assertTrue(list.contains("B"));
        assertFalse(list.contains("C"));
    }

    @Test
    void clearEmptiesTheList() {
        dsa.ArrayListFunctionTwo<String> list = new dsa.ArrayListFunctionTwo<>();
        list.add("A");
        list.add("B");
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void getInvalidIndexThrowsException() {
        dsa.ArrayListFunctionTwo<String> list = new dsa.ArrayListFunctionTwo<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void removeInvalidIndexThrowsException() {
        dsa.ArrayListFunctionTwo<String> list = new dsa.ArrayListFunctionTwo<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }
}
