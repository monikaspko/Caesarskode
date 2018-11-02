package test;

import main.java.FileReader;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

public class DekrypterTest {

    @Test
    public void testcde() {
        FileReader reader = new FileReader();
        List<String> result = reader.dekrypter(createTestlinjer("cde"), 2);
        assertEquals(Collections.singletonList("abc"), result);
    }

    @Test
    public void testcdeLang() {
        FileReader reader = new FileReader();
        List<String> result = reader.dekrypter(createTestlinjer("cde"), 31);
        assertEquals(Collections.singletonList("abc"), result);
    }

    @Test
    public void testCDEStor() {
        FileReader reader = new FileReader();
        List<String> result = reader.dekrypter(createTestlinjer("CDE"), 2);
        assertEquals(Collections.singletonList("ABC"), result);
    }

    @Test
    public void testabcStor() {
        FileReader reader = new FileReader();
        List<String> result = reader.dekrypter(createTestlinjer("ABC"), 2);
        assertEquals(Collections.singletonList("ØÅA"), result);
    }

    @Test
    public void testdef() {
        FileReader reader = new FileReader();
        List<String> result = reader.dekrypter(createTestlinjer("fgh"), 2);
        assertEquals(Collections.singletonList("def"), result);
    }

    @Test
    public void testHallo() {
        FileReader reader = new FileReader();
        List<String> result = reader.dekrypter(createTestlinjer("KDOOR"), 3);
        assertEquals(Collections.singletonList("HALLO"), result);
    }

    @Test
    public void testxyz() {
        FileReader reader = new FileReader();
        List<String> result = reader.dekrypter(createTestlinjer("åab"), 2);
        assertEquals(Collections.singletonList("æøå"), result);
    }

    private List<String> createTestlinjer(String linje) {
        List<String> testlinje = new ArrayList<>();
        testlinje.add(linje);
        return testlinje;
    }
}
