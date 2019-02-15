/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsytems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
enum DeployPosition{
BALLCARGOSHIP(80),HATCHROCKETANDCARGOSHIP(48),BALLLOWROCKETSHIP(70),HATCHMIDROCKETSHIP(119),BALLMIDROCKETSHIP(141),
  HATCHROCKETSHIP(190),BALLTOPROCKETSHIP(212);
  private int position;
  public int getPosition(){
    return position;
  }
  DeployPosition(int position){
    this.position=position;
  }

}




// private int ballCargoShip = 80; //80 cm from carpet
//   private int hatchRocketandCargoShip = 48; //48 cm from carpet default bottom height
//   private int ballLowRocketShip = 70; //70 cm from carpet
//   private int hatchMidRocketShip = 119; //119 cm from carpet
//   private int ballMidRocketShip = 141; //141 cm from carpet
//   private int hatchTopRocketShip = 190; //190 cm from carpet
//   private int ballTopRocketShip = 212; //212 cm from carpet


