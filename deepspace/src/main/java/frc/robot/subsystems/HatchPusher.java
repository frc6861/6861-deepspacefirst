/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class HatchPusher extends Subsystem {
  private WPI_TalonSRX hatchMotor;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public HatchPusher(){
    //practice
   // hatchMotor = new WPI_TalonSRX(3);
   //competition
    hatchMotor = new WPI_TalonSRX(13);
    hatchMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void driveHatch(double speed){
    hatchMotor.set(speed);

 }
}
