/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static XboxController xbox;
  private final DriveTrain driveTrain;
  private final DriveTankXbox driveTankXbox;
  private final DriveArcadeXbox driveArcadeXbox;

  private final Intake intake;
  private final IntakeBall intakeBall;

  private final Shooter shooter;
  private final ShootBall shootBall;

  private final AutonomousOne autonomousOne;

  SendableChooser<Command> chooser = new SendableChooser<>();



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    xbox = new XboxController(Constants.xboxControllerPort);
    driveTrain = new DriveTrain();
    driveTankXbox = new DriveTankXbox(driveTrain);
    driveTankXbox.addRequirements(driveTrain);
    driveArcadeXbox = new DriveArcadeXbox(driveTrain);
    driveArcadeXbox.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveTankXbox);

    intake = new Intake();
    intakeBall = new IntakeBall(intake);
    intakeBall.addRequirements(intake);
    intake.setDefaultCommand(intakeBall);

    shooter = new Shooter();
    shootBall = new ShootBall(shooter);
    shootBall.addRequirements(shooter);
    shooter.setDefaultCommand(shootBall);

    autonomousOne = new AutonomousOne(driveTrain, intake, shooter);
    chooser.setDefaultOption("Autonomous One", autonomousOne);
    //chooser.addOption("Autonomous Two", autonomousTwo);
    SmartDashboard.putData("Autonomous Chooser", chooser);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton move = new JoystickButton(xbox, XboxController.Button.kA.value);
    move.whenPressed(new DriveForwardTimed(driveTrain, 1, 0.5));

    JoystickButton switchDrive = new JoystickButton(xbox, XboxController.Button.kX.value);
    
    switchDrive.toggleWhenPressed(driveArcadeXbox.perpetually());
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return chooser.getSelected();
  }
}
