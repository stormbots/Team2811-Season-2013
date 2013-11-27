/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.Generated2013.Robot;
import org.usfirst.frc2811.Generated2013.RobotMap;

/**
 *
 * @author Kelson
 */
public class Travel extends Command {
    private boolean stable;
    private Joystick stick;
    public Travel() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.trolley);
        stick = new Joystick(1);
        System.out.println("MOVE TROLLEY TO LEVEL");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double pwm;
        if (Robot.oi.Paused){
            //need interfacing for this stuff for now, I have comandeered an axis.
            pwm=RobotMap.tilt.AlignTrollyPWM();
            RobotMap.trolley.set(pwm);
            if (pwm==0){
                stable = true;
            } else { 
                stable = false;
            }
        } else {
            RobotMap.trolley.set(0.0);
        }
    }


    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stable;
    }

    // Called once after isFinished returns true
    protected void end() {
        RobotMap.trolley.set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        RobotMap.trolley.set(0.0);
    }
}
