/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.command.MoveElevator;
import frc.robot.ElevatorPosition;
import frc.robot.OI;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  
  private Double currentHeight;
  private WPI_TalonSRX elevatorMotor;
  private DigitalInput bottonLimitSwitch = new DigitalInput(1);
  
 

  public Elevator(){
    
    elevatorMotor = new WPI_TalonSRX(1);
    
  }
  @Override
  public void initDefaultCommand() {
    currentHeight=(ElevatorPosition.HATCHROCKETANDCARGOSHIP).getPosition();
    setDefaultCommand(new MoveElevator(ElevatorPosition.HATCHROCKETANDCARGOSHIP));
    
  }
  public void setElevatiorHeight(ElevatorPosition position){
    currentHeight=position.getPosition();
  }
  public void stop() {
		setPower(0.0);
  }

  private double safetyCheck(double power) {
		power = Math.min(1.0, power);
		power = Math.max(-1.0, power);
		
		 if((!bottonLimitSwitch.get() && power > 0)) {
		    return 0.0; 
		 } 
		else { 
			return power; 
		}
	}
  private double getElevatorHeight(){
    return elevatorMotor.getEncPosition().getPosition() * (2 * Math.PI) / 21;
        // Pulley has a 1 inch radius and 2 pi circumfrence
        // The gearbox has a ratio of 21:1
        // Therefore to go from encoders to elevator height we multiply by 2pi and
        // divide by 21

  }

  public void setPower(double power) {
    double difference;
		power = safetyCheck(power);
    difference=getElevatorHeight()-currentHeight;
    if(Math.abs(difference-1.0) <= 0.000001)
      elevatorMotor.set(0);
    else
		  elevatorMotor.set(power);
	}
}





// private int ballCargoShip = 80; //80 cm from carpet
//   private int hatchRocketandCargoShip = 48; //48 cm from carpet default bottom height
//   private int ballLowRocketShip = 70; //70 cm from carpet
//   private int hatchMidRocketShip = 119; //119 cm from carpet
//   private int ballMidRocketShip = 141; //141 cm from carpet
//   private int hatchTopRocketShip = 190; //190 cm from carpet
//   private int ballTopRocketShip = 212; //212 cm from carpet


