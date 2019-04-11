package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.UnderConsoleLights;
import frc.robot.subsystems.Color;

public class LEDButton_Blue extends Command {
  private UnderConsoleLights lightChange;
  private Color blue;
  public LEDButton_Blue(UnderConsoleLights lightChange) {

    // Use requires() here to declare subsystem dependencies
    this.lightChange = lightChange;
    blue = new Color(0, 0, 255);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      System.out.print("BLUE ALLIANCE!");
    lightChange.changeColor(blue);
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
