package org.usfirst.frc.team4239.robot.subsystems;

import org.usfirst.frc.team4239.robot.Robot;
import org.usfirst.frc.team4239.robot.RobotMap;
import org.usfirst.frc.team4239.robot.commands.MecanumDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Chassis extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon frontLeftTalon = new Talon(RobotMap.frontLeftMotor);
	Talon frontRightTalon = new Talon(RobotMap.frontRightMotor);
	Talon backRightTalon = new Talon(RobotMap.backRightMotor);
	Talon backLeftTalon = new Talon(RobotMap.backLeftMotor);
	RobotDrive drive = new RobotDrive(frontLeftTalon, backLeftTalon, frontRightTalon, backRightTalon);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new MecanumDrive());
    }
       
    public void mecanumDrive(){
    	drive.setInvertedMotor(MotorType.kFrontRight, true);
    	drive.setInvertedMotor(MotorType.kRearRight, true);
    	
    	drive.mecanumDrive_Cartesian(Robot.oi.threedjoystick.getX()*Robot.sensitivity, Robot.oi.threedjoystick.getY()*Robot.sensitivity,Robot.oi.threedjoystick.getTwist()*0.5, 0);
    	
    	//fourDrive.mecanumDrive_Polar(Robot.oi.controller.getMagnitude()/3, Robot.oi.controller.getDirectionDegrees()/3, Robot.oi.controller.getTwist()/3);
    }
    
    public void mecanumDriveSlow(){
    	drive.setInvertedMotor(MotorType.kFrontRight, true);
    	drive.setInvertedMotor(MotorType.kRearRight, true);
    	
    	drive.mecanumDrive_Cartesian(Robot.oi.threedjoystick.getX()*0.3, Robot.oi.threedjoystick.getY()*0.3,Robot.oi.threedjoystick.getTwist()/3, 0);
    	
    	//fourDrive.mecanumDrive_Polar(Robot.oi.controller.getMagnitude()/3, Robot.oi.controller.getDirectionDegrees()/3, Robot.oi.controller.getTwist()/3);
    }
    
    public void strafeRight(){
    	frontLeftTalon.set(1.0*Robot.sensitivity);
    	backLeftTalon.set(-1.0*Robot.sensitivity);
    	frontRightTalon.set(1.0*Robot.sensitivity);
    	backRightTalon.set(-1.0*Robot.sensitivity);
    }
    
    public void forward(double speed){
    	frontLeftTalon.set(speed);
    	backLeftTalon.set(speed);
    	frontRightTalon.set(-speed);
    	backRightTalon.set(-speed);
    }
    
    public void backward(double speed){
    	frontLeftTalon.set(-speed);
    	backLeftTalon.set(-speed);
    	frontRightTalon.set(speed);
    	backRightTalon.set(speed);
    }
    
    public void rotateLeft(double speed){
    	frontLeftTalon.set(-speed);
    	backLeftTalon.set(-speed);
    	frontRightTalon.set(-speed);
    	backRightTalon.set(-speed);
    }
    
    public void rotateRight(double speed){
    	frontLeftTalon.set(speed);
    	backLeftTalon.set(speed);
    	frontRightTalon.set(speed);
    	backRightTalon.set(speed);
    }
    
    public void strafeLeft(){
    	frontLeftTalon.set(-1.0*Robot.sensitivity);
    	backLeftTalon.set(1.0*Robot.sensitivity);
    	frontRightTalon.set(-1.0*Robot.sensitivity);
    	backRightTalon.set(1.0*Robot.sensitivity);
    }
}

