package org.usfirst.frc.team4239.robot.commands;

import org.usfirst.frc.team4239.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftHoldEncoder extends Command {
	int initial;
    public LiftHoldEncoder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initial = Robot.lift.getEncoder().get();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.lift.getEncoder().get() >= initial && 20 < Math.abs(initial - Robot.lift.getEncoder().get())){
    		Robot.lift.liftSet(0.2);
    	}else{
    		Robot.lift.liftSet(-0.1);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.lift.getUp() || Robot.lift.getDown();
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
