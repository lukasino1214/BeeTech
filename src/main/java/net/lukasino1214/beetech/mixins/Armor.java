package net.lukasino1214.beetech.mixins;

import net.lukasino1214.beetech.beetech;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AbstractEntityAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DefaultedList;
import net.minecraft.world.World;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.effect.StatusEffects;
/*import net.minecraft.advancement.criterion.Criterions;
import net.minecraft.item.Item.Settings;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.server.command.EffectCommand;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;*/

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class Armor extends Entity {

    private AbstractEntityAttributeContainer attributes;

    @Shadow
    @Final
    private DefaultedList<ItemStack> equippedArmor;

    public Armor(final EntityType<?> type, final World world, final StatusEffect effect) {
        super(type, world);
        this.initAttributes();
    }

    @Inject(method = { "tick" }, at = @At("HEAD"))
    private void tick(final CallbackInfo callbackInfo) {
        final ItemStack helmetStack = equippedArmor.get(3);
        final ItemStack chestplateStack = equippedArmor.get(2);
        final ItemStack leggingsStack = equippedArmor.get(1);
        final ItemStack bootsStack = equippedArmor.get(0);
        //final LivingEntity player = new LivingEntity();

        if (helmetStack.getItem().equals(beetech.WOOL_HELMET)) {

            if (chestplateStack.getItem().equals(beetech.WOOL_CHESTPLATE)) {

                if (leggingsStack.getItem().equals(beetech.WOOL_LEGGINGS)) {

                    if (bootsStack.getItem().equals(beetech.WOOL_BOOTS)) {

                        //effect.getEffectType().onRemoved(this, this.getAttributes(), effect.getAmplifier());
                                //effect.getEffectType().onRemoved(this, this.getAttributes(), effect.getAmplifier());

                                /*if (!this.world.isClient) {
                                    effect.getEffectType().onRemoved(this, this.getAttributes(), effect.getAmplifier());
                                }*/
                                /*@Overwrite
                                public void onStatusEffectRemoved(StatusEffectInstance effect) {
                                    if (!this.world.isClient) {
                                        StatusEffectInstance.getEffectType().onRemoved(this, this.getAttributes(), effect.getAmplifier());
                                    }
                            
                                }*/

                               //StatusEffectInstance.onRemoved(this, this.getAttributes(), 2);
                               StatusEffect.getEffectType().onStatusEffectRemoved();


                            }
                        
                    }
                }
            }
        }
    

    public AbstractEntityAttributeContainer getAttributes() {
        if (this.attributes == null) {
            this.attributes = new EntityAttributeContainer();
        }
    
        return this.attributes;
    }
    
    protected void initAttributes() {
        this.getAttributes().register(EntityAttributes.MAX_HEALTH);
        this.getAttributes().register(EntityAttributes.KNOCKBACK_RESISTANCE);
        this.getAttributes().register(EntityAttributes.MOVEMENT_SPEED);
        this.getAttributes().register(EntityAttributes.ARMOR);
        this.getAttributes().register(EntityAttributes.ARMOR_TOUGHNESS);
    }

}

                        //PlayerEntity.clearStatusEffect(EffectData.class(Poiso));
                        //really stupid
                        //PlayerEntity.clearStatusEffects();
                       // PlayerEntity.onStatusEffectRemoved(StatusEffects.POISON);
                        //PlayerEntity.clearStatusEffects(StatusEffects.POISON);
                        //layerEntity.clearStatusEffects(StatusEffect.POISON);