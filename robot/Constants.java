// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

	//PWMS's for wiring team (0-9) - LL 

	public static final class PWMConstants {
		public static final class Drive {
			public static final int LEFT_FRONT = 5;
			public static final int RIGHT_FRONT = 2;
			public static final int LEFT_BACK = 3;
			public static final int RIGHT_BACK = 4;
		}
		
		public static final class Grabber {
			public static final int GRABBER = 1;
		}

	}
	public static final class SolenoidConstants {
		public static final class Ramp {
			public static final int RAMP_SOLENOID = 1;
		}
		public static final class Grabber {
			public static final int SLIDER = 2;
			public static final int ARM1 = 4;
			public static final int ARM2 = 5;
		}
		public static final class Drive {
			public static final int GEARBOX = 0;
		}
	}	


	public static final class DriveConstants {
		public static final double DRIVETRAINSPEED = 0.7;
	}
	
	public static final class GrabberConstants {
		public static final double INTAKE_SPEED = 0.35;
		public static final double OUTAKE_SPEED = -0.4;
	}


	public static final class OIConstants {
		public static final int JOYSTICK_NUMBER = 0;

		public static final int XBOX_Y_AXIS = 5;
		public static final int XBOX_X_AXIS = 0;
		
	}

	public static final class AutonomousConstants{
		public static final double DRIVE_FORWARD_TIME = 3.0;
		public static final double AUTONOMOUS_SPEED = 0.6;
	}


	//Making the Compressor
	public static final Compressor compressor = new Compressor();






	

}
