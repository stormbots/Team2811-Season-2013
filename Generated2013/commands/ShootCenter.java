/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;
import org.usfirst.frc2811.Generated2013.RobotMap;

/**
 *
 * @author Kelson
 */
public class ShootCenter extends CommandGroup {
    
    public ShootCenter() {
        this.addParallel(new print("just shooting"));
        this.addSequential( new DriveStop());
        this.addParallel(new windupShootMotors(-0.525));
        this.addParallel(new print("SHOOTING 3"));
        this.addSequential(new wait(5));
        this.addParallel(new windupShootMotors(-0.525));
        this.addSequential(new print("SHOOTING 3 NOW"));
        this.addSequential(new shoot());
        this.addSequential(new wait(0.2));
        this.addSequential(new shoot());
        this.addSequential(new wait(0.2));
        this.addSequential(new shoot());
        this.addSequential(new wait(0.2));
        this.addSequential(new shoot());
        this.addSequential(new wait(0.2));
        this.addSequential(new shoot());
//        this.addSequential(new UpToMax());
    }
}
