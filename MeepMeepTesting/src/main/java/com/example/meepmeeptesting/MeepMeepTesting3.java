package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TranslationalVelConstraint;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting3 {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-62, 8, Math.toRadians(90)))
                    //segment 1 - drives up to the basket and scores the preload
                // parallel with lift and arm/claw to score position, add wait time for score
                    .strafeToLinearHeading(new Vector2d(-58,58), Math.toRadians(135))
                    .waitSeconds(1)

                    //segment 2 - get in position to grab second sample
                // parallel with lift and arm/claw to pickup position
                    .strafeToLinearHeading(new Vector2d(-40, 46), Math.toRadians(180))

                //wait here while the intake does its intaking and transferring
                    .waitSeconds(2)

                //segment 3 - moves in position to score the sample
                // parallel with lift and arm/claw to score position, add wait time for score
                    .strafeToLinearHeading(new Vector2d(-58,58), Math.toRadians(135))
                    .waitSeconds(1)

                //segment 4 - strafe over for the third sample
                    .strafeToLinearHeading(new Vector2d(-40, 60), Math.toRadians(180))

                //wait here while the intake does its intaking and transferring
                    .waitSeconds(2)

                //segment 5 - moves in position to score the sample
                // parallel with lift and arm/claw to score position, add wait time for score
                    .strafeToLinearHeading(new Vector2d(-58,58), Math.toRadians(135))
                    .waitSeconds(1)

                //segment 6 - strafe to same position, new angle
                    .strafeToLinearHeading(new Vector2d(-40, 60), Math.toRadians(200))

                //wait here while the intake does its intaking and transferring
                .waitSeconds(2)

                //segment 7 - moves in position to score the sample
                // parallel with lift and arm/claw to score position, add wait time for score
                .strafeToLinearHeading(new Vector2d(-58,58), Math.toRadians(135))
                .waitSeconds(1)

                //segment 8 - park in ascent zone
                .strafeToLinearHeading(new Vector2d(-10,20), Math.toRadians(90))


                .build());



        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}