// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.AutonomousPicker;
import frc.robot.subsystems.DriveTrainSubsystem;

public class Autonomous extends CommandBase {
  private final AutonomousPicker autonomousPicker;
  private final DriveTrainSubsystem driveTrain;
  /** Creates a new Autonomous. */
  public Autonomous(AutonomousPicker autonomousPicker, DriveTrainSubsystem driveTrain) {
    this.autonomousPicker = autonomousPicker;
    this.driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(autonomousPicker);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  public Command runAutonomous() {
    SequentialCommandGroup autoCommands = new SequentialCommandGroup();
    switch(autonomousPicker.getAutonomous()) { //switch (Statement) ==> Switch what you do based on what you input/enter - LL
       case LEFT: //This is the input of the user and the if of an if statement - LL
        System.out.println("Went left");
        autoCommands = new SequentialCommandGroup(
          new DriveForwardTimedCmd(driveTrain, 0.6, 1)
        );
        break;
      case CENTER:
        System.out.println("Went Center");
        autoCommands = new SequentialCommandGroup (
          new DriveForwardTimedCmd(driveTrain, -0.6, 1)
        );
        break;
      case RIGHT:
        System.out.println("Went Right");
        autoCommands = new SequentialCommandGroup (
          new DriveForwardTimedCmd(driveTrain, -0.6, 1),
          new DriveForwardTimedCmd(driveTrain, 0, 1),
          new DriveForwardTimedCmd(driveTrain, 0.6, 1)
        );
        break;
      default:
        autoCommands = new SequentialCommandGroup(
          new DriveForwardTimedCmd(driveTrain, 0, 0)
        );
        break;
    } //End of Switch
    return autoCommands;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
