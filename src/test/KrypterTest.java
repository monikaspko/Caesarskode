package test;

import main.java.FileReader;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mko on 25.10.2018.
 */
public class KrypterTest {

    public static final String[] testString = new String[]{"experience is the teacher of all things ",
            "no one is so brave that he is not disturbed by something unexpected ",
            "i had rather be first in a village than second at rome ",
            "men freely believe that which they desire ",
            "i came i saw i conquered"};

    @Test
    public void testabc() {
        FileReader reader = new FileReader();
        List<String> result = reader.krypter(createTestlinjer("abc"), 2);
        assertEquals(Collections.singletonList("cde"), result);
    }

    @Test
    public void testabcStor() {
        FileReader reader = new FileReader();
        List<String> result = reader.krypter(createTestlinjer("ABC"), 2);
         assertEquals(Collections.singletonList("CDE"), result);
    }

    @Test
    public void testdef() {
        FileReader reader = new FileReader();
        List<String> result = reader.krypter(createTestlinjer("def"), 2);
         assertEquals(Collections.singletonList("fgh"), result);
    }

    @Test
    public void testHallo() {
        FileReader reader = new FileReader();
        List<String> result = reader.krypter(createTestlinjer("HALLO"), 3);
         assertEquals(Collections.singletonList("KDOOR"), result);
    }

    @Test
    public void testxyz() {
        FileReader reader = new FileReader();
        List<String> result = reader.krypter(createTestlinjer("æøå"), 2);
         assertEquals(Collections.singletonList("åab"), result);
    }

    @Test
    public void testfull() {
        FileReader reader = new FileReader();
        List<String> result = reader.krypter(createTestlinjer(testString), 7);
        List<String> result2 = reader.dekrypter(result, 7);
        List<String> result3 = reader.krypter(result2, 7);
        assertEquals(result, result3);
    }

    private List<String> createTestlinjer(String ... linjer) {
        List<String> testlinje = new ArrayList<>();
        Collections.addAll(testlinje, linjer);
        return testlinje;

    }

    private List<String> createTestlinjer(String linje) {
        List<String> testlinje = new ArrayList<String>();
        testlinje.add(linje);
        return testlinje;
    }
}
