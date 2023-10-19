package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "hangerAuton")
public class TestActuatorAuton extends CommandOpMode {
    private Motor hang;
    private GamepadEx gpad;
    @Override
    public void initialize() {
        hang = new Motor(hardwareMap, "hang");
        hang.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        gpad = new GamepadEx(gamepad1);

        gpad.getGamepadButton(GamepadKeys.Button.DPAD_UP).toggleWhenPressed(
                new InstantCommand(() -> hang.set(1)), new InstantCommand(() -> hang.set(0)));

        gpad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).toggleWhenPressed(
                new InstantCommand(() -> hang.set(-1)), new InstantCommand(() -> hang.set(0)));

        schedule(
            new WaitUntilCommand(this::isStarted)
                .andThen(new ParallelCommandGroup(
                    new InstantCommand(() -> hang.set(1))
                )).andThen(
                    new WaitCommand(1220))
                .andThen(new ParallelCommandGroup(
                    new InstantCommand(() -> hang.stopMotor())
                    )
                )
                    .andThen(new WaitCommand(500))
                    .andThen(new ParallelCommandGroup(
                            new InstantCommand(() -> hang.set(-1))
                    )).andThen(
                            new WaitCommand(1220))
                    .andThen(new ParallelCommandGroup(
                                    new InstantCommand(() -> hang.stopMotor())
                            )
                    )
        );
    }
}
