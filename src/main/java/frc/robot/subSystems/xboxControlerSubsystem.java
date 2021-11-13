// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subSystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class xboxControlerSubsystem extends SubsystemBase {
  private TalonSRX _motor;
  private static xboxControlerSubsystem _instance = new xboxControlerSubsystem();
  /** Creates a new xboxControlerSubsystem. */
  public xboxControlerSubsystem() {
    _motor = new TalonSRX(2);
    _motor.configFactoryDefault();
    _motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    _motor.setSelectedSensorPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void runOnA () {
      _motor.set(ControlMode.PercentOutput,.3);
  }
  public void encoderRunWithControler (double value) {
    double encoderValue = _motor.getSelectedSensorPosition(0);
    if (encoderValue < value) {
      _motor.set(ControlMode.PercentOutput, .3);
    }
    else {
      _motor.set(ControlMode.PercentOutput, 0);
    }
    System.out.println(encoderValue);
  }
  public static xboxControlerSubsystem get_instance(){
    return _instance;
    }
    public void setMotorZero() {
      _motor.set(ControlMode.PercentOutput, 0);
    }
}
