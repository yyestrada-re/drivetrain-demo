// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.ExampleCommand;

public class Drivetrain extends SubsystemBase {
  private static MotorController upperLeftMotor = new WPI_TalonFX(Constants.upperLeftMotor);
  private static MotorController middleLeftMotor = new WPI_TalonFX(Constants.middleLeftMotor);
  private static MotorController lowerLeftMotor = new WPI_TalonFX(Constants.lowerLeftMotor);

  private static MotorController upperRightMotor = new WPI_TalonFX(Constants.upperRightMotor);
  private static MotorController middleRightMotor = new WPI_TalonFX(Constants.middleRightMotor);
  private static MotorController lowerRightMotor = new WPI_TalonFX(Constants.lowerRightMotor);

  private static MotorControllerGroup leftSide = new MotorControllerGroup(upperLeftMotor, middleLeftMotor, lowerLeftMotor);
  private static MotorControllerGroup rightSide = new MotorControllerGroup(upperRightMotor, middleRightMotor, lowerRightMotor);

  private static Joystick joystick = new Joystick(Constants.joystick);
  
  private static DifferentialDrive diffDrive = new DifferentialDrive(leftSide, rightSide);

  private double speed;

  public Drivetrain() {
    leftSide.setInverted(false);
    rightSide.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void move() {
    speed = joystick.getY() / 2;
    diffDrive.arcadeDrive(speed, 0);
  }

}
