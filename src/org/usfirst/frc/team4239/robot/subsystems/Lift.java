package org.usfirst.frc.team4239.robot.subsystems;

import org.usfirst.frc.team4239.robot.RobotMap;
import org.usfirst.frc.team4239.robot.commands.DoNothing;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Talon liftTalon = new Talon(RobotMap.liftMotor);
	DigitalInput topSwitch = new DigitalInput(2);
	DigitalInput bottomSwitch = new DigitalInput(3);
	Encoder encoder = new Encoder(0,1);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(	new MySpecialCommand());
    	setDefaultCommand(new DoNothing());
    }
    
    public Encoder getEncoder(){
    	return encoder;
    }
    
    public void invertEncoder(){
    	encoder.setReverseDirection(true);
    }
    
    public void liftUp(){
    	liftTalon.set(0.6);
    }
    
    public void liftSet(double speed){
    	liftTalon.set(speed);
    }
    
    public void liftDown(){
    	liftTalon.set(-0.6);
    }
    
    public void doNothing(){
    	liftTalon.set(0.0);
    }
    
    public void liftStop(){
    	liftTalon.stopMotor();
    }
    
    public void liftHold(){
    	liftTalon.set(0.3);
    }
    
    public boolean getUp(){
    	return topSwitch.get();
    }
    
    public boolean getDown(){
    	return bottomSwitch.get();
    }
}

