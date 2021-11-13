// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.hal.simulation.RoboRioDataJNI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Commands.firstCommand;
import frc.robot.Commands.pidCommand;
import frc.robot.Commands.runWithTimeAndButton;
import frc.robot.Commands.xboxController;
import frc.robot.subSystems.firstSubsystem;
import frc.robot.subSystems.subSystemDos;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static firstSubsystem _sub = firstSubsystem.get_instance();
  private firstCommand _com = new firstCommand();
  private runWithTimeAndButton _timeCom = new runWithTimeAndButton();
  private static subSystemDos _sub2 = subSystemDos.get_instance();
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private xboxController _xboxCom = new xboxController();
  private RobotContainer _RC;
  private pidCommand _PidCom;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    _RC = new RobotContainer();
    _PidCom = new pidCommand();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
    //_sub.runMotor(false);
    //_sub.runServo(false);
    //_com.schedule(true);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  
    
    
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    //_sub.runMotor(true);
    //_sub.runServo(true);
    //_sub2.toggleSolenoid();
   // _sub.motionMagicPID();
   _sub.zeroEncoder();
   }
  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //_sub.runOnButton();
    //_sub.runTurret();
    //_com.schedule();
    _sub.motionMagicPID();
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
