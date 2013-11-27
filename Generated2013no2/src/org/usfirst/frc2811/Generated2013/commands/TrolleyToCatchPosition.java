/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.Generated2013.Robot;

/**
 *
 * @author Driver
 */
public class TrolleyToCatchPosition extends Command {
    
    public TrolleyToCatchPosition() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.trolley);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Trolley moving catch position switch...");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.trolley.right();
        Robot.chassis.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.oi.trolleyhome.get();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.trolley.stop();
        System.out.println("Trolley in catching position.");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.trolley.stop();
    }
}
