// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrainSubsystem extends SubsystemBase {
  //Initializing - LL
  WPI_TalonSRX leftFront;
  WPI_TalonSRX rightFront;
  WPI_TalonSRX leftBack;
  WPI_TalonSRX rightBack;
  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;
  DifferentialDrive drive;

  
  Solenoid gearbox;

  /** Creates a new DriveTrain. */
  public DriveTrainSubsystem() {
    //set Motor Controller to PWM outputs - LL
    leftFront = new WPI_TalonSRX(Constants.PWMConstants.Drive.LEFT_FRONT);
    leftFront.setInverted(false);
    rightFront = new WPI_TalonSRX(Constants.PWMConstants.Drive.RIGHT_FRONT);
    rightFront.setInverted(false);
    leftBack = new WPI_TalonSRX(Constants.PWMConstants.Drive.LEFT_BACK);
    leftBack.setInverted(false);
    rightBack = new WPI_TalonSRX(Constants.PWMConstants.Drive.RIGHT_BACK);
    rightBack.setInverted(false);

    //Idk why the two lines below are highlighted red
    leftMotors = new SpeedControllerGroup(leftFront, leftBack);
    rightMotors = new SpeedControllerGroup(rightFront, rightBack);
    drive = new DifferentialDrive(leftMotors, rightMotors);

    gearbox = new Solenoid(Constants.SolenoidConstants.Drive.GEARBOX);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithJoysticks(XboxController controller, double speed) {
    drive.arcadeDrive(controller.getRawAxis(Constants.OIConstants.XBOX_Y_AXIS)*-(speed), controller.getRawAxis(Constants.OIConstants.XBOX_X_AXIS)*speed);
  }

  public void driveForward(double speed) {
    drive.tankDrive(speed, speed);
    System.out.println("driveForward " + speed);
  }

  public void setGear(boolean x) {
    gearbox.set(x);
  }

  public void stop() {
    drive.stopMotor();
  }

}
