/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2811.Generated2013.OI;
import org.usfirst.frc2811.Generated2013.RobotMap;

/**
 *
 * @author Kelson
 */

public class slamreverse extends CommandGroup {
    public slamreverse() {
        if (!RobotMap.shooting && !RobotMap.flipping){
            RobotMap.backwards = true;
            this.addSequential(new print("BEGIN SLAM"));
            this.addParallel(new print(""+RobotMap.backwards+""));
            this.addParallel(new windupShootMotors(0.0));
            addSequential(new wait(0.5));
            this.addParallel(new windupShootMotors(1));
            addSequential(new wait(0.5));
            this.addSequential(new windupShootMotors(-0.5));
            RobotMap.backwards = false;
        } else {
            this.addSequential(new print("NO SLAMMING NOW"));
        }
    }
}
