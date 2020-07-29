/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //CAN Ports
    public static final int left1CANPort = 0;
	public static final int left2CANPort = 1;
	public static final int right1CANPort = 2;
	public static final int right2CANPort = 3;

    //PWM Ports
    public static final int intakePWMPort = 0;
    public static final int shooterPWMPort = 1;

    //Other Ports
    public static final int xboxControllerPort = 0;
    
    //Constants
	public static final double throttle = 0.5;
	public static final double intakeMaxSpeed = 0.5;
	public static final double shooterMaxSpeed = 0.5;
	
}
