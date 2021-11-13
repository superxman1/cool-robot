// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subSystems;

import edu.wpi.first.wpilibj.XboxController;

public class RobotController extends XboxController {
  /** Creates a new RobotController. */
  private static RobotController _instance = new RobotController(0);
  public RobotController(int port) {
    super (port);
  }

  public double getLeftYAxis() {
    return getRawAxis(1);
  }

  public static RobotController getInstance() {
    return _instance;
  }
}
