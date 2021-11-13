// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.encoderXboxControler;
import frc.robot.Commands.xboxController;
import frc.robot.subSystems.xboxControlerSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private XboxController _controller = new XboxController(0);
  public JoystickButton _A = new JoystickButton(_controller, XboxController.Button.valueOf("kA").value);
  public JoystickButton _B = new JoystickButton(_controller, XboxController.Button.valueOf("kB").value);
  public JoystickButton _X = new JoystickButton(_controller, XboxController.Button.valueOf("kX").value);
  public JoystickButton _Y = new JoystickButton(_controller, XboxController.Button.valueOf("kY").value);
  private xboxController _comX = new xboxController();
  // The robot's subsystems and commands are defined here...


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {  


    // Configure the button bindings
    //configureButtonBindings();
      
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  public void configureButtonBindings() {
    //_A.whenPressed(new encoderXboxControler(5000));
    //_B.whenPressed(new encoderXboxControler(10200));
    //_X.whenPressed(new encoderXboxControler(15000));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  }



 
