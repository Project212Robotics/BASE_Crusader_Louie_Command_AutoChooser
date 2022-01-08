// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RampSubsystem;

public class RampOnCmd extends CommandBase {
  /** Creates a new RampOn. */
  RampSubsystem ramp;

  public RampOnCmd(RampSubsystem r) {
    // Use addRequirements() here to declare subsystem dependencies.
    ramp = r;
    addRequirements(ramp);


  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("RampOnCmd started!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ramp.setRampValue(true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("RampOnCmd ended!");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
