// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class EngageIntake extends CommandBase {
  private final Intake intake;
  private final DoubleSupplier axis;

  public EngageIntake(Intake i, DoubleSupplier a) {
    intake = i;
    axis = a;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intake.off();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (axis.getAsDouble() >  0) {
      intake.intakeIn();
    } else if (axis.getAsDouble() < 0) {
      intake.intakeOut();
    } else {
      intake.off();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
