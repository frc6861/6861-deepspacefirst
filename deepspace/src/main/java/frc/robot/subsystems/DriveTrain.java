/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.OI;
import frc.robot.commands.Drive;



public class DriveTrain extends Subsystem {
  private WPI_TalonSRX leftFront; 
	private WPI_TalonSRX rightFront;
	private WPI_TalonSRX leftRear;
	private WPI_TalonSRX rightRear;
  private MecanumDrive mecanumDrive;
  private OI m_oi;

  
  public DriveTrain(OI m_oi) {
    
    leftFront = new WPI_TalonSRX(10);//14 front left, 15 front right elevator 13
    rightFront = new WPI_TalonSRX(11);//0 back left  1 back right
    leftRear= new WPI_TalonSRX(24);                                   //PRACTICE ROBOT
    rightRear = new WPI_TalonSRX(25);
    


    //leftFront = new WPI_TalonSRX(4);//final
    //rightFront = new WPI_TalonSRX(5);//       FINAL ROBOT
    //leftRear= new WPI_TalonSRX(23);//final
    //rightRear = new WPI_TalonSRX(15);//final

    this.m_oi=m_oi;
    mecanumDrive = new MecanumDrive(leftFront,leftRear,rightFront,rightRear);
   }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //System.out.println("DriveTrain default command");
    setDefaultCommand(new Drive(m_oi,this));
  }
  public void setMecanumDriveCommand(double ySpeed, double xSpeed, double zRotation, double gyroAngle) {
		mecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation);
    	
  }
  
  
}
