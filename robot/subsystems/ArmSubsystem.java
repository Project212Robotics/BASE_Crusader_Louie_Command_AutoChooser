// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {

  Solenoid slider;
  DoubleSolenoid arm;

  /** Creates a new Arm. */
  public ArmSubsystem() {

    slider = new Solenoid(Constants.SolenoidConstants.Grabber.SLIDER);
    arm = new DoubleSolenoid(Constants.SolenoidConstants.Grabber.ARM1, Constants.SolenoidConstants.Grabber.ARM2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSliderValue(boolean x) {
    slider.set(x);
  }
  
  public void setArmValue(Value x) {
    arm.set(x);
  }
}
