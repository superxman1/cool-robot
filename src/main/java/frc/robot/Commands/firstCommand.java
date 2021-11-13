// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subSystems.firstSubsystem;

public class firstCommand extends CommandBase {
  private static firstSubsystem _sub = firstSubsystem.get_instance();
  
  /** Creates a new firstCommand. */
  public firstCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(_sub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //_sub.runWithTime(true);
    _sub.motionMagicPID();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   // _sub.runWithTime(false);
    System.out.println("yo bitch");
   _sub.motionMagicPID();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
