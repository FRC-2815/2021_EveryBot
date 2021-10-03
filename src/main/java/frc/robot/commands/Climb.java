// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

/** An example command that uses an example subsystem. */
public class Climb extends CommandBase {
  public final Climber climber;
  public final BooleanSupplier aButton;

  public Climb(Climber c, BooleanSupplier aB) {
    climber = c;
    aButton = aB;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climber);
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    climber.init();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (aButton.getAsBoolean()) {
      climber.climb(-1); // switch to opposite after each match
    } else {
      climber.off();
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
