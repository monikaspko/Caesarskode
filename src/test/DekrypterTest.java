package test;

import main.java.FileReader;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mko on 25.10.2018.
 */
public class DekrypterTest {

    @Test
    public void testcde() {
        FileReader reader = new FileReader();
        List<String> result = reader.dekrypter(createTestlinjer("cde"), 2);
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
    @Test
    public void testfull() {
        FileReader reader = new FileReader();
        List<String> result = reader.dekrypter(createTestlinjer("lawlyplujl gp zgæ olgælhj ol ygv mghssg æo pun zu vg vulgp zgzv gi yh ålg æohægolgp zg uvægkpzæø yilkgibgzv t læo pungøu la wljæl k p gohkgyh æoly gilgmp yz ægpu ghg åpsshn lgæohug zljv ukghæ gyvt ltlug m ylls b gil s plålgæoh æg opjogæolbgklzpyl pgjhtlgpgzh gpgjvuxølylk"), 7);
        assertEquals(Collections.singletonList("experience is the teacher of all things no one is so brave that he is not disturbed by something unexpected i had rather be first in a village than second at rome men freely believe that which they desire i came i saw i conquered"), result);
    }

    private List<String> createTestlinjer(String linje) {
        List<String> testlinje = new ArrayList<>();
        testlinje.add(linje);
        return testlinje;
    }
}
