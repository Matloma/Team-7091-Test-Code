/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  WPI_TalonSRX left1;
  WPI_TalonSRX left2;
  WPI_TalonSRX right1;
  WPI_TalonSRX right2;

  SpeedControllerGroup left;
  SpeedControllerGroup right;

  DifferentialDrive driveTrain;  
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    left1 = new WPI_TalonSRX(Constants.left1CANPort);
    left2 = new WPI_TalonSRX(Constants.left2CANPort);
    right1 = new WPI_TalonSRX(Constants.right1CANPort);
    right2 = new WPI_TalonSRX(Constants.right2CANPort);

    left2.setInverted(true);
    right1.setInverted(true);

    left = new SpeedControllerGroup(left1, left2);
    right = new SpeedControllerGroup(right1, right2);

    driveTrain = new DifferentialDrive(left, right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveTankXbox(XboxController xbox, double speed){
    driveTrain.tankDrive(xbox.getY(Hand.kLeft)*-1*speed, xbox.getY(Hand.kRight)*-1*speed);
  }
  
  public void driveArcadeXbox(XboxController xbox, double speed){
    driveTrain.arcadeDrive(xbox.getY(Hand.kLeft)*-1*speed, xbox.getX(Hand.kRight)*speed);
  }

  public void driveForward(double speed){
    driveTrain.tankDrive(speed, speed);
  }

  public void driveTank(double speed1, double speed2){
    driveTrain.tankDrive(speed1, speed2);
  }

  public void stop(){
    driveTrain.stopMotor();
  }
}
