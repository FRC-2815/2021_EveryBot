package frc.robot.commands.AutoCommands.AutoCommandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoCommands.AutoDrive;
import frc.robot.commands.AutoCommands.AutoEngageIntake;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;

public class LowerPortAuto extends SequentialCommandGroup {

    public LowerPortAuto(DriveTrain driveTrain, Intake intake) {
        addCommands(new AutoDrive(driveTrain, 1, 0, 2));
        addCommands(new AutoEngageIntake(intake, -1, 3));
        
    }
    
}