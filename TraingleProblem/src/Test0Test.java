import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wuzhuo on 17/3/10.
 */
public class Test0Test {
    private Test0 testTraingle;
    @Before
    public void setUp() throws Exception {
        testTraingle = new Test0();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isTriangle() throws Exception {
        assertEquals(false, testTraingle.isTriangle(1,2,3));
        assertEquals(true,testTraingle.isTriangle(1,1,1));
    }

    @Test
    public void isEquilateral() throws Exception {
        assertEquals(true, testTraingle.isEquilateral(1,1,1));
        assertEquals(false,testTraingle.isEquilateral(1,3,3));
    }

    @Test
    public void isIsosceles() throws Exception {
        assertEquals(false, testTraingle.isIsosceles(1,1,2));
        assertEquals(false,testTraingle.isIsosceles(2,3,4));
        assertEquals(true,testTraingle.isIsosceles(1,3,3));
    }

    @Test
    public void isScalene() throws Exception {
        assertEquals(false, testTraingle.isScalene(1,1,2));
        assertEquals(false, testTraingle.isScalene(1,3,3));
        assertEquals(false, testTraingle.isScalene(1,1,1));
        assertEquals(true, testTraingle.isScalene(2,3,4));
    }

}