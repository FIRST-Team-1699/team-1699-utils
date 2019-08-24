package com.team1699.motion;

import com.team1699.math.MathHelper;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PIDControllerTest {

    @Test
    public void testPD(){
        final double goal = 10.0;
        PIDController controller = new PIDController(0, 0, 0);

        //TODO Change how test works
        assertTrue(MathHelper.epsilonEquals(controller.update(0, false, false), goal));
    }
}
