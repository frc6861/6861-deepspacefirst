/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.commands.MoveElevator;
import frc.robot.ElevatorPosition;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  
  private Double desiredHeight;
  private WPI_TalonSRX elevatorMotor;
  public double currentPower;
  private OI oi;
 

  public Elevator(OI oi){
    
    elevatorMotor = new WPI_TalonSRX(23);
    //encoder = new Encoder(1, 2, false, EncodingType.k4X);
    //encoder.reset();
    this.oi = oi;
    //setPower(0.0);
    
  }

  

    /**
     * @return the currentPower
     */
    public double getCurrentPower() {
        return currentPower;
    }

    /**
     * @param currentPower the currentPower to set
     */
    public void setCurrentPower(double currentPower) {
        this.currentPower = currentPower;
    }

    @Override
  public void initDefaultCommand() {
      setPower(0.0);
    

  }
  public void setElevatiorHeight(ElevatorPosition position){
    desiredHeight=position.getPosition();
    //setPowerWithEncoders(0.2);
  }
  public void stop() {
    System.out.println("Elevator.java : stop method power=0");
		setPower(0.0);
  }

 /* private double safetyCheck(double power) {
		power = Math.min(1.0, power);
		power = Math.max(-1.0, power);
		System.out.println("SWITCHES: " + Robot.topLimitSwitch.get() + "  " + Robot.bottomLimitSwitch.get());
		 if((!Robot.topLimitSwitch.get() && power > 0) || (!Robot.bottomLimitSwitch.get() && power < 0)) {
             
		    return 0.0; 
		 } 
		else { 
			return power; 
		}
	}*/
  public double getElevatorHeight(){
    
    return -elevatorMotor.getSensorCollection().getQuadraturePosition();

    //return 0;
        //elevatorMotor.get * (2 * Math.PI) / 21;
        // Pulley has a 1 inch radius and 2 pi circumfrence
        // The gearbox has a ratio of 21:1
        // Therefore to go from encoders to elevator height we multiply by 2pi and
        // divide by 21

  }

  public void setPower(double power) {
    // double difference;
    //power = safetyCheck(power);
    // difference=getElevatorHeight()-desiredHeight;
    //  if(Math.abs(difference-1.0) <= 0.000001)
    //    elevatorMotor.set(0);
    //  else
    //    elevatorMotor.set(power);
    currentPower = power;
    //System.out.println(currentPower);
    elevatorMotor.set(power);
  }
  /*public void setPowerWithEncoders(double power) {
     double difference;
		 power = safetyCheck(power);
     difference=encoder.getDistance()-desiredHeight;
     if(Math.abs(difference-1.0) <= 0.000001)
        elevatorMotor.set(0);
     else
        elevatorMotor.set(power);
     elevatorMotor.set(power);
    }*/
    
}





// private int ballCargoShip = 80; //80 cm from carpet
//   private int hatchRocketandCargoShip = 48; //48 cm from carpet default bottom height
//   private int ballLowRocketShip = 70; //70 cm from carpet
//   private int hatchMidRocketShip = 119; //119 cm from carpet
//   private int ballMidRocketShip = 141; //141 cm from carpet
//   private int hatchTopRocketShip = 190; //190 cm from carpet
//   private int ballTopRocketShip = 212; //212 cm from carpet


