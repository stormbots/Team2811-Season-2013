// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


package org.usfirst.frc2811.Generated2013.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2811.Generated2013.RobotMap;


/**
 *
 */
public class Periscope extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
    }
    
    public void stop() {
        RobotMap.periscope.set(0.0);
    }
    
    public void up() {
        RobotMap.periscope.set(-0.5);
    }
    
    public void down() {
        RobotMap.periscope.set(0.5);
    }
    
    // From here down we find a set of low level methods designed to control
    // atomic chassis actions.  Typically these will be just one or two lines
    // that activate some motor or other in this subsystem.
    // These might involve limit switches if extents cannot be exceeded.
        
}

