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
public class periscopeup extends Command {
    
    public periscopeup() {
        // Use requires() here to declare subsystem dependencies
        
        requires(Robot.periscope);
        System.out.println("PERISCOPE TO MAX OR BAR");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   /*     if (Robot.oi.Paused){
            RobotMap.periscope.set(0.3);
        } else {
            RobotMap.periscope.set(0.0);
        } */
    } 

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return(RobotMap.periscopePerMax.get() || RobotMap.periscopeClawHaveBar.get());
    }

    // Called once after isFinished returns true
    protected void end() {
        //RobotMap.periscope.set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        //RobotMap.periscope.set(0.0);
    }
}
