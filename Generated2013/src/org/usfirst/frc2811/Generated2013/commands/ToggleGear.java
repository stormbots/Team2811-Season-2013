/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2811.Generated2013.RobotMap;

/**
 *
 * @author Kelson
 */
public class ToggleGear extends CommandGroup {
    
    public ToggleGear() {
        addParallel(new print("changing gears"));
        if (RobotMap.inDrive){
            addSequential(new gearchange(false));
        } else {
            addSequential(new gearchange(true));
        }
        addParallel(new print("done changing gears"));
    }
}
