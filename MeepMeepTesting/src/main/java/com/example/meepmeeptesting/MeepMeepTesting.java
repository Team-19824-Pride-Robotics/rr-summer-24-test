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
                    //segment 1 - drives up to the sub and scores the preload
                // parallel with lift to score height
                    .lineToX(-36)

                    //segment 2 - backs off the sub and strafes right to clear it
                // parallel with lift to pickup position
                    .lineToX(-40)
                    .strafeTo(new Vector2d(-40, -35))

                //segment 3 - moves on a diagonal to get behind the sample
                    .setTangent(135)
                    .lineToX(-12)

                //segment 4 - spline path with a 180 built in, gets in position to push
                    .setTangent(0)
                    .splineToLinearHeading(new Pose2d(-10, -45, Math.toRadians(180)), Math.toRadians(180))

                //segment 5 - push two samples into the zone
                    .lineToX(-55)
                    .lineToX(-12)
                    .strafeTo(new Vector2d(-12, -55))
                    .setTangent(135)
                    .lineToX(-55)

                //segment 6 - slowly! to pick up the specimen
                    //.setTangent(135)
                    .lineToX(-62, new TranslationalVelConstraint(10))

                //segment 7 - spline path back to the sub with a 180
                //parallel with lift to scoring position
                    .lineToX(-50)
                    .splineToLinearHeading(new Pose2d(-36, -12, Math.toRadians(0)), Math.toRadians(0))

               //segment 8 - spline path back to the zone with a 180
                // parallel with lift to pickup position
                    .lineToX(-45)
                    .setTangent(0)
                    .splineToLinearHeading(new Pose2d(-55, -45, Math.toRadians(180)), Math.toRadians(180))

                //segment 6 - slowly! to pick up the specimen
                //.setTangent(135)
                .lineToX(-62, new TranslationalVelConstraint(10))

                //segment 7 - spline path back to the sub with a 180
                //parallel with lift to scoring position
                .lineToX(-50)
                .splineToLinearHeading(new Pose2d(-36, -16, Math.toRadians(0)), Math.toRadians(0))

                //segment 8 - spline path back to the zone with a 180
                // parallel with lift to pickup position
                .lineToX(-45)
                .setTangent(0)
                .splineToLinearHeading(new Pose2d(-55, -45, Math.toRadians(180)), Math.toRadians(180))

                //segment 6 - slowly! to pick up the specimen
                //.setTangent(135)
                .lineToX(-62, new TranslationalVelConstraint(10))

                //segment 7 - spline path back to the sub with a 180
                //parallel with lift to scoring position
                .lineToX(-50)
                .splineToLinearHeading(new Pose2d(-36, -20, Math.toRadians(0)), Math.toRadians(0))


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