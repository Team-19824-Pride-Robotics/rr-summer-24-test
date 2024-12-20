package org.firstinspires.ftc.teamcode;

// RR-specific imports

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.auto.Claw;
import org.firstinspires.ftc.teamcode.auto.Lift;

@Config
@Autonomous(name = "Auto_Summer_24", group = "Autonomous")
public class testing_thing extends LinearOpMode {

    //some variables we might need to tweak
    public static double turnAmt = 180;
    public static double finalHeading = 190;


    /***********************************************************
     First we'll map out our trajectories. This is where we can
     choose a path based on the location of our team element
     ***********************************************************/

    @Override
    public void runOpMode() throws InterruptedException {

        // instantiate your MecanumDrive at a particular pose.
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, Math.toRadians(0)));
        // make a Claw instance
        Claw claw = new Claw(hardwareMap);
        // make a Lift instance
        Lift lift = new Lift(hardwareMap);

        // vision here that outputs position
        int visionOutputPosition = 1;


        Action trajectoryAction1;
        Action trajectoryAction2;
        Action trajectoryAction3;
        Action trajectoryActionCloseOut;

        trajectoryAction1 = drive.actionBuilder(drive.pose)
                .setTangent(0)
                .splineToConstantHeading(new Vector2d(10, 48), Math.toRadians(0))
                //.splineTo(new Vector2d(10, 48), Math.toRadians(0))
                .strafeTo(new Vector2d(20, -40))
                //.lineToY(12)
                //.turn(Math.toRadians(turnAmt))
                //.lineToX(0)
                //.waitSeconds(3)
                .build();
        trajectoryAction2 = drive.actionBuilder(drive.pose)
//                .lineToY(37)
//                .setTangent(Math.toRadians(0))
//                .lineToX(18)
//                .waitSeconds(3)
//                .setTangent(Math.toRadians(0))
//                .lineToXSplineHeading(46, Math.toRadians(180))
                .waitSeconds(3)
                .build();
        trajectoryAction3 = drive.actionBuilder(drive.pose)
//                .lineToYSplineHeading(33, Math.toRadians(180))
//                .waitSeconds(2)
//                .strafeTo(new Vector2d(46, 30))
                .waitSeconds(3)
                .build();
        trajectoryActionCloseOut = drive.actionBuilder(drive.pose)
                //.strafeTo(new Vector2d(10, -20))
                //.turnTo(finalHeading)
                .waitSeconds(2)
                .build();

        // actions that need to happen on init; for instance, a claw tightening.
        Actions.runBlocking(claw.closeClaw());


        //this loop runs during init to give the sensors or camera time to find the team
        //element and set the position so that we know which trajectory to run
        while (!isStopRequested() && !opModeIsActive()) {
            int position = visionOutputPosition;
            telemetry.addData("Position during Init", position);
            telemetry.update();
        }

        /***********************************************************
         Now the auto period has started. We can choose a trajectory
         and then run it along with the necessary mechanism movements
         ***********************************************************/

        //set the position of the team element based on the output of the sensor or camera
        int startPosition = visionOutputPosition;
        telemetry.addData("Starting Position", startPosition);
        telemetry.update();
        waitForStart();

        if (isStopRequested()) return;

        Action trajectoryActionChosen;
        if (startPosition == 1) {
            trajectoryActionChosen = trajectoryAction1;
        } else if (startPosition == 2) {
            trajectoryActionChosen = trajectoryAction2;
        } else {
            trajectoryActionChosen = trajectoryAction3;
        }

        //check out the "Actions" section of the docs for an example using parallel actions
        //Actions like a lift going up could usually happen in parallel with a trajectory
        Actions.runBlocking(new SequentialAction(
                trajectoryActionChosen,
                //claw.openClaw(),
                //if an action needs time to run (like a claw opening), use a SleepAction
                new SleepAction(2),
                trajectoryActionCloseOut));


    }
}
