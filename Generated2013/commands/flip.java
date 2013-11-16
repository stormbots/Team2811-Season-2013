/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.Generated2013.OI;
import org.usfirst.frc2811.Generated2013.Robot;
import org.usfirst.frc2811.Generated2013.RobotMap;

/**
 *
 * @author Kelson
 */
public class flip extends Command {
    
    public flip() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Flipping");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!RobotMap.shooting) {
            RobotMap.flipping = true;
            Robot.shootythingy.flipActivate(true);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !OI.flip.get();
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Done flipping");
        Robot.shootythingy.flipActivate(false);
        RobotMap.flipping = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.shootythingy.flipActivate(false);
        System.out.println("Done flipping");
        RobotMap.flipping = false;
    }
}
