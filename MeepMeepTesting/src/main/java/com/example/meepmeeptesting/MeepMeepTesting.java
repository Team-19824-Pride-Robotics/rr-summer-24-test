package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TranslationalVelConstraint;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-62, -8, 0))
                    //segment 1 - parallel with raise lift and arm at score height
                    .lineToX(-36)
                    //segment 2 - parallel with lift to pickup position
                    .lineToX(-50)

                    .setTangent(0)
                   // .splineTo(new Vector2d(-55, -45), Math.toRadians(180))
                    .splineToLinearHeading(new Pose2d(-55, -45, Math.toRadians(180)), Math.toRadians(180))


                    //.turn(Math.toRadians(-180))
                    //segment 3 - slowly!
                    .lineToX(-62, new TranslationalVelConstraint(5))
                    //segment 4 - back off the wall and turn
                    .lineToX(-50)
                    .splineToLinearHeading(new Pose2d(-36, -12, Math.toRadians(0)), Math.toRadians(0))

                .lineToX(-50)

                .setTangent(0)
                // .splineTo(new Vector2d(-55, -45), Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-55, -45, Math.toRadians(180)), Math.toRadians(180))
                //segment 3 - slowly!
                .lineToX(-62, new TranslationalVelConstraint(5))
                //segment 4 - back off the wall and turn
                .lineToX(-50)
                .splineToLinearHeading(new Pose2d(-36, -12, Math.toRadians(0)), Math.toRadians(0))





//                    .turn(Math.toRadians(-180))
                    //segment 5 - parallel with raise lift and arm at score height
                   // .splineToSplineHeading(new Pose2d(-36, -12, Math.toRadians(0))
//                //segment 2 - parallel with lift to pickup position
//                .lineToX(-44)
//                .turn(Math.toRadians(-180))
//                .setTangent(0)
//                .splineToConstantHeading(new Vector2d(-55, -45), Math.toRadians(180))
//                //segment 3 - slowly!
//                .lineToX(-62, new TranslationalVelConstraint(5))
//                //segment 4 - back off the wall and turn
//                .lineToX(-50)
//                //.turn(Math.toRadians(-180))
//                //segment 5 - parallel with raise lift and arm at score height
//                        .setTangent(Math.toRadians(-90))
//                .splineToConstantHeading(new Vector2d(-36, -16), Math.toRadians(0))
//                //segment 2 - parallel with lift to pickup position
//                .lineToX(-44)
//                .turn(Math.toRadians(-180))
//                .setTangent(0)
//                .splineToConstantHeading(new Vector2d(-55, -45), Math.toRadians(180))
//                //segment 3 - slowly!
//                .lineToX(-62, new TranslationalVelConstraint(5))




    //                .strafeTo(new Vector2d(-36, -16))
    //                .splineToConstantHeading(new Vector2d(0, -40), Math.toRadians(0))
    //                .turn(Math.toRadians(180))
    //                .splineToConstantHeading(new Vector2d(-55, -45), Math.toRadians(180))
    //                .splineToConstantHeading(new Vector2d(0, -45), Math.toRadians(180))

    //                .lineToY(30)
    //                .turn(Math.toRadians(90))
    //                .lineToX(0)
    //                .turn(Math.toRadians(90))
    //                .lineToY(0)
    //                .turn(Math.toRadians(90))
                    .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}