/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Kelson
 */

public class shoot extends CommandGroup {
    private boolean shooting = false;
    public shoot() {
        if (shooting == false){
            shooting = true;
            addSequential(new moveShootPiston(true));
            addSequential(new wait(0.25));
            addSequential(new moveShootPiston(false));
            addSequential(new wait(0.25));
            shooting = false;
        }
    }
}
