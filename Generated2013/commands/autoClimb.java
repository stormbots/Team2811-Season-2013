/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2811.Generated2013.Robot;

/**
 *
 * @author Kelson
 */
public class autoClimb extends CommandGroup {
    private boolean finish = false;
    
    public autoClimb() {
        if (finish) {return;}
        addSequential(new gearchange(false));
        addSequential(new wait(0.2));
        addSequential(new DownSlow(1));
        addSequential(new DownFast(5));
        finish = false;
    }
}
