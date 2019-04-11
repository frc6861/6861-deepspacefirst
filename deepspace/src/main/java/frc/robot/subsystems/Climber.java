/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//NOTE: THIS IS BASIC CODE FOR A CLIMBER, IF THIS GETS PUSHED CHECK WITH JACK BEFORE DELETING OTHERWISE ANGER WILL ENSURE ;)
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Spark climbMotor;
  //private DoubleSolenoid climbSolenoid=new DoubleSolenoid(6, 7);

  public Climber() {
      climbMotor = new Spark(0); 
  }
  
  @Override
  public void initDefaultCommand() {
    climbMotor.set(0);
    //retractClimb();
  }

  // public void extendClimb(){
  //     climbSolenoid.set(DoubleSolenoid.Value.kForward);
  // }

  // public void retractClimb(){
  //     climbSolenoid.set(DoubleSolenoid.Value.kReverse);
  // }

  public void climb(double speed) {
    climbMotor.set(speed); 
  }
}
