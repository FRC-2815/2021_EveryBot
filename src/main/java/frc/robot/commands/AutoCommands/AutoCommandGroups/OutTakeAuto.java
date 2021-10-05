package frc.robot.commands.AutoCommands.AutoCommandGroups;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoCommands.AutoDrive;
import frc.robot.commands.AutoCommands.AutoEngageIntake;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;

public class OutTakeAuto extends SequentialCommandGroup{

    public OutTakeAuto(DriveTrain driveTrain, Intake intake) {
        Timer.delay(5);
        addCommands(new AutoEngageIntake(intake, -1, 3));
        addCommands(new AutoDrive(driveTrain, -1, 0, 2));
    }
    
}