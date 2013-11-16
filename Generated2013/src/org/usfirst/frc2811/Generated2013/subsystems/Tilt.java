/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2811.Generated2013.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.Joystick;
import java.util.Date;
import org.usfirst.frc2811.Generated2013.RobotMap;

/**
 *
 * @author mdf
 */
public class Tilt {
    ADXL345_I2C accelerometer = RobotMap.robotAccelerometer;
    public static double PITCHOFFSET = 0.0;
    public static double ALIGNANGLE = 68.0;
    public static double DEADZONE = 3.0;
    public static double prevX = 0;
    public static double prevY = 0;
    public static double prevZ = 0;
    public static double prevAngle=0;
    public static double Xcal = 0;
    public static double Ycal = 0;
    public static double Zcal = 0;
    

    public Tilt() {
       calibrate();   
    }
    
    //Using this class instead of Accelerometer as it provides access
    //to all three axis.
//    ADXL345_I2C accelerometer = RobotMap.trollyAccelerometer;

    //Retrieve the static force in mG (miliGs) for a given axis.
    public double getgAxis(ADXL345_I2C.Axes x) {
        double retVal=0;
        double initVal = accelerometer.getAcceleration(x);
        if (x.equals(ADXL345_I2C.Axes.kX)) {
           if (Double.isNaN(initVal)) {
               System.out.println("Xnan");
               retVal = prevX;
           }
           else {
               retVal = (((initVal-Xcal) + prevX)/2);
               prevX = retVal;
           }
        }
        else if (x.equals(ADXL345_I2C.Axes.kY)) {
           if (Double.isNaN(initVal)) {
               System.out.println("Ynan");
               retVal = prevY;
           }
           else {
               retVal = (((initVal-Ycal) + prevY)/2);
               prevY = retVal;
           }
        }
        else if (x.equals(ADXL345_I2C.Axes.kZ)) {
           if (Double.isNaN(initVal)) {
               System.out.println("Znan");
               retVal = prevZ;
           }
           else {
               retVal = (((initVal-Zcal) + prevZ)/2);
               prevZ = retVal;
           }
        }
        return retVal;
        
    }

    //Use the ATAN function and X,Y axis to computer relative angle,
    //using a moving average and lowpass filter to remove anomolous
    //readings.
    public double getAngle() {
        double retVal;
        double initVal;
        double xAng;
        double yAng;
        double zAng;
        xAng = getgAxis(ADXL345_I2C.Axes.kX);
        yAng = getgAxis(ADXL345_I2C.Axes.kY);
        zAng = getgAxis(ADXL345_I2C.Axes.kZ);
        double normalDeviation = Math.sqrt((xAng * xAng) + (yAng * yAng));
        //double normalDeviation = Math.abs(getgAxis(ADXL345_I2C.Axes.kX)) + Math.abs(getgAxis(ADXL345_I2C.Axes.kY));
        //if (Double.isNaN(normalDeviation)) System.out.println("sqrt");
        initVal = MathUtils.atan(normalDeviation / zAng);
        //if (Double.isNaN(initVal)) System.out.println("atan");
        
        //Discard negative angle values.
        if (initVal<0) {
            System.out.print("Neg ");
            retVal = prevAngle;
        }
        //Discard anomolous readings from any jarring.
        //else if (initVal>(prevAngle*2.0) && (!(prevAngle==0.0))) {
        else if (Math.abs(initVal-prevAngle)>.3) {
            System.out.print("Cutoff "+initVal+"/"+prevAngle);
            retVal = prevAngle;
        }
        else {
            //Return a moving average using the previous reading,
            //remembering to account for prevAngle==0.
            if (!(prevAngle==0)) {
                //System.out.print("Averaged ");
                retVal = (initVal+prevAngle)/2;
            }
            else {
                //System.out.print("Prev0 ");
                retVal = initVal;
            }
            prevAngle=retVal;

        }
        //System.out.println(retVal+"/"+prevAngle);
        return (retVal*180)/Math.PI;
    }

    public double getPWM(double targetAngle, double deadZone) {

        //Calculate distance to target angle
        double currentAngle = getAngle();
        double delta = targetAngle - currentAngle;
        double pwm = 0;

        //Account for a deadzone to avoid oscillating and use
        //a linear power curve for PWM signal to deccelerate
        //when approaching the target angle.
        if (Math.abs(delta) > deadZone) {
            pwm = (1 / targetAngle) * delta;
        } else {
            pwm = 0;
        }
        return pwm;
    }

    //Take calibration readings for 2 seconds (300 at 150Hz) to
    //set offset calibration offset variables.
    public void calibrate() {
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;
        long counter = 0;
        double xAng=0;
        double yAng=0;
        double zAng=0;

        while (elapsedTime < 3*1000) {
            xAng += getgAxis(ADXL345_I2C.Axes.kX);
            yAng += getgAxis(ADXL345_I2C.Axes.kY);
            zAng += getgAxis(ADXL345_I2C.Axes.kZ);
            ++counter;
            elapsedTime = (new Date()).getTime() - startTime;
        }
        Xcal = xAng / (double) counter;
        Ycal = yAng / (double) counter;
        Zcal = 1-(zAng / (double) counter);
        System.out.println("Calibration Complete ("+counter+"): "+Xcal+"/"+Ycal+"/"+Zcal);
        
    }
}
