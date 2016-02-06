package org.usfirst.frc.team4373.robot.input.filter;

/**
 * Created by tesla on 2/2/16.
 */
/*
  1.6 +-+-----------+-------------+------------+-------------+-----------+-+
      +             +             +            +             +             *
  1.4 +-+                           ((x**8) +(0.3*x**7) + (0.2*x)) ********+
      |                                                                   *|
      |                                                                   *|
  1.2 +-+                                                                *-+
      |                                                                 *  |
    1 +-+                                                              * +-+
      |                                                               *    |
  0.8 +-+                                                            *   +-+
      |                                                             *      |
      |                                                            *       |
  0.6 +-+                                                        **      +-+
      |                                                        ***         |
  0.4 +-+                                                    **          +-+
      |                                                   ***              |
      |                                               *****                |
  0.2 +-+                                    *********                   +-+
      +             +************************  +             +             +
    0 ***************-------------+------------+-------------+-----------+-+
      0            0.2           0.4          0.6           0.8            1
 */
public class LowStretch implements Filter {
    @Override
    public Object applyFilter(Object input) {
        double inputN = (Double) input;
        inputN = Math.pow(inputN, 5);
        return inputN;
    }
}
