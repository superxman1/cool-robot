// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subSystems;

import java.util.Date;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class firstSubsystem extends SubsystemBase {
  TalonSRX _talon;
  Joystick _joy = new Joystick(0);
  StringBuilder _sb = new StringBuilder();
  private DigitalInput _button;
  Date date = new Date();
  long startTime;
  long currentTime;
  long elapsedTime;
  private static firstSubsystem _instance = new firstSubsystem();

  /** Creates a new firstSubsystem. */
  private firstSubsystem() {
    _button = new DigitalInput(0);

    _talon = new TalonSRX(2);
    _talon.configFactoryDefault();
    _talon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    _talon.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);

    _talon.selectProfileSlot(0, 0);
    _talon.config_kF(0, .1118);
    _talon.config_kP(0, 1.44);
    _talon.config_kI(0, .002);
    _talon.config_IntegralZone(0, 50);
    _talon.config_kD(0, 0);

    _talon.configMotionCruiseVelocity(3661);
    _talon.configMotionAcceleration(1800);
  }

  public void zeroEncoder() {
    _talon.setSelectedSensorPosition(0);
  }

  public void runMotor(boolean motorOn) {
    if (motorOn) {
      _talon.set(ControlMode.PercentOutput, .3);
    } else {
      _talon.set(ControlMode.PercentOutput, 0);
    }

  }

  // _servo.set(.4);
  public void runOnButton() {
    double encoderValue = _talon.getSelectedSensorPosition(0);
    System.out.println(Double.toString(encoderValue));
    if (!_button.get()) {
      _talon.set(ControlMode.PercentOutput, .3);
    }
    if (encoderValue > 8000) {
      _talon.set(ControlMode.PercentOutput, 0);
      _talon.setSelectedSensorPosition(0);
      ;
    }
  }

  public void runWithTime(boolean init) {
    // System.out.println(Double.toString(encoderValue));
    currentTime = new Date().getTime();
    if (init) {
      startTime = currentTime;
    }

    elapsedTime = currentTime - startTime;
    System.out.println(elapsedTime);
    if (!_button.get()) {
      startTime = currentTime;
    }
    if (!_button.get()) {
      _talon.set(ControlMode.PercentOutput, .3);
    }
    if (elapsedTime > 10000) {
      _talon.set(ControlMode.PercentOutput, 0);
    }
  }

  public void motionMagicPID() {
    System.out.println("\tSNeed%:");
    System.out.println(_talon.getSelectedSensorPosition());
    System.out.println("\tVel:");
    System.out.println(_talon.getSelectedSensorVelocity(0));
    double targetPos = 4096 * 10.;
    _talon.set(ControlMode.MotionMagic, targetPos);
    //_talon.set(ControlMode.PercentOutput, 0.2);
    System.out.println("\terr:");
    System.out.println(_talon.getClosedLoopError(0));
    System.out.println("\ttrg:");
    System.out.println(targetPos);
  }

  public void runTurret() {
    double encoderValue = _talon.getSelectedSensorPosition(0);
    if (encoderValue < 20480) {
      _talon.set(ControlMode.PercentOutput, .2);
    } else {
      _talon.set(ControlMode.PercentOutput, 0);
    }
    System.out.println(Double.toString(encoderValue));
  }

  public static firstSubsystem get_instance() {
    return _instance;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
