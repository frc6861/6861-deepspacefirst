/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.auton;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.subsystems.DriveTrain;

/**
 * Add your docs here.
 */
public class CargoMiddleHatch extends TimedCommand {
  private DriveTrain driveTrain;

  public CargoMiddleHatch(double timeout,DriveTrain driveTrain) {
    super(timeout);
   	this.driveTrain=driveTrain;
    requires(driveTrain);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("Auton");
    driveTrain.setMecanumDriveCommand(0, 0.25, 0, 0);

  }

  // Called once after timeout
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
  protected boolean isFinished() {
    return isTimedOut();
    // boolean flag=(!driveTrain.getM_oi().getLeftProximitySensor().get() && !driveTrain.getM_oi().getRightProximitySensor().get());
    // if(!flag)
    //     System.out.println("*******************************************"+flag);
    // return flag;
  }
}
