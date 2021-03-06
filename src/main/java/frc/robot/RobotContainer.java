// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Climb;
import frc.robot.commands.EngageIntake;
import frc.robot.commands.EngageLifter;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lifter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain = new DriveTrain();
  private final Climber climber = new Climber();
  private final Intake intake = new Intake();
  private final Lifter lifter = new Lifter();

  private ArcadeDrive arcadeDrive;
  private Climb climb;
  private EngageIntake engageIntake;
  private EngageLifter toggleIntakePosition;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    XboxController controller = new XboxController(0);

    arcadeDrive = new ArcadeDrive(driveTrain, () -> controller.getY(GenericHID.Hand.kLeft),
        () -> controller.getX(GenericHID.Hand.kRight));

    climb = new Climb(climber, () -> controller.getAButton());

    engageIntake = new EngageIntake(intake, () -> controller.getTriggerAxis(GenericHID.Hand.kLeft) - controller.getTriggerAxis(GenericHID.Hand.kRight));
    
    toggleIntakePosition = new EngageLifter(lifter, () -> controller.getXButton(), () -> controller.getYButton());

    driveTrain.setDefaultCommand(arcadeDrive);
    climber.setDefaultCommand(climb);
    intake.setDefaultCommand(engageIntake);
    lifter.setDefaultCommand(toggleIntakePosition);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
