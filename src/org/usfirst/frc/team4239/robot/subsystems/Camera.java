package org.usfirst.frc.team4239.robot.subsystems;

import org.usfirst.frc.team4239.robot.Robot;
import org.usfirst.frc.team4239.robot.RobotMap;
import org.usfirst.frc.team4239.robot.commands.ControlCamera;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
    
    // Put methods for controlling this subsystem
    Talon cameraTalon = new Talon(RobotMap.cameraMotor);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ControlCamera());
    }
    
    public void controlCamera(){
    	
    	if(Math.abs(Robot.oi.joystick.getX()) > 0.2){
    		cameraTalon.set(-Robot.oi.joystick.getX()*0.3);
    	}
    }
}

