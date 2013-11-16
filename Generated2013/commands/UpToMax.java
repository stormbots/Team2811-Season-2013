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
public class UpToMax extends Command {
    private boolean current;
    private boolean previous;
    
    public UpToMax() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        previous = RobotMap.towersensor.get();
        System.out.println("Starting to go up");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (RobotMap.inDrive) { return; }
        current = RobotMap.towersensor.get();
        if (current != previous && current == true) {
            Robot.chassis.stop();
            RobotMap.position = 1;
        } else if (current != previous && current == false) {
            RobotMap.position = 0;
            Robot.chassis.forward();
        } else {
            Robot.chassis.forward();
        }
        previous = current;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (RobotMap.position == 1);
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.chassis.stop();    
        System.out.println("UpStop");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.chassis.stop();
        System.out.println("UpStop");
    }
}
