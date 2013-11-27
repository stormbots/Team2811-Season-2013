/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.ADXL345_I2C;

/**
 *
 * @author mdf
 */
public class Tilt {
    public static ADXL345_I2C trollyAccelerometer;
    public static double PITCHOFFSET = 0.0;
    public static double ALIGNANGLE = 68.0;
    public static double DEADZONE = 3.0;

    public Tilt() {
        trollyAccelerometer = new ADXL345_I2C(1, ADXL345_I2C.DataFormat_Range.k2G);   
    }
    //Using this class instead of Accelerometer as it provides access
    //to all three axis.
//    ADXL345_I2C accelerometer = RobotMap.trollyAccelerometer;

    //Retrieve the static force in mG (miliGs) for a given axis.
    private double getgAxis(ADXL345_I2C.Axes x) {
        return trollyAccelerometer.getAcceleration(x);
    }
    
    //Use the ATAN function and X,Y axis to computer relative angle
    private double getAngle() {
            double normal= Math.sqrt(((getgAxis(ADXL345_I2C.Axes.kX))*(getgAxis(ADXL345_I2C.Axes.kX)))+((getgAxis(ADXL345_I2C.Axes.kY))*(getgAxis(ADXL345_I2C.Axes.kY))));

        return MathUtils.atan(normal / getgAxis(ADXL345_I2C.Axes.kZ));
    }
    
    public double AlignTrollyPWM() {
        int var = 3;
        //Calculate distance to target angle
            double currentAngle = getAngle()*100;
        double delta = ALIGNANGLE - (currentAngle);
        double pwm = 0;
        
        //Account for a deadzone to avoid oscillating
        //and use a linear power curve for PWM signal
        if (Math.abs(delta)>DEADZONE) {
            pwm = (1/ALIGNANGLE)*delta;
        } else {
            pwm=0;
        }
        System.out.println("CA:"+currentAngle + " PWM:"+pwm);
        return pwm;
    }
}
