// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AutonomousPicker extends SubsystemBase {
  // enum = enumeration ==> A data type which allows you to describe numbers with "names" - LL
  public enum StartingPosition {
    LEFT, CENTER, RIGHT
  }

  public StartingPosition startPosition = null;

  //A class used for Smart Dashboard - LL
  private SendableChooser<StartingPosition> startPositionChooser;
  /** Creates a new AutonomousPicker. */
  public AutonomousPicker() {
    System.out.println("In auto picker");

    startPositionChooser = new SendableChooser<>();
    startPositionChooser.setDefaultOption("Left", StartingPosition.LEFT);
    startPositionChooser.addOption("Center", StartingPosition.CENTER);
    startPositionChooser.addOption("Right", StartingPosition.RIGHT);

    SmartDashboard.putData("Starting Position", startPositionChooser);
  }

  public StartingPosition getAutonomous() {
    return startPositionChooser.getSelected(); //This is neccessary! - LL 
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
