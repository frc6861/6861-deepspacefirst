/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.ElevatorPosition;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;

public class MoveElevator extends Command {
  private Elevator elevator;
  private OI oi;
    
  public MoveElevator(OI oi) {
   this.elevator=Robot.elevator;
   requires(elevator);
   this.oi=oi;

   
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    elevator.stop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    if(oi.getButtonClickLeft2()){
      //System.out.println("Moving Elevator---- ButtonClickLeft2");
      elevator.setPower(-0.3);
    
    }
    else if(oi.getButtonClickRight2()){
     // System.out.println("Moving Elevator---- ButtonClickRight2");
      elevator.setPower(0.3);
    }
    else{
      //System.out.println("Stopping Elevator---- No Button press detected.");
      elevator.setPower(0);
    }
      
    

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
