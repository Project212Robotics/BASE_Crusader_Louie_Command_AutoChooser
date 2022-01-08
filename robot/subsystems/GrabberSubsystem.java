// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class GrabberSubsystem extends SubsystemBase {
  //INITIALIZING motor controllers - LL
  WPI_TalonSRX grabber;

  

  /** Creates a new Grabber. */
  //CONSTRUCTOR - LL
  public GrabberSubsystem() {
    //Declaring? - LL
    grabber = new WPI_TalonSRX(Constants.PWMConstants.Grabber.GRABBER);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //intake - LL

  public void intake(double speed) {
    grabber.set(speed);
  }

  //outtake - LL
  public void outake (double speed) {
    grabber.set(speed);
  }

  public void stop () {
    grabber.set(0);
  }

  

}
