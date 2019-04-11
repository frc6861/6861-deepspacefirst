/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;

public class MoveClimber extends Command {
    private double speed;
    private DriveTrain driveTrain;
    private OI oi;
    private Climber climber;

    public MoveClimber(OI m_oi, double speed, Climber climber) {
        this.oi = m_oi;
        this.speed = speed;
        this.climber = climber;
    }
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        //System.out.print("Initializing Drive Command");
        climber.climb(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        climber.climb(speed);
        // System.out.println("Driving!!!");
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        //climber.climb(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}