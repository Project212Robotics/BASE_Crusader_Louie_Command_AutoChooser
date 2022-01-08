// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveForwardTimedCmd extends CommandBase {
  //declare these three things - LL
  DriveTrainSubsystem driveTrain;
  double speed;
  double seconds;

  private boolean finish = false;
  Timer timer;

  /** Creates a new DriveForwardTimed. */
  public DriveForwardTimedCmd(DriveTrainSubsystem dt, double speed, double seconds) {
    driveTrain = dt;
    addRequirements(driveTrain);
    timer = new Timer();
    
    this.speed = speed;
    this.seconds = seconds;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("DriveForwardTimedCmd started!");
    timer.reset();
    timer.start();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.get() < seconds) {
        System.out.println("Timer: " + timer.get());
        driveTrain.driveForward(speed);
    } else {
        finish = true;
    }
    
    
    /**
     * DON'T USE WHILE LOOPS IF POSSIBLE --> HOWEVER FOR LOOPS ARE KINDA OK
     * https://www.chiefdelphi.com/t/are-loops-ok-in-frc-programming/364562/4
     * 
     * while(timer.get() < Constants.AutonomousConstants.DRIVE_FORWARD_TIME) {
      System.out.println("Timer: " + timer.get());
      driveTrain.driveForward(Constants.AutonomousConstants.AUTONOMOUS_SPEED);
    }
    finish = true;
     */
    
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop();
    driveTrain.stop();

    System.out.println("DriveForwardTimedCmd ended!");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
