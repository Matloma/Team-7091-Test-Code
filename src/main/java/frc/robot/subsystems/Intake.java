/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Intake extends SubsystemBase {
  Victor intake;
  /**
   * Creates a new Intake.
   */
  public Intake() {
    intake = new Victor(Constants.intakePWMPort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void intakeBall(XboxController xbox, double speed){
    intake.set(xbox.getTriggerAxis(Hand.kLeft)*speed);
  }

  public void intake(double speed){
    intake.set(speed);
  }

  public void stop(){
    intake.set(0);
  }
}
