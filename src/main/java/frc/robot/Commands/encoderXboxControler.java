// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subSystems.xboxControlerSubsystem;

public class encoderXboxControler extends CommandBase {
xboxControlerSubsystem _sub = xboxControlerSubsystem.get_instance();
private double _value;
  /** Creates a new encoderXboxControler. */
    // Use addRequirements() here to declare subsystem dependencies.

  // Called when the command is initially scheduled.
  public encoderXboxControler(double value){
    addRequirements(_sub);
    _value = value;
  }
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //_sub.encoderRunWithControler(_value);
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
