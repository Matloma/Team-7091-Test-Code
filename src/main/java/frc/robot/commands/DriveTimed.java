/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveTimed extends CommandBase {
  DriveTrain driveTrain;
  private boolean finish = false;
  Timer timer;
  private double time;
  private double speed1;
  private double speed2;
  /**
   * Creates a new Drive.
   */
  public DriveTimed(DriveTrain driveTrain, double time, double speed1, double speed2){
    this.driveTrain = driveTrain;
    addRequirements(this.driveTrain);
    timer = new Timer();
    this.time = time;
    this.speed1 = speed1;
    this.speed2 = speed2;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    while(timer.get() < time){
      driveTrain.driveTank(speed1, speed2);
    }
    finish = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
