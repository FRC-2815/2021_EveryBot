// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lifter;

/** An example command that uses an example subsystem. */
public class EngageLifter extends CommandBase {

  private final Lifter lifter;
  private final BooleanSupplier intakeUp;
  private final BooleanSupplier intakeDown;

  public EngageLifter(Lifter i, BooleanSupplier iU, BooleanSupplier iD) {
    lifter = i;
    intakeUp = iU;
    intakeDown = iD;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(lifter);
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    lifter.off();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (intakeUp.getAsBoolean()) {
      lifter.intakeToggleUp();
    } else if (intakeDown.getAsBoolean()) {
      lifter.intakeToggleDown();
    } else {
      lifter.off();
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
