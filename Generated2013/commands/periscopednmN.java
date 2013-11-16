/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2811.Generated2013.OI;
import org.usfirst.frc2811.Generated2013.Robot;
import org.usfirst.frc2811.Generated2013.RobotMap;

/**
 *
 * @author Kelson
 */
public class periscopednmN extends Command {
    private boolean end;
    private boolean prev;
    private boolean cur;
    
    public periscopednmN() {
        // Use requires() here to declare subsystem dependencies
        
        requires(Robot.chassis);
        System.out.println("PERISCOPE TO MIN");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        prev = RobotMap.towersensor.get();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (OI.Paused){
            Robot.chassis.forward();
        } else {
           Robot.chassis.stop();
        }
        System.out.println("PERISCOPE TO MIN");
        cur = RobotMap.towersensor.get();
        if (prev != cur && cur == true){
            end = true;
        } else {
            end = false;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return end;
    }

    // Called once after isFinished returns true
    protected void end() {
  //      RobotMap.periscope.set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
     //   RobotMap.periscope.set(0.0);
    }
}
