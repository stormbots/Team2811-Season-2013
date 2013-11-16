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
public class TrolleyToMinLimit extends Command {

    public TrolleyToMinLimit() {
        // Use requires() here to declare subsystem dependencies
        
        requires(Robot.trolley);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("TROLLEY\t\t moving to minimum limit switch...");
        //OI.write("Trolley", "moving to minimum limit switch...");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.chassis.stop();
        if (Robot.oi.Paused) {
            Robot.trolley.stop();
        } else {
            Robot.trolley.left();
            //System.out.println(Robot.oi.joystick.getRawAxis(4));
            //System.out.println(Robot.tilt.AlignTrollyPWM());
            //Robot.chassis.forward(Robot.tilt.AlignTrollyPWM());
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.oi.trolleyminlimit.get();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.trolley.stop();
        System.out.println("TROLLEY\t\t triggered minimum limit switch.");
        //OI.write("Trolley", "triggered minimum limit switch");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.trolley.stop();
    }
}
