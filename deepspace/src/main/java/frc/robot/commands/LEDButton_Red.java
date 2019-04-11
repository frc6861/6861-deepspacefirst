package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.UnderConsoleLights;
import frc.robot.subsystems.Color;

public class LEDButton_Red extends Command {
  private UnderConsoleLights lightChange;
  private Color red;
  public LEDButton_Red(UnderConsoleLights lightChange) {

    // Use requires() here to declare subsystem dependencies
    this.lightChange = lightChange;
    red = new Color(255, 0, 0);
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      System.out.print("RED ALLIANCE!");
    lightChange.changeColor(red);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
