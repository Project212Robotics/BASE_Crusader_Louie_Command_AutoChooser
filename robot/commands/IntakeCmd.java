// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.GrabberSubsystem;


public class IntakeCmd extends CommandBase {
  /** Creates a new Intake. */
  GrabberSubsystem grabber;


  public IntakeCmd(GrabberSubsystem g) {
    // Use addRequirements() here to declare subsystem dependencies.
    // Add REQUIREMENTS - LL
    // We are saying that this COMMANDS is DEPENDENT on the SUBSYSTEM - LL
    grabber = g;
    addRequirements(grabber);    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("IntakeCmd started!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Makes the grabber INTAKE - LL
    grabber.intake(Constants.GrabberConstants.INTAKE_SPEED);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    grabber.stop();
    
    System.out.println("IntakeCmd ended!");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
