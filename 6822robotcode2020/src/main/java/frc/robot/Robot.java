/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


import frc.robot.commands.*;
import frc.robot.subsystems.*;

import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
//import frc.robot.GripPipeline;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import edu.wpi.first.vision.VisionRunner;
import edu.wpi.first.vision.VisionThread;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Spark;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.SPI;
//import com.kauailabs.navx.frc.AHRS;

public class Robot extends TimedRobot {

  public static WPI_VictorSPX climb1;
  public static WPI_VictorSPX climb2;

  public static WPI_VictorSPX storage;
  public static WPI_VictorSPX intake;

  public static WPI_TalonSRX arm1;
  public static WPI_VictorSPX arm2;

  public static WPI_TalonSRX shoot1;
  public static WPI_VictorSPX shoot2;

  public static WPI_TalonFX drive1;
  public static WPI_TalonFX drive2;
  public static WPI_TalonFX slave1;
  public static WPI_TalonFX slave2;

  public static DifferentialDrive m_drive;

  public static DriveTrain m_drivetrain;
  public static Arm m_arm;
  public static Ballintake m_intake;
  public static Climber m_climber;
  public static Shooter m_shooter;
  public static StorageFeed m_storage;

  public static OI m_oi;


  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

 
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

<<<<<<< Updated upstream
    m_drive = new DifferentialDrive(drive1, drive2);
    m_drivetrain = new DriveTrain(m_drive);

    m_arm = new Arm(arm1, arm2);
    m_intake = new Ballintake(intake);
    m_climber = new Climber(climb1, climb2);
    m_shooter = new Shooter(shoot1, shoot2);
    m_storage = new StorageFeed(storage);
    
    m_oi = new OI();
=======

    climb1 = new WPI_VictorSPX(1);
    climb2 = new WPI_VictorSPX(2);

    storage = new WPI_VictorSPX(3);
    intake = new WPI_VictorSPX(4);

    arm1 = new WPI_VictorSPX(5);
    arm2 = new WPI_VictorSPX(6);
>>>>>>> Stashed changes

    wheel1 = new WPI_TalonSRX(7);
    wheel2 = new WPI_TalonSRX(8);

    drive1 = new WPI_TalonFX(9);
    drive2 = new WPI_TalonFX(10);
    slave1 = new WPI_TalonFX(11);
    slave2 = new WPI_TalonFX(12);

    m_drive = new DifferentialDrive(drive1, drive2);
    SmartDashboard.putData(m_drive);
    m_drivetrain = new DriveTrain();

    m_oi = new OI();
  }


  @Override
  public void robotPeriodic() {
  }

  
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  
  @Override
  public void teleopPeriodic() {
  }

  
  @Override
  public void testPeriodic() {
  }
}
