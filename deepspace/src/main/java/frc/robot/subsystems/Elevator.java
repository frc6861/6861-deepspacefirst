/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
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

    public WPI_TalonSRX elevatorMotor;
    public double currentPower;
    

    public Elevator() {
       
        elevatorMotor = new WPI_TalonSRX(23);
        elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);//NOTE: Encoder returns a value reverse of what it should be! Put a - before
        elevatorMotor.setSensorPhase(true);//                                   any readings from it!
        elevatorMotor.setInverted(false);
        
    }

    
    public double getCurrentPower() {
        return this.currentPower;
    }

    @Override
    public void initDefaultCommand() {
        setPower(0.0);

    }

    public void setElevatiorHeight(double position) {
        elevatorMotor.set(ControlMode.Position, position);
        
    }

    public void stop() {
        System.out.println("Elevator.java : stop method power=0");
        setPower(0.0);
    }

    
    public double getElevatorHeight() {

        return -elevatorMotor.getSensorCollection().getQuadraturePosition();

        
    }

    public void setPower(double power) {
        elevatorMotor.set(power);
    }

    public void setCurrentPower(double powVal) {
        this.currentPower = powVal;
    }

    

}

