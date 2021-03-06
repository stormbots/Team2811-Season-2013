// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


package org.usfirst.frc2811.Generated2013;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2811.Generated2013.commands.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick joystick;
    public Joystick tower;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private JoystickButton trigger;
    private JoystickButton tophat;
    
    private JoystickButton puase;
    private JoystickButton tgldrv;
    
    private JoystickButton test1;
    private JoystickButton test2;
    private JoystickButton test3;
    private JoystickButton test4;
    
    public JoystickButton trolleyminlimit;
    public JoystickButton trolleyhome;
    public JoystickButton trolleymaxlimit;
    public JoystickButton trolleyangle;
    
    public JoystickButton periminlimit;
    public JoystickButton perimaxlimit;
    
    public JoystickButton periclawclosed;
    public JoystickButton periclawactivated;
    public JoystickButton holdclawclosed;
    public JoystickButton holdclawactivated;
    
    public boolean Paused = true;
    
    public OI() {
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Teleop Command", new TeleopCommand());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        joystick = new Joystick(1);
        trigger = new JoystickButton(joystick, 3);
        trigger.whenPressed(new DriveInASquare());
        tophat = new JoystickButton(joystick, 1);
        tophat.whenPressed(new ClimbTower());
        
        puase = new JoystickButton(joystick,4);
        puase.whenPressed(new togglePause());
        tgldrv = new JoystickButton(joystick, 7);
        tgldrv.whenPressed(new ToggleGear());
        

      /*  
        test1 = new JoystickButton(joystick, 5);
        test1.whenPressed(new TroClawClose());
        test2 = new JoystickButton(joystick, 6);
        test2.whenPressed(new TroClawOpen());
        test3 = new JoystickButton(joystick, 7);
        test3.whenPressed(new PeriClawClose());
        test4 = new JoystickButton(joystick, 8);
        test4.whenPressed(new PeriClawOpen());
        */
        
        
        tower = new Joystick(2);
        trolleyminlimit = new JoystickButton(tower, 4);
        trolleyhome = new JoystickButton(tower, 8);
        trolleymaxlimit = new JoystickButton(tower, 5);
        trolleyangle = new JoystickButton(tower, 12);
    
        periminlimit  = new JoystickButton(tower, 2);
        perimaxlimit  = new JoystickButton(tower, 3);
    
        periclawactivated  = new JoystickButton(tower, 10);
        periclawclosed = new JoystickButton(tower, 11);
        holdclawactivated  = new JoystickButton(tower, 7);
        holdclawclosed  = new JoystickButton(tower, 6);
        
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick;
    }

    public Joystick getJoystick2() {
        return tower;
    }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

