// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  public final Spark intakeRoller;

  public Intake() {
    intakeRoller = new Spark(1);
  }

  public void off() {
    intakeRoller.set(0);
  }

  public void set(double power) {
    intakeRoller.set(power);
  }

  public void intakeIn() {
    intakeRoller.set(1);
  }

  public void intakeOut() {
    intakeRoller.set(-1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
