/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.command;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GenericHID;
import frc.subsytems.DriveTrain;

public class Drive extends Command {
  private DriveTrain driveTrain;
  private XboxController gamePad;

  public Drive(DriveTrain driveTrain,XboxController gamePad) {
    this.driveTrain=driveTrain;
    this.gamePad = gamePad;
    requires(driveTrain);
    
    
    }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    driveTrain.setMecanumDriveCommand(gamePad.getX(GenericHID.Hand.kLeft), -0.75*gamePad.getY(GenericHID.Hand.kLeft), 0.5*gamePad.getX(GenericHID.Hand.kRight), 0);
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
