/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsytems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.command.Drive;
import frc.robot.OI;


public class DriveTrain extends Subsystem {
  private WPI_TalonSRX leftFront; 
	private WPI_TalonSRX rightFront;
	private WPI_TalonSRX leftRear;
	private WPI_TalonSRX rightRear;
  private MecanumDrive mecanumDrive;
  private XboxController gamePad;


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive(this,gamePad));
  }
  public DriveTrain(OI m_oi) {
    leftFront = new WPI_TalonSRX(0);
    rightFront = new WPI_TalonSRX(14);
    leftRear= new WPI_TalonSRX(1);
    rightRear = new WPI_TalonSRX(15);
    mecanumDrive = new MecanumDrive(leftFront,leftRear,rightFront,rightRear);
    gamePad=m_oi.getGamePad();
  }
  public void setMecanumDriveCommand(double ySpeed, double xSpeed, double zRotation, double gyroAngle) {
		mecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation);
    	
	}

}
