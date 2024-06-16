package org.firstinspires.ftc.teamcode.auto;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Lift {
    private Servo lift;

    public Lift(HardwareMap hardwareMap) {
        lift = hardwareMap.get(Servo.class, "lift");
//        lift.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//        lift.setDirection(DcMotorEx.Direction.FORWARD);
    }
    public class LiftUp implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            lift.setPosition(0.55);
            return false;
        }
    }
    public Action liftUp() {
        return new LiftUp();
    }

    public class LiftDown implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            lift.setPosition(0.8);
            return false;
        }
    }
    public Action liftDown(){
        return new LiftDown();
    }
}
