
package org.usfirst.frc.team4239.robot;

import org.usfirst.frc.team4239.robot.commands.Autonomous1;
import org.usfirst.frc.team4239.robot.commands.Autonomous12;
import org.usfirst.frc.team4239.robot.commands.Autonomous2;
import org.usfirst.frc.team4239.robot.commands.Autonomous4;
import org.usfirst.frc.team4239.robot.subsystems.Camera;
import org.usfirst.frc.team4239.robot.subsystems.Chassis;
import org.usfirst.frc.team4239.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team4239.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final Chassis chassis = new Chassis();
	public static final Lift lift = new Lift();
	public static final Camera camera = new Camera();
	public static OI oi;
	public static double sensitivity = 0.5;
	CameraServer server;
	
	Command autonomousCommand;
	SendableChooser autoChooser;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        
        //set up camera
        server = CameraServer.getInstance();
        server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam1");
    
        //set up autonomous
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Auto1", new Autonomous1());
        autoChooser.addObject("Auto12", new Autonomous12());
        autoChooser.addObject("Auto2", new Autonomous2());
        autoChooser.addObject("Auto4", new Autonomous4());
        SmartDashboard.putData("Auto Chooser", autoChooser);      
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	autonomousCommand = (Command) autoChooser.getSelected();
    	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
      //driving info
        SmartDashboard.putNumber("RX: ", Robot.oi.threedjoystick.getX());
    	SmartDashboard.putNumber("RY: ", Robot.oi.threedjoystick.getY());
    	SmartDashboard.putNumber("RZ: ", Robot.oi.threedjoystick.getTwist());
    	SmartDashboard.putNumber("Mag: ", Robot.oi.threedjoystick.getMagnitude());
    	SmartDashboard.putNumber("DirDeg: ", Robot.oi.threedjoystick.getDirectionDegrees());
    	SmartDashboard.putDouble("Sensitivity", Robot.sensitivity);
    	SmartDashboard.putData("Chassis", Robot.chassis);
    	
    	SmartDashboard.putBoolean("TopSwitch", Robot.lift.getUp());
    	SmartDashboard.putBoolean("BottomSwitch", Robot.lift.getDown());
    	SmartDashboard.putNumber("Encoder", Robot.lift.getEncoder().get());
    	SmartDashboard.putData("Lift", Robot.lift);
    	
    	SmartDashboard.putData("Camera", Robot.camera);
    	SmartDashboard.putNumber("LX", Robot.oi.joystick.getX());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
