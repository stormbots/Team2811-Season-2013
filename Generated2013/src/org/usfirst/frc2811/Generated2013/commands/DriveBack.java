package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.Generated2013.Robot;

public class DriveBack extends Command {
    private double m_timeout;
    
    public DriveBack(double timeout) {
        // Use requires() here to declare subsystem dependencies
        
        m_timeout = timeout;
        this.requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        this.setTimeout(m_timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("going back");
        Robot.chassis.back();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
