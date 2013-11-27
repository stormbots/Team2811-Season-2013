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
public class PeriToClawActuator extends Command {
    
    public PeriToClawActuator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.periscope);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Periscope moving to claw limit switch...");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.periscope.up();
        Robot.chassis.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.oi.periclawactivated.get();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.periscope.stop();
        System.out.println("Periscope triggered claw actuator switch.");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.periscope.stop();
    }
}
