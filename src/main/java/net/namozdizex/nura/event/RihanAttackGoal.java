package net.namozdizex.nura.event;

import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.namozdizex.nura.entity.Nurarihan;
import net.namozdizex.nura.entity.Nurarihyon;

public class RihanAttackGoal extends MeleeAttackGoal {
    private final Nurarihan nurarihan;
    private int raiseArmTicks;

    public RihanAttackGoal(Nurarihan nurarihan, double d, boolean bl) {
        super(nurarihan, d, bl);
        this.nurarihan = nurarihan;
    }

    public void start() {
        super.start();
        this.raiseArmTicks = 0;
    }

    public void stop() {
        super.stop();
        this.nurarihan.setAggressive(false);
    }

    public void tick() {
        super.tick();
        ++this.raiseArmTicks;
        if (this.raiseArmTicks >= 5 && this.getTicksUntilNextAttack() < this.getAttackInterval() / 2) {
            this.nurarihan.setAggressive(true);
        } else {
            this.nurarihan.setAggressive(false);
        }

    }
}
