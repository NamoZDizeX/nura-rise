package net.namozdizex.nura.event;

import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.namozdizex.nura.entity.Nurarihyon;

public class RihyonAttackGoal extends MeleeAttackGoal {
    private final Nurarihyon nurarihyon;
    private int raiseArmTicks;

    public RihyonAttackGoal(Nurarihyon nurarihyon, double d, boolean bl) {
        super(nurarihyon, d, bl);
        this.nurarihyon = nurarihyon;
    }

    public void start() {
        super.start();
        this.raiseArmTicks = 0;
    }

    public void stop() {
        super.stop();
        this.nurarihyon.setAggressive(false);
    }

    public void tick() {
        super.tick();
        ++this.raiseArmTicks;
        if (this.raiseArmTicks >= 5 && this.getTicksUntilNextAttack() < this.getAttackInterval() / 2) {
            this.nurarihyon.setAggressive(true);
        } else {
            this.nurarihyon.setAggressive(false);
        }

    }
}
