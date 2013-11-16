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
public class TroFore extends Command {
    
    public TroFore() {
        // Use requires() here to declare subsystem dependencies
        
        requires(Robot.trolley);
        System.out.println("TROLLEY TO MAX");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (Robot.oi.Paused){
            RobotMap.trolley.set(-0.05);
        } else {
            RobotMap.trolley.set(0.0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.trolleyTroMax.get();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.trolley.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.trolley.stop();
    }
}
