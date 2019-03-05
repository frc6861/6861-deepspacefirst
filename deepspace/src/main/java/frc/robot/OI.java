/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.AutonOverRide;
import frc.robot.commands.DeployBall; //LEAVE THIS, IT IS A SURPRISE TOOL THAT WILL HELP US LATER
import frc.robot.commands.DownIngestor;
import frc.robot.commands.HatchUp;
import frc.robot.commands.HatchUpTimed;
import frc.robot.commands.KickBall;
import frc.robot.commands.KickBallBack;
import frc.robot.commands.MoveElevator;
import frc.robot.commands.RunIngestor;
import frc.robot.commands.UpIngestor;
import frc.robot.subsystems.BallKicker;
import frc.robot.subsystems.HatchPusher;
import frc.robot.subsystems.Ingestor;
import frc.robot.commands.PositionElevator;

/**
 * Add your docs here.
 */
public class OI {
    
  private  XboxController gamePad1, gamePad2;
  private Joystick controller;
  private JoystickButton buttonY1,buttonX1,buttonA1,buttonB1,buttonLB1,buttonBack1,buttonRB1,buttonStart1,buttonClickLeft1,buttonClickRight1,buttonLT1,buttonRT1,
  buttonY2,buttonX2,buttonA2,buttonB2,buttonLB2,buttonBack2,buttonRB2,buttonStart2,buttonClickLeft2,buttonClickRight2,buttonLT2,buttonRT2;
  private HatchPusher hatch = new HatchPusher();
  private Ingestor ingestor =new Ingestor();
  private BallKicker ballKicker = new BallKicker();
  public OI(){
    
    gamePad1 = new XboxController(0);
    gamePad2 = new XboxController(1);
    buttonA1 = new JoystickButton(gamePad1,1);//Run ingestor inward
    buttonB1 = new JoystickButton(gamePad1,2);//Run ingestor outward
    buttonX1 = new JoystickButton(gamePad1,3);//Flip up ingestor (to pick up hatches)
    buttonY1 = new JoystickButton(gamePad1,4);//Put down ingestor
    buttonLB1 = new JoystickButton(gamePad1,5);//Deploy hatch
    buttonRB1 = new JoystickButton(gamePad1,6);//Shoot ball
    buttonBack1 = new JoystickButton(gamePad1,7);//Auton Override
    buttonStart1 = new JoystickButton(gamePad1,8);
    buttonClickLeft1 = new JoystickButton(gamePad2,9);//Rotate 90° Anticlockwise (? QOL)
    buttonClickRight1 = new JoystickButton(gamePad1,10);//Rotate 90° Clockwise (? QOL)
    buttonLT1 = new JoystickButton(gamePad1,11);
    buttonRT1 = new JoystickButton(gamePad1,12);
    
    buttonA2 = new JoystickButton(gamePad2,1);//Elevator to Level 3 (To shoot ball into cargo ship)
    buttonB2 = new JoystickButton(gamePad2,2);//Elevator to Level 1 (Bottom hatch for rocket and cargo)
    buttonX2 = new JoystickButton(gamePad2,3);//Elevator to Level 2 (Bottom rocket port)
    buttonY2 = new JoystickButton(gamePad2,4);//Climb
    buttonLB2 = new JoystickButton(gamePad2,5);//Elevator to Level 4 (Middle rocket hatch)
    buttonRB2 = new JoystickButton(gamePad2,6);//Elevator to Level 5 (Middle rocket port)
    buttonBack2 = new JoystickButton(gamePad2,7);//AutonOverride
    buttonStart2 = new JoystickButton(gamePad2,8);
    buttonClickLeft2 = new JoystickButton(gamePad2,9);
    buttonClickRight2 = new JoystickButton(gamePad2,10);
    buttonLT2 = new JoystickButton(gamePad2,11);//Elevator to Level 6 (Top rocket hatch)
    buttonRT2 = new JoystickButton(gamePad2,12);//Elevator to Level 7 (Top rocket port)
    

  }
  public XboxController getGamePad1() {
		return gamePad1;
  }
  public XboxController getGamePad2() {
		return gamePad2;
  }

  public Joystick getController() {
    return controller;
  }
  
  public boolean getAButton() {
    return buttonA2.get();
  }
  public boolean getBButton() {
    return buttonB2.get();
  }

  public boolean getA1Button() {
    return gamePad1.getAButton();
  }
  public boolean getB1Button() {
    return gamePad1.getBButton();
  }

  public void init() {

    buttonX1.whileHeld(new UpIngestor(ingestor)); //put ingestor back UP
    buttonY1.whileHeld(new DownIngestor(ingestor)); // put ingestor up to pick up hatches
    buttonLT1.whileActive(new RunIngestor(ingestor,-0.8)); //run ingestor inward
    buttonRT1.whileActive(new RunIngestor(ingestor,0.8)); //run ingestor outward
    buttonLT1.whenInactive(new RunIngestor(ingestor,0));
    buttonRT1.whenInactive(new RunIngestor(ingestor,0));
    buttonLB1.whenPressed(new DeployBall(this, Robot.elevator, 0.8, 0.1));
    buttonBack1.whileHeld(new AutonOverRide(this));
    buttonStart1.whenPressed(new KickBall(1,ballKicker, this));
    buttonStart1.whenReleased(new KickBallBack(1,ballKicker, this));
    //buttonLB1.whileHeld(new RunKicker(0.5));
    //buttonRB1.whileHeld(new RunKicker(-0.5));
    //buttonClickLeft1.whenPressed(new DeployBall(0.2,2)); //UNCOMMENT THIS AND FIX PARAMETERS!!
    //rotate left 90 deg
    //buttonClickRight1.whenPressed(new ClockwiseTurn(0.26, driveTrain)); //rotate right 90 deg*/
    buttonA2.whenPressed(new PositionElevator(Robot.elevator, ElevatorPosition.BALLLOWROCKETSHIP));
    buttonB2.whenPressed(new PositionElevator(Robot.elevator, ElevatorPosition.BALLCARGOSHIP));
    buttonRB2.whenPressed(new PositionElevator(Robot.elevator, ElevatorPosition.BALLMIDROCKETSHIP));
    buttonRT2.whileActive(new PositionElevator(Robot.elevator, ElevatorPosition.BALLTOPROCKETSHIP));

    buttonBack2.whenPressed(new HatchUp(hatch, 0.25)); //deploy hatch 
    buttonStart2.whenPressed(new HatchUp(hatch, -0.25)); //shoot ball   */
    buttonBack2.whenReleased(new HatchUp(hatch, 0)); //deploy hatch 
    buttonStart2.whenReleased(new HatchUp(hatch, 0));


    buttonClickLeft2.whileHeld(new MoveElevator(this));//ballCargoShip
    buttonClickRight2.whileHeld(new MoveElevator(this)); //hatchRocketandCargoShip

    //buttonClickLeft2.whenReleased(new MoveElevator(this, 0));
    //buttonClickRight2.whenReleased(new MoveElevator(this, 0));
    //buttonB2.whenPressed(new MoveElevator(elevator,"3")); //ballLowRocketShip
    //buttonLB2.whenPressed(new PositionElevator(elevator, ElevatorPosition.HATCHMIDROCKETSHIP)); //hatchMidRocketShip
    //buttonLT2.whenPressed(new PositionElevator(elevator, ElevatorPosition.BALLMIDROCKETSHIP)); //ballMidRocketShip
    //buttonRT2.whenPressed(new PositionElevator(elevator, ElevatorPosition.HATCHMIDROCKETSHIP)); //hatchTopRocketShip
    //buttonRB2.whenPressed(new PositionElevator(elevator, ElevatorPosition.BALLTOPROCKETSHIP)); //ballTopRocketShip
    //buttonBack2.whenPressed(new AutonOverRide(this));
    //buttonY2.whileHeld(new Climb(this));*/
 }
 public boolean getButtonClickLeft2() {
   return buttonClickLeft2.get();
 }
 public boolean getButtonClickRight2() {
  return buttonClickRight2.get();
}



public boolean getButtonBack2() {
    return buttonBack2.get();
  }

  public Ingestor getIngestor() {
      return ingestor;
  }
 
  public BallKicker getBK() {
      return ballKicker;
  }
}

//// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

