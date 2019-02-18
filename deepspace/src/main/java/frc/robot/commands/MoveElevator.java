/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Elevator;

public class MoveElevator extends Command {
  private Elevator elevator;
  private String button;
    
  public MoveElevator(Elevator elevator, String buttonNumber) {
   this.elevator=elevator;
   requires(elevator);
   this.button=buttonNumber;
   
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    elevator.stop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(button.equals("1"))
      elevator.setPower(-0.1);
    else if(button.equals("2"))
      elevator.setPower(0.1);
    else
      elevator.setPower(0);
    

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
