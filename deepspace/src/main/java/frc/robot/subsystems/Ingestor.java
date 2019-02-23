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
import frc.robot.OI;

/**
 * Add your docs here.
 */
public class Ingestor extends Subsystem {
  private WPI_TalonSRX leftIngestor;
    private WPI_TalonSRX rightIngestor;
    private Compressor compressor;
    private DoubleSolenoid solenoidW;
    private DoubleSolenoid solenoidL;
    private OI oi;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Ingestor(){
    //this.oi=oi;
    leftIngestor = new WPI_TalonSRX(22);
    rightIngestor = new WPI_TalonSRX(12);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //compressor = new Compressor(0);
    
    //solenoidW = new DoubleSolenoid(1, 2);
    //solenoidL = new DoubleSolenoid(3, 4); // TODO get channel number, rename(fine for now, can be changed later)
    //compressor.start();

  }
  // for pnuematics for wedge pickup

    public void extend() {
       // solenoidW.set(DoubleSolenoid.Value.kForward);
    }

    public void retract() {
        //solenoidW.set(DoubleSolenoid.Value.kReverse);
    }
    // for pnuematics for adjustment

    public void lift() {
        //solenoidL.set(DoubleSolenoid.Value.kForward);
    }

    public void lower() {
        //solenoidL.set(DoubleSolenoid.Value.kReverse);
    }


    public void driveMotors(double speed){
        leftIngestor.set(speed);
        rightIngestor.set(-speed);
    }
    
}
