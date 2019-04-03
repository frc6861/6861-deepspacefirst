/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrain;

public class Drive extends Command {
  private DriveTrain driveTrain;
  private OI oi;


  public Drive(OI m_oi,DriveTrain driveTrain) {
    this.oi=m_oi;
    this.driveTrain=driveTrain;
     requires(driveTrain);
    }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.print("Initializing Drive Command");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    driveTrain.setMecanumDriveCommand(oi.getGamePad1().getRawAxis(0), -oi.getGamePad1().getRawAxis(1), oi.getGamePad1().getRawAxis(4), 0);
    //System.out.println("Driving!!!");
  }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
