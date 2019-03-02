/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.auton.CargoMiddleHatch;
import frc.robot.subsystems.BallKicker;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Ingestor;
import frc.robot.subsystems.Kicker;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    private static final String kDefaultAuto = "Default";
    private static final String kCustomAuto = "My Auto";
    private String m_autoSelected;
    private final SendableChooser<String> m_chooser = new SendableChooser<>();
    private DriveTrain driveTrain;
    private OI m_oi ;
    private Command m_autonomousCommand;
    public static Elevator elevator = new Elevator();
    public Ingestor ingestor;
    public static Kicker kicker = new Kicker();
    public static BallKicker ballKicker=new BallKicker();
    public static DigitalInput topLimitSwitch;
    public static DigitalInput bottomLimitSwitch;

    public Robot robot;

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        
        robot = this;

        topLimitSwitch = new DigitalInput(1);
        bottomLimitSwitch = new DigitalInput(0);
        m_oi = new OI();
        m_oi.init();
        driveTrain=new DriveTrain(m_oi);
        ingestor = new Ingestor(m_oi);
        SmartDashboard.putData("Auto mode", m_chooser);
        m_chooser.setDefaultOption("Auton Cargo Mid", "xxx");
        // m_chooser.addOption("My Auto", new CargoMiddleHatch(2,driveTrain));
        // SmartDashboard.putData("Auto choices", m_chooser);

    }

    public Robot getInstance() {
        return robot;
    }
    
    public Ingestor getIngestor() {
        return ingestor;
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for
     * items like diagnostics that you want ran during disabled, autonomous,
     * teleoperated and test.
     *
     * <p>
     * This runs after the mode specific periodic functions, but before LiveWindow
     * and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        // System.out.println("ENCODER: " + -elevator.elevatorMotor.getSensorCollection().getQuadraturePosition());
        /*if (!bottomLimitSwitch.get()) {
            elevator.elevatorMotor.getSensorCollection().setQuadraturePosition(0, 0);
        }*/
        if (m_oi.getButtonBack2()) {
            m_autonomousCommand.cancel();
        }
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable chooser
     * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
     * remove all of the chooser code and uncomment the getString line to get the
     * auto name from the text box below the Gyro
     *
     * <p>
     * You can add additional auto modes by adding additional comparisons to the
     * switch structure below with additional strings. If using the SendableChooser
     * make sure to add them to the chooser code above as well.
     */
    @Override
    public void autonomousInit() {
        Scheduler.getInstance().removeAll();
        m_autoSelected = m_chooser.getSelected();
        m_autoSelected = SmartDashboard.getString("Auto Selector", "CargoMidHatch");

        switch (m_autoSelected) {
        case "CargoMidHatch":
            // Put custom auto code here
            m_autonomousCommand = new CargoMiddleHatch(2, driveTrain);
            break;
        case kDefaultAuto:
        default:
            // Put default auto code here

            break;
        }
        if (m_autonomousCommand != null) {
            System.out.println("Auto trigger");
            m_autonomousCommand.start();
        }

    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();

    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

        // System.out.println("SWITCHES: " + topLimitSwitch.get() + " " +
        // bottomLimitSwitch.get());
        // if((!topLimitSwitch.get() && (elevator.getCurrentPower() > 0.0)) ||
        // (!bottomLimitSwitch.get() && (elevator.getCurrentPower() < 0.0))) {
        // elevator.setPower(0.0);
        // }

        //ingestor.periodic();
        //ingestor.driveMotors(0.5);
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        // ingestor.retract();
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        // ingestor.retract();
    }

}
