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
        driveTrain.driveArcade(leftStick.getAsDouble(), rightStick.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}