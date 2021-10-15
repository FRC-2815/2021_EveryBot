package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {

    public final DriveTrain driveTrain;
    public final DoubleSupplier leftStick;
    public final DoubleSupplier rightStick;

    public ArcadeDrive(DriveTrain d, DoubleSupplier lS, DoubleSupplier rS) {
        driveTrain = d;
        leftStick = lS;
        rightStick = rS;

        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        double forwardsValue = -leftStick.getAsDouble();
        double turnValue = rightStick.getAsDouble() * .8;

        double forwardsNegation = 1.0;
        double turnNegation = 1.0;

        if (forwardsValue < 0.0) {
            forwardsNegation = -1.0;
        }
    
        if (turnValue < 0.0) {
            turnNegation = -1.0;
        }
        if (Math.abs(forwardsValue) < .05) {
            forwardsValue = 0.0;
            }

            if (Math.abs(turnValue) < .05) {
            turnValue = 0.0;
            }

            if (forwardsValue < 0.0) {
            forwardsNegation = -1.0;
            }

            if (turnValue < 0.0) {
            turnNegation = -1.0;
            }

            driveTrain.driveArcade(
                Math.pow(Math.abs(forwardsValue), 1.5) * forwardsNegation,
                Math.pow(Math.abs(turnValue), 1.5) * turnNegation);
        }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}