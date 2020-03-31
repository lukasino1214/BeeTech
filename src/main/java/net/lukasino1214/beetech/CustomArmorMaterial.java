package net.lukasino1214.beetech;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.sound.SoundEvent;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.recipe.Ingredient;
import java.util.function.Supplier;
import net.minecraft.util.Lazy;

public enum CustomArmorMaterial implements ArmorMaterial {
    WOOL("wool", 5, new int[] { 1, 3, 2, 1 }, 15, SoundEvents.BLOCK_WOOL_PLACE, 0.0F, () -> {
        return Ingredient.ofItems(Items.WHITE_WOOL);
    });

    private static final int[] baseDurability = { 13, 15, 16, 11 };
    private static final int[] protectionAmounts = { 2, 5, 6, 3 };
    private final String name;
    private final int durabilityMultiplier;
    private final int[] armorValues;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final Lazy<Ingredient> repairIngredient;

    CustomArmorMaterial(String name, int durabilityMultiplier, int[] armorValueArr, int enchantability,
            SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.armorValues = armorValueArr;
        this.enchantability = enchantability;
        this.equipSound = soundEvent;
        this.toughness = toughness;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    public int[] getArmorValues() {
        return armorValues;
    }

    public int getDurability(EquipmentSlot equipmentSlot_1) {
        return baseDurability[equipmentSlot_1.getEntitySlotId()] * this.durabilityMultiplier;
    }
 
    public int getProtectionAmount(EquipmentSlot equipmentSlot_1) {
        return protectionAmounts[equipmentSlot_1.getEntitySlotId()];
    }
 
    public int getEnchantability() {
        return this.enchantability;
    }
 
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }
 
    @Override
    public Ingredient getRepairIngredient() {
        // We needed to make it a Lazy type so we can actually get the Ingredient from the Supplier.
        return (Ingredient)this.repairIngredient.get();
    }
 
    @Override
    public String getName() {
        return this.name;
    }
 
    public float getToughness() {
        return this.toughness;
    }
}