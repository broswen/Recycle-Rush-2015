package org.usfirst.frc.team4239.robot;

import org.usfirst.frc.team4239.robot.commands.DecreaseSensitivity;
import org.usfirst.frc.team4239.robot.commands.FourthTote;
import org.usfirst.frc.team4239.robot.commands.LiftDown;
import org.usfirst.frc.team4239.robot.commands.LiftHoldEncoder;
import org.usfirst.frc.team4239.robot.commands.LiftUp;
import org.usfirst.frc.team4239.robot.commands.LiftUpSlow;
import org.usfirst.frc.team4239.robot.commands.MecanumDriveSlow;
import org.usfirst.frc.team4239.robot.commands.ResetEncoder;
import org.usfirst.frc.team4239.robot.commands.SecondTote;
import org.usfirst.frc.team4239.robot.commands.SensitivityIncrease;
import org.usfirst.frc.team4239.robot.commands.StrafeLeft;
import org.usfirst.frc.team4239.robot.commands.StrafeRight;
import org.usfirst.frc.team4239.robot.commands.ThirdTote;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
	
	public Joystick threedjoystick = new Joystick(0);
	public Joystick joystick = new Joystick(1);
	
	public OI(){
		JoystickButton button3 = new JoystickButton(joystick, 3);
		JoystickButton button6 = new JoystickButton(joystick, 6);
		JoystickButton button7 = new JoystickButton(joystick, 7);
		JoystickButton button8 = new JoystickButton(joystick, 8);
		JoystickButton button9 = new JoystickButton(joystick, 9);
		JoystickButton button2 = new JoystickButton(joystick, 2);
		JoystickButton button11 = new JoystickButton(joystick, 11);
		JoystickButton button10 = new JoystickButton(joystick, 10);
		
		JoystickButton button3d7 = new JoystickButton(threedjoystick, 7);
		JoystickButton button3d8 = new JoystickButton(threedjoystick, 8);
		JoystickButton button3d5 = new JoystickButton(threedjoystick, 5);
		JoystickButton button3d6 = new JoystickButton(threedjoystick, 6);
		JoystickButton button1 = new JoystickButton(threedjoystick, 1);

		button3d6.whileHeld(new StrafeRight());
		button3d5.whileHeld(new StrafeLeft());
		button3d7.whenPressed(new DecreaseSensitivity());
		button3d8.whenPressed(new SensitivityIncrease());
		button2.whileHeld(new LiftDown());
		button3.whileHeld(new LiftUp());
		button11.whileHeld(new LiftUpSlow());
		button10.whileHeld(new LiftHoldEncoder());
		button9.whenPressed(new ResetEncoder());
		button6.whenPressed(new FourthTote());
		button7.whenPressed(new ThirdTote());
		button8.whenPressed(new SecondTote());
		button1.whileHeld(new MecanumDriveSlow());
	}
}

