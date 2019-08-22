package com.team1699.math;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class MathTest {

    @Test
    public void testEpsilonEquals(){
        assertTrue(MathHelper.epsilonEquals(1, 1.0000000000001)); //TODO Add more tests and messages for when test passes/fails
        assertFalse(MathHelper.epsilonEquals(1, 10));
    }
}
