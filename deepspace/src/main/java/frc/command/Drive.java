/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.command;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Controller;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import frc.OI;
import frc.subsystems.DriveTrain;

public class Drive extends Command {
  private DriveTrain driveTrain;
  private Joystick gamePad;
  private OI m_oi;


  public Drive(OI m_oi,DriveTrain driveTrain) {
    this.m_oi=m_oi;
    this.driveTrain=driveTrain;
    gamePad = new Joystick(0);
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
    //driveTrain.setMecanumDriveCommand(gamePad.getRawAxis(0), -0.75*gamePad.getRawAxis(1), 0.5*gamePad.getRawAxis(4), 0);
    driveTrain.setMecanumDriveCommand(1, 0, 0, 0);
    System.out.println("Driving!!!");
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
