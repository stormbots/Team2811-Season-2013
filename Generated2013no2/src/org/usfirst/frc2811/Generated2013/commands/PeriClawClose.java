/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.Generated2013.Robot;
import org.usfirst.frc2811.Generated2013.RobotMap;

/**
 *
 * @author Kelson
 */
public class PeriClawClose extends Command{
    
    public PeriClawClose() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.trolley);
        System.out.println("PERISCOPE CLAW CLOSE");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (Robot.oi.Paused){
            RobotMap.shooteroutput.set(false);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (RobotMap.periscopeClawIsPerClawClosed.get());
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
