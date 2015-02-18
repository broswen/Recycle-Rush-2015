package org.usfirst.frc.team4239.robot.commands;

import org.usfirst.frc.team4239.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftUpSlow extends Command {

    public LiftUpSlow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

 // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.lift.getUp()){
    		Robot.lift.liftSet(0.3);;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.lift.getUp();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.liftStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
