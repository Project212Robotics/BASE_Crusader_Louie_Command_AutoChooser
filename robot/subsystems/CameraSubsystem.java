// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CameraSubsystem extends SubsystemBase {
  /** Creates a new Camera. */
  UsbCamera camera;

  public CameraSubsystem() {
    // Creates UsbCamera and MjpegServer [1] and connects them
    camera = new UsbCamera("USB Camera 0", 0);
    MjpegServer mjpegServer1 = new MjpegServer("serve_USB Camera 0", 1181);
    mjpegServer1.setSource(camera);

    // Creates the CvSink and connects it to the UsbCamera
    CvSink cvSink = new CvSink("opencv_USB Camera 0");
    cvSink.setSource(camera);

    // Creates the CvSource and MjpegServer [2] and connects them
    CvSource outputStream = new CvSource("Blur", PixelFormat.kMJPEG, 640, 480, 30);
    MjpegServer mjpegServer2 = new MjpegServer("serve_Blur", 1182);
    mjpegServer2.setSource(outputStream);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
