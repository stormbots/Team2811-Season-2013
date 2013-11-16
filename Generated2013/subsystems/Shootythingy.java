/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2811.Generated2013.OI;
import org.usfirst.frc2811.Generated2013.Robot;
import org.usfirst.frc2811.Generated2013.RobotMap;

/**
 *
 * @author Kelson
 */
public class Shootythingy extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    SpeedController shoot = RobotMap.spin1;
    SpeedController score = RobotMap.spin2;
    Solenoid piston = RobotMap.pusher;
    Solenoid flipper = RobotMap.flipper;
    double Speed = 0;
    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void shootPush(boolean value){
        if (!RobotMap.flipping && !RobotMap.backwards) {
            piston.set(value);
        } else {
            piston.set(false);
        }
    }
    public void setSpeed(double value){
        shoot.set(value); 
        score.set(value);    
    }
    public void flipActivate(boolean value){
        if (RobotMap.shooting && !RobotMap.backwards) {
            flipper.set(false);
        } else {
            flipper.set(value);
        }
    }
    public void useflap(Joystick a) {
        if (!RobotMap.backwards && RobotMap.Teleop){
            Robot.shootythingy.setSpeed((-(a.getRawAxis(4)-1)/(RobotMap.rangeSpeed)+RobotMap.minSpeed));
            System.out.println("backwards is "+RobotMap.backwards+"");
        } else {
            System.out.println("NOT ABLE TO USE FLAP");
        }
    }
}
