/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Climber;

public class RunClimbMotor extends Command {
    private double speed;
    private Climber climber;

    public RunClimbMotor(Climber climber,double speed) {
        this.climber = climber;

        //System.out.println("MESSAGE   " + ingestor.toString());
        requires(climber);
        this.speed = speed;


    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        climber.climb(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        climber.climb(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        //ingestor.driveMotors(0);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
