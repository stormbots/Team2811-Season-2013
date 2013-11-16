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

public class shoot extends CommandGroup {
    public shoot() {
        if (!RobotMap.shooting && !RobotMap.flipping){
            RobotMap.shooting = true;
            addParallel(new print("FIRING CYLINDER"));
            addSequential(new moveShootPiston(true));
            addSequential(new wait(0.9));
            addSequential(new moveShootPiston(false));
            addSequential(new wait(0.9));
            RobotMap.shooting = false;
        }
    }
}
