package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting2 {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-36, 58, Math.toRadians(270)))
                        //.setTangent(Math.toRadians(180))
                        .lineToY(15)
                        //.splineTo(new Vector2d(0, 29), Math.toRadians(90))
                        .splineTo(new Vector2d(-60, 10), Math.toRadians(180))
                        //.setTangent(0)
                        .lineToX(20)
                        .splineToConstantHeading(new Vector2d(50, 40), Math.toRadians(0))
                        .setTangent(Math.toRadians(270))
                        .splineToConstantHeading(new Vector2d(40, 10), Math.toRadians(0))
                        .lineToX(-60)
                        .lineToX(20)
                        .splineToConstantHeading(new Vector2d(50, 40), Math.toRadians(0))
                        .setTangent(Math.toRadians(270))
                        .lineToY(10)
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
