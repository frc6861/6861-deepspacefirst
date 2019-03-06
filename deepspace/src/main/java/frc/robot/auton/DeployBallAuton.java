/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.OI;
import frc.robot.commands.DeployBallIngestor;
import frc.robot.commands.HatchUpTimed;
import frc.robot.commands.KickBall;
import frc.robot.commands.KickBallBack;
import frc.robot.subsystems.DriveTrain;

public class DeployBallAuton extends CommandGroup {
  /**
   * Add your docs here.
   */
  public DeployBallAuton(double time,DriveTrain driveTrain, OI m_oi) {
    // Add Commands here:
    addSequential(new CargoMiddleHatch(time, driveTrain));
    addSequential(new DeployBallIngestor(m_oi.getIngestor(), 0.6));
    //addSequential(new KickBall(time, m_oi.getBK(), m_oi));
    //(new KickBallBack(time, m_oi.getBK(), m_oi));
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
