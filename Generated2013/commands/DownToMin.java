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
public class DownToMin extends Command {
    private boolean current;
    private boolean previous;
    
    public DownToMin() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Starting to go down");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.chassis.fast();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (RobotMap.towersensor.get());
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.chassis.stop();
        System.out.println("DownStop");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.chassis.stop();
        System.out.println("DownStop");
    }
}
