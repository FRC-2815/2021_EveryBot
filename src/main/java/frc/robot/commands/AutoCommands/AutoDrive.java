package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase{

    private final DriveTrain driveTrain;
    private final Timer timer = new Timer();

    private double power;
    private double turn;
    private double seconds;

    private boolean finished = false;

    public AutoDrive(DriveTrain d, double p, double t, double s) {
        driveTrain = d;
        power = p;
        turn = t;
        seconds = s;

        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        timer.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (timer.get() >= seconds) {
            finished = true;
        } else {
            driveTrain.driveArcade(power, turn);
        }
    }

    // Called once the command ends or is interrupted.
    public void end(boolean interrupted) {
        driveTrain.driveArcade(0, 0);
        timer.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return finished;
    }
}
