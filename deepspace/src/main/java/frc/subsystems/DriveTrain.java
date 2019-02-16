/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.command.Drive;
import frc.OI;
import frc.Robot;

public class DriveTrain extends Subsystem {
  private WPI_TalonSRX leftFront; 
	private WPI_TalonSRX rightFront;
	private WPI_TalonSRX leftRear;
	private WPI_TalonSRX rightRear;
  private MecanumDrive mecanumDrive;
  private OI m_oi;

  private Joystick gamePad;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive(m_oi, Robot.getDriveTrain()));
    System.out.println("Set default command");
  }
  public DriveTrain(OI m_oi) {
    this.m_oi=m_oi;
    leftFront = new WPI_TalonSRX(10);//14 front left, 15 front right elevator 13
    rightFront = new WPI_TalonSRX(11);//0 back left  1 back right
    leftRear= new WPI_TalonSRX(24);
    rightRear = new WPI_TalonSRX(25);
    mecanumDrive = new MecanumDrive(leftFront,leftRear,rightFront,rightRear);
    gamePad = m_oi.getController();
    
  }
  public void setMecanumDriveCommand(double ySpeed, double xSpeed, double zRotation, double gyroAngle) {
		mecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation);
    	
  }
  
  public void periodic() {
    setMecanumDriveCommand(gamePad.getRawAxis(0), -0.75*gamePad.getRawAxis(1), 0.5*gamePad.getRawAxis(4), 0);
  }

}
