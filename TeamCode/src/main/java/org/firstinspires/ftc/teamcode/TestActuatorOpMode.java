package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.HardwareDevice;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.ShooterCom;
import org.firstinspires.ftc.teamcode.subbys.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subbys.ShooterSubby;

@TeleOp(name = "hanger")
public class TestActuatorOpMode extends CommandOpMode {
//    private Motor hang, arm;
    private Motor fL, bL, fR, bR;
    private SimpleServo shooter;
//    private SimpleServo left_claw;
//    private SimpleServo right_claw;
    private DriveSubsystem driveS;
    private DriveCommand driveC;

    private GamepadEx gpad;
    @Override
    public void initialize() {
//        hang = new Motor(hardwareMap, "hang");
//        arm = new Motor(hardwareMap, "arm");
        fL = new Motor(hardwareMap, "fL");
        fR = new Motor(hardwareMap, "fR");
        bL = new Motor(hardwareMap, "bL");
        bR = new Motor(hardwareMap, "bR");

//        shooter = new SimpleServo(hardwareMap, "s", -180, 180);
//        left_claw = new SimpleServo(hardwareMap, "lc", -180, 180);
//        right_claw = new SimpleServo(hardwareMap, "rc", -180, 180);


        fL.motor.setDirection(DcMotor.Direction.FORWARD);
        fR.motor.setDirection(DcMotor.Direction.FORWARD);
        bL.motor.setDirection(DcMotor.Direction.FORWARD);
        bR.motor.setDirection(DcMotor.Direction.FORWARD);

//        arm.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        hang.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

//        right_claw.setInverted(true);
//        left_claw.setInverted(true);
        fL.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fR.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bL.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bR.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        gpad = new GamepadEx(gamepad1);

//        gpad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenHeld(
//                new InstantCommand(() -> hang.set(1))).whenReleased(new InstantCommand(() -> hang.set(0)));
//
//        gpad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenHeld(
//                new InstantCommand(() -> hang.set(-1))).whenReleased(new InstantCommand(() -> hang.set(0)));
//
//        gpad.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenHeld(
//                new InstantCommand(() -> arm.set(0.4))).whenReleased(new InstantCommand(() -> arm.set(0)));
//
//        gpad.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenHeld(
//                new InstantCommand(() -> arm.set(-0.4))).whenReleased(new InstantCommand(() -> arm.set(0)));

//        gpad.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenPressed(
//                new InstantCommand(() -> shooter.setPosition(-1)).andThen(new WaitCommand(350)).andThen(
//                new InstantCommand(()  -> shooter.turnToAngle(0)))
//        );
//
//        gpad.getGamepadButton(GamepadKeys.Button.X).toggleWhenPressed(
//                new RunCommand(() -> left_claw.turnToAngle(-50)),
//                new RunCommand(() -> left_claw.turnToAngle(45))
//        );
//
//        gpad.getGamepadButton(GamepadKeys.Button.B).toggleWhenPressed(
//                new InstantCommand(() -> right_claw.setPosition(0.3)),
//                new InstantCommand(() -> right_claw.setPosition(0.7))
//        );



        driveS = new DriveSubsystem(fL, fR, bL, bR);
        driveC = new DriveCommand(driveS, gpad::getLeftX, gpad::getLeftY, gpad::getRightX, 1.0);


        register(driveS);
        driveS.setDefaultCommand(driveC);

        schedule(new RunCommand(() ->{
//            telemetry.addData("left: ", left_claw.getPosition());
//            telemetry.addData("left: ", left_claw.getAngle());
            telemetry.update();
        }));

    }

}
