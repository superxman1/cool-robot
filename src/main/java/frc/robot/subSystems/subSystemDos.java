// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subSystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;


public class subSystemDos extends SubsystemBase 
{
  private DoubleSolenoid _solinoid;
  private static subSystemDos _instance = new subSystemDos();
  /** Creates a new subSystemDos. */
  public subSystemDos() {
    //_solinoid = new DoubleSolenoid(0,1);
    //_solinoid.set(kForward);
  }
 
public void toggleSolenoid() {
  //_solinoid.toggle();
}
public static subSystemDos get_instance(){
  return _instance;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
