// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class ArmDownCmd extends CommandBase {
  /** Creates a new ArmDown. */
  ArmSubsystem arm;

  public ArmDownCmd(ArmSubsystem a) {
    // Use addRequirements() here to declare subsystem dependencies.
    arm = a;
    addRequirements(arm);   
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("ArmDownCmd started!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.setArmValue(Value.kReverse);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("ArmDownCmd ended!");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
