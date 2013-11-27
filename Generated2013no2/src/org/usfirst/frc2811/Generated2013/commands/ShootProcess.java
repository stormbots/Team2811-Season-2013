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
public class ShootProcess extends CommandGroup {
    
    public ShootProcess() {
        addParallel(new moveFrisbee());
        addParallel(new waitTillFrisbee());
        addSequential(new WaitForChildren());
        addSequential(new launchFrisbee());
    }
}
