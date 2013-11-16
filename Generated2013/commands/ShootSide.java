/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *
 * @author Kelson
 */
public class ShootSide extends CommandGroup {
    
    public ShootSide() {
        this.addParallel(new windupShootMotors(-0.48));
        this.addSequential( new DriveStop());
        this.addSequential(new wait(5));
        this.addParallel(new windupShootMotors(-0.48));
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
