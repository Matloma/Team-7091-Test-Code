/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutonomousOne extends SequentialCommandGroup {
  /**
   * Creates a new AutonomousOne.
   */
  public AutonomousOne(DriveTrain driveTrain, Intake intake, Shooter shooter) {
    addCommands(new DriveTimed(driveTrain, 2, 0.5), 
                new ParallelCommandGroup(new ShootBallTimed(shooter, 2, 0.5), 
                                         new IntakeBallTimed(intake, 2, 0.5)
                                        )
    );
  }
}