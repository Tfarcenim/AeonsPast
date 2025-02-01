package com.javisel.common.effects.buffs.spell;

import com.javisel.common.combat.APDamageSource;
import com.javisel.common.effects.ComplexEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class TrueStrikeSpellBuff extends ComplexEffect {
    public TrueStrikeSpellBuff() {
        super(MobEffectCategory.BENEFICIAL, 123);
    }


    @Override
    public void onHitEffect(LivingEntity attacker, LivingEntity blocker, APDamageSource damageSource) {


        DamageInstance instance = damageSource.instance;

        if (instance.doesProcWeaponHitEffects() && instance.getDamageDevice() instanceof ItemStack) {


            float damage = (float) (instance.getBaseAmount() * 0.60f);

            DamageInstance damageInstance =   DamageInstance.getGenericProcInstance(DamageTypeEnum.TRUE, damage);
            APEntityDamageSource apEntityDamageSource = new APEntityDamageSource(damageSource.getMsgId(), damageInstance, attacker);
            blocker.hurt(apEntityDamageSource, damage);
            consumeEffect(attacker);

        }
    }

}
