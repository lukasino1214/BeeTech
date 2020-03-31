package net.lukasino1214.beetech;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class OreSettings extends Block {
    
    public OreSettings(net.minecraft.item.Item.Settings BUILDING_BLOCKS) {
        super(FabricBlockSettings.of(Material.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).strength(3, 0.6f).build());
    }

}