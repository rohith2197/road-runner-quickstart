package org.firstinspires.ftc.teamcode.subbys;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class DriveSubsystem extends SubsystemBase {
    private Motor fL, fR, bL, bR;
    private MecanumDrive mDrive;
    public DriveSubsystem(Motor frontLeft, Motor frontRight, Motor backLeft, Motor backRight){
        fL = frontLeft;
        fR = frontRight;
        bL = backLeft;
        bR = backRight;

        mDrive = new MecanumDrive(fL, fR, bL, bR);
    }

    public void drive(double strafeSpeed, double forwardSpeed, double turnSpeed){
        mDrive.driveRobotCentric(strafeSpeed, forwardSpeed, -turnSpeed, true);
    }
}