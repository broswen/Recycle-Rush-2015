package org.usfirst.frc.team4239.robot.commands;

import org.usfirst.frc.team4239.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ForwardTimeSpeed extends Command {
	double time1, speed1;
	
    public ForwardTimeSpeed(double time, double speed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
        time1 = time;
        speed1 = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.forward(speed1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
