/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.OI;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Ingestor;

public class DeployBall extends CommandGroup {
    /**
     * Add your docs here.
     */
    public DeployBall(OI m_oi, Elevator elevator, double speed, double time) {
        // Add Commands here:
        //addSequential(new MoveElevator(m_oi));
        //System.out.println("Elevator up..."); //For testing purposes, replace with actual commands
        addSequential(new DeployBallIngestor(m_oi.getIngestor(), speed), 0.1);
        addSequential(new KickBall(time, m_oi.getBK(), m_oi));
        addSequential(new KickBallBack(time, m_oi.getBK(), m_oi));
       // System.out.println("Elevator down..."); //For testing purposes, replace with actual commands
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
