/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.command;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.ElevatorPosition;
import frc.Robot;
import frc.subsystems.Elevator;

public class MoveElevator extends Command {
  private Elevator elevator;
  private ElevatorPosition position;
  
  public MoveElevator(ElevatorPosition position) {
   this.elevator=Robot.elevator;
   requires(elevator);
   this.position=position;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    elevator.stop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    elevator.setElevatiorHeight(position);
    elevator.setPower(1);
    System.out.println("Setting elevator height");

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
