/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.Generated2013.OI;
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
        
        requires(Robot.trolley);
        System.out.println("MOVE TROLLEY TO LEVEL");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
            if (Robot.oi.Paused && OI.tigger.get()){
                
                //need interfacing for this stuff for now, I have comandeered an axis.
            double speed;
            double raw1;
                //Obtain raw angle from accelerometer
                raw1 = Robot.tilt.getAngle();

                //Calculate PWM based on distance to target angle
                //AllignTrolly(TARGETANGLE, DEADZONE) in degrees.
                speed = Robot.tilt.getPWM(68.0,3.0);
                RobotMap.trolley.set(-speed);
                System.out.println(-speed);
                if (speed==0){
                    stable = true;
                } else { 
                    stable = false;
                }
            } else {
                System.out.println("WE NO HAVE BUTTON");
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
