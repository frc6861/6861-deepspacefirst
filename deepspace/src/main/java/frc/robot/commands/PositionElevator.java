/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.ElevatorPosition;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;

public class PositionElevator extends Command {
    private Elevator elevator;
    private double position;
    private DigitalInput bottom;
    private int[] positionsArr;
    private int botPos, midPos, topPos;
    public PositionElevator(Elevator elevator, ElevatorPosition ballcargoship) {
        this.elevator = elevator;
        
        botPos = 2851;
        midPos = 20337;
        topPos = 36930;

        bottom = Robot.bottomLimitSwitch;
        //this.position = ballcargoship.getPosition();
        //elevator.setElevatiorHeight(position);
        // requires(driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        System.out.println("STARTING" + position);

    }
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        System.out.println("executing");
        if(!bottom.get()){
            elevator.resetEncoder();
        }
        System.out.println("position:"+position);
        System.out.println("calculated"+((position)));
        //System.out.println("calculated"+((position +15)-11)*206);
        System.out.println("actual"+ elevator.getElevatorHeight());
        if(Math.abs(elevator.getElevatorHeight()-botPos) < Math.abs(elevator.getElevatorHeight()-midPos) && Math.abs(elevator.getElevatorHeight()-botPos) < Math.abs(elevator.getElevatorHeight()-topPos)){
            System.out.println("bottom");
            if(elevator.getElevatorHeight()-botPos < -200){
                System.out.println("up");
                elevator.setPower(0.6);
            }
            else if(elevator.getElevatorHeight()-botPos > 200){
                System.out.println("down");
                elevator.setPower(-0.75);
            }
            else{
                System.out.println("stop");
                elevator.setPower(0);
            }
        }
        else if(Math.abs(elevator.getElevatorHeight()-midPos) < Math.abs(elevator.getElevatorHeight()-botPos) && Math.abs(elevator.getElevatorHeight()-midPos) < Math.abs(elevator.getElevatorHeight()-topPos)){
            System.out.println("mid");
            if(elevator.getElevatorHeight()-midPos < -200){
                System.out.println("up");
                elevator.setPower(0.6);
            }
            else if(elevator.getElevatorHeight()-midPos > 200){
                System.out.println("down");
                elevator.setPower(-0.75);
            }
            else{
                System.out.println("stop");
                elevator.setPower(0);
            }
        }
        else if(Math.abs(elevator.getElevatorHeight()-topPos) < Math.abs(elevator.getElevatorHeight()-botPos) && Math.abs(elevator.getElevatorHeight()-topPos) < Math.abs(elevator.getElevatorHeight()-midPos)){
            System.out.println("top");
            if(elevator.getElevatorHeight()-topPos < -200){
                System.out.println("up");
                elevator.setPower(0.6);
            }
            else if(elevator.getElevatorHeight()-topPos > 200){
                System.out.println("down");
                elevator.setPower(-0.75);
            }
            else{
                System.out.println("stop");
                elevator.setPower(0);
            }
        }
        //elevator.setPower(0.6);

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {

        //boolean test=(Math.abs(-elevator.getElevatorHeight()-((position +15)-11)*206)<.0001);
        boolean test=(Math.abs(elevator.getElevatorHeight()-position) <= 500);
        if(test){
            System.out.println("Elevator test reached");
           //elevator.setPower(0);
        }
       
        //return (Math.abs(-elevator.getElevatorHeight()-((position +15)-11)*206)<.0001);
        return (Math.abs(-elevator.getElevatorHeight()-((position)))<.0001);
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}