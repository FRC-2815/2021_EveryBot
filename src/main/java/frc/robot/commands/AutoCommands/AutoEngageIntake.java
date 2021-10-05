package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class AutoEngageIntake extends CommandBase {
    public final Intake intake;

    public final double power;
    public final double seconds;

    public final Timer timer = new Timer();
    private boolean finished = false;

    public AutoEngageIntake(Intake i, double p, double s) {
        intake = i;
        power = p;
        seconds = s;

        addRequirements(intake);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        timer.start();

        intake.set(power);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (timer.get() >= seconds) {
            finished = true;
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        intake.set(0);
        timer.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return finished;
    }
}