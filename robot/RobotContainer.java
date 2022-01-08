// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArmDownCmd;
import frc.robot.commands.ArmUpCmd;
import frc.robot.commands.Autonomous;
import frc.robot.commands.DriveForwardCmd;
import frc.robot.commands.DriveForwardTimedCmd;
import frc.robot.commands.DriveWithJoysticksCmd;
import frc.robot.commands.IntakeCmd;
import frc.robot.commands.OutakeCmd;
import frc.robot.commands.RampOffCmd;
import frc.robot.commands.RampOnCmd;
import frc.robot.commands.SliderExtendedCmd;
import frc.robot.commands.SliderShortenedCmd;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.AutonomousPicker;
//import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.GrabberSubsystem;
import frc.robot.subsystems.RampSubsystem;
//import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // DECLARE subsystems and commands here! - LL


  //DriveTrain files - LL
  private final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
  private final DriveWithJoysticksCmd driveWithJoysticks = new DriveWithJoysticksCmd(driveTrain);

  // This isn't neccesary to have anymore???? --> Works fine with or without the next 2 lines - LL 12.30.21
  private final DriveForwardTimedCmd driveForwardTimed = new DriveForwardTimedCmd(driveTrain, 0, 0); // WHY DO I ADD THE 0, 0 ??? - LL 12.30.21
  private final DriveForwardCmd driveForward = new DriveForwardCmd(driveTrain);

  //Controller files - lL
  public static XboxController driverJoystick = new XboxController(Constants.OIConstants.JOYSTICK_NUMBER);

  //Grabber files - LL
  private final GrabberSubsystem grabber = new GrabberSubsystem();
  private final IntakeCmd intake = new IntakeCmd(grabber);
  private final OutakeCmd outake = new OutakeCmd(grabber);

  //Arm files - LL
  private final ArmSubsystem arm = new ArmSubsystem();
  private final ArmDownCmd armDown = new ArmDownCmd(arm);
  private final ArmUpCmd armUp = new ArmUpCmd(arm);
  private final SliderExtendedCmd sliderExtended = new SliderExtendedCmd(arm);
  private final SliderShortenedCmd sliderShortened = new SliderShortenedCmd(arm);
 

  //Ramp files - LL
  private final RampSubsystem ramp = new RampSubsystem();
  private final RampOnCmd rampOn = new RampOnCmd(ramp);
  private final RampOffCmd rampOff = new RampOffCmd(ramp);

  //Autonomous Picker Files - lL
  private final AutonomousPicker autonomousPicker = new AutonomousPicker();
  private final Autonomous autonomous = new Autonomous(autonomousPicker, driveTrain);

  //private final Outake outake;

  /*example subsystem DECLARATION - LL
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  example autonomous DECLARATION - LL
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  */

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    System.out.println("In the Construtor for RobotContainer");
    //INITALIZE all the things we made - LL

    //Drive is always looking to read this command - LL
    driveTrain.setDefaultCommand(driveWithJoysticks);

    

    // Configure the button bindings



    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Inside here you CONFIGURE YOUR BUTTONS - LL

    //INTAKE Button, and we CONFIGURE THE BUTTON - LL
    JoystickButton intakeButton = new JoystickButton(driverJoystick, 5);
    intakeButton.whileHeld(intake);
    JoystickButton outtakeButton = new JoystickButton(driverJoystick, 6);
    outtakeButton.whileHeld(outake);

    //RAMP Buttons - LL
    JoystickButton rampOnButton = new JoystickButton(driverJoystick, 8);
    rampOnButton.whenPressed(rampOn);
    JoystickButton rampOffButton = new JoystickButton(driverJoystick, 7);
    rampOffButton.whenPressed(rampOff);

    //ARM Buttons - LL
    JoystickButton armDownButton = new JoystickButton(driverJoystick, 1);
    armDownButton.whenPressed(armDown);
    JoystickButton armUpButton = new JoystickButton(driverJoystick, 2);
    armUpButton.whenPressed(armUp);

    JoystickButton sliderExtendedButton = new JoystickButton(driverJoystick, 3);
    sliderExtendedButton.whenPressed(sliderExtended);
    JoystickButton sliderShortenedButton = new JoystickButton(driverJoystick, 4);
    sliderShortenedButton.whenPressed(sliderShortened);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */



  /**
   * Below is an example of a very simple Autonomous where you only have 
   * ONE Sequential Command Group (Basically, just enough for your robot to move forward) - LL
   */

  /* -----------------------------------------------------------------------------------------------------------------------------------
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;

    //changed it to this so robot will do this driveFowardTimed command - LL
    //Can update this to a command group --> change using smart dashboard - LL

    
     * Does not drive forward (driveForwardTimed)
     * TROUBLESHOOTING DIAG DOES SAY IT WORKS THOUGH?
     * LL - 12.30.21
     
    return new SequentialCommandGroup (
      new DriveForwardTimedCmd(driveTrain, 0.6, 1),
      new DriveForwardTimedCmd(driveTrain, -0.6, 1) //THIS WORKS?? --> Must test on Robot when I come back - LL 12.30.21
    );
  }
  */ // -----------------------------------------------------------------------------------------------------------------------------------
  


  public Command getAutonomousCommand() {
    /** THIS IS AN EXAMPLE OF:
     * An autonomous picker where one can choose which autonomous program to run based on 
     * where your robot is starting on the game field (LEFT, CENTER, RIGHT) by allowing the 
     * drivers to choose that option on the SMART DASHBOARD while on the Game field at the same time!!!
     *  
     *  */ 

    return autonomous.runAutonomous();
  }
}

