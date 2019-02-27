/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ingestor extends Subsystem {
  private WPI_TalonSRX leftIngestor;
    private WPI_TalonSRX rightIngestor;
    private Compressor compressor=new Compressor(0);
    private DoubleSolenoid solenoidW=new DoubleSolenoid(1, 2);
    private DoubleSolenoid solenoidL=new DoubleSolenoid(3, 4);
    
  public Ingestor(){
    leftIngestor = new WPI_TalonSRX(22);
    rightIngestor = new WPI_TalonSRX(12);
  }

  @Override
  public void initDefaultCommand() {
    compressor.start();

  }
  // for pnuematics for wedge pickup

    public void extend() {
       solenoidW.set(DoubleSolenoid.Value.kForward);
    }

    public void retract() {
        solenoidW.set(DoubleSolenoid.Value.kReverse);
    }
    // for pnuematics for adjustment

    public void lift() {
        solenoidL.set(DoubleSolenoid.Value.kForward);
        System.out.println("LIFTING");
    }

    public void lower() {
        solenoidL.set(DoubleSolenoid.Value.kReverse);
        System.out.println("LOWERING");
    }


    public void driveMotors(double speed){
        System.out.println("Running ingestor motors...");
        leftIngestor.set(speed);
        rightIngestor.set(-speed);
    }
    
}
