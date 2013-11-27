package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveInASquare extends CommandGroup {
    
    public DriveInASquare() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        this.addSequential(new DriveForward(2));
        this.addSequential(new SlideLeft(2));
        this.addSequential(new DriveBack(2));
        this.addSequential(new SlideRight(2));
        this.addSequential(new DriveForward(2));
    }
}
