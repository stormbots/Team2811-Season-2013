/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;
import org.usfirst.frc2811.Generated2013.RobotMap;

/**
 *
 * @author Driver
 */


public class ClimbTower extends CommandGroup {
  private boolean hasfinished = false;
    
    public ClimbTower() {
        if (hasfinished) {return;}//security measures
        
        addSequential(new gearchange(false));
        addParallel(new print("observed"));//System.out.println(); does not work on commandgroup
        addSequential(new PeriClawOpen());
        addSequential(new TroClawOpen());
        addParallel(new print("goingup"));
        addSequential(new periscopeup());
        addParallel(new print("did something"));
        if (RobotMap.periscopePerMax.get()) {//! not working
            addParallel(new print("missed bar"));
            addSequential(new periscopednmN());
            addSequential(new gearchange(true));
            return;
        } else {
            addParallel(new print("got the bar, closing claw"));
            addSequential(new PeriClawClose());
            //check
        }
        for (int i = 0;i<2;i++) {
            addParallel(new print("trolley claws open, and iteration is "+i));
            addSequential(new TroClawOpen());
            //check
            addParallel(new print("trolley claws open"));
            addSequential(new TroAft());//alternatively, TroMeet()
            addSequential(new WaitForChildren());
            addParallel(new print("we're ready, peri"));
            addSequential(new periscopednmT());
            addParallel(new print("both in position"));
            addSequential(new TroClawClose());
            //check
            addParallel(new print("3 claws on bar"));
            addSequential(new PeriClawOpen());
            //check
            addParallel(new print("peri let go"));
            addSequential(new periscopednmN());
            addParallel(new print("peri has retreated"));
            addSequential(new Travel());
            addParallel(new print("Gyro at correct angle"));    
            //now raise the thing
            addSequential(new PeriClawOpen());
            addParallel(new print("goingup"));
            addSequential(new periscopeup());
            addParallel(new print("did something"));
            if (RobotMap.periscopePerMax.get()) {//! not working
            addParallel(new print("missed bar"));
            addSequential(new periscopednmN());
                //re-aim somehow?
                return;
            } else {
                addParallel(new print("got the bar, closing claw"));
                addSequential(new PeriClawClose());
                //check
            }
            addSequential(new WaitForChildren());
            addSequential(new TroFore());//this is the leveling thing we wanted
            addSequential(new WaitForChildren());
            addParallel(new print("robot is level now"));
       }
        addParallel(new print("trolley claws open"));
        addSequential(new TroClawOpen());
        //check
        addParallel(new print("trolley claws open"));
        addSequential(new WaitForChildren());
        addSequential(new TroAft());//alternatively, TroMeet()
        addSequential(new WaitForChildren());
        addParallel(new print("we're ready, peri"));
        addSequential(new periscopednmT());
        addParallel(new print("both in position"));
        addSequential(new TroClawClose());
        //check
         addParallel(new print("3 claws on bar"));
         addParallel(new print("WE MADE IT BOYS!!!!!!"));
         hasfinished = true;
         //addSequential(new victory());
         
         
         //this is it boys!
        
        
        
        
        
        
        
        
        
        
        
        
    /*    // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        
        addSequential(new ShiftToClimb());
        addParallel(new TrolleyToHome()); //if parallel, would run at the same time as PeriToHome
        addSequential(new PeriToMinLimit());
        addSequential(new PeriToClawActuator());
//        addSequential(new ClosePeriscopeClaw());
        addSequential(new WaitForChildren());
//        addSequential(new RetractPeriscope());
//        addSequential(new CloseHoldingClaw());
//        //stop if hold failed
//        addSequential(new OpenPeriscopeClaw());
//        addSequential(new MoveTolleyToAngle());
//        addSequential(new ExtendPeriscopeClaw());
//        addSequential(new ClosePeriscopeClaw());
//        addSequential(new MoveTrolleyToMax());
//        //only if peri claw closed
//        addSequential(new OpenHoldingClaw());
//        addSequential(new HoldingClawToHome())
//        addSequential(new RetractPeriscope());
//        addSequential(new CloseHoldingClaw());
//        //stop if hold failed
//        addSequential(new OpenPeriscopeClaw());
//        addSequential(new MoveTolleyToAngle());
//        addSequential(new ExtendPeriscopeClaw());
//        addSequential(new ClosePeriscopeClaw());
//        addSequential(new MoveTrolleyToMax());
//        //only if peri claw closed
//        addSequential(new OpenHoldingClaw());
//        addSequential(new HoldingClawToHome());
//        addSequential(new RetractPeriscope());
//        addSequential(new CloseHoldingClaw());
*/
    }
    
}
