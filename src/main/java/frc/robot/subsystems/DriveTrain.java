// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  private final WPI_TalonSRX leftFront;
  private final WPI_TalonSRX leftRear;
  private final WPI_TalonSRX rightFront;
  private final WPI_TalonSRX rightRear;

  private final DifferentialDrive arcadeDrive;

  public DriveTrain() {
    leftFront = new WPI_TalonSRX(Constants.driveTalons[0]);
    leftRear = new WPI_TalonSRX(Constants.driveTalons[1]);
    rightFront = new WPI_TalonSRX(Constants.driveTalons[2]);
    rightRear = new WPI_TalonSRX(Constants.driveTalons[3]);

    SpeedControllerGroup left = new SpeedControllerGroup(leftFront, leftRear);
    SpeedControllerGroup right = new SpeedControllerGroup(rightFront, rightRear);

    arcadeDrive = new DifferentialDrive(left, right);
  }

  public void driveArcade(double forward, double turn) {
    arcadeDrive.arcadeDrive(forward, turn, true);
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
