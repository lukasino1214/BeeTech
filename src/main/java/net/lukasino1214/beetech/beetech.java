package net.lukasino1214.beetech;

//import stuff
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EquipmentSlot;

public class beetech implements ModInitializer {

    //block
    public static final Block COPPER_ORE = new OreSettings(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Block LEAD_ORE = new OreSettings(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Block LITHIUM_ORE = new OreSettings(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Block SILVER_ORE = new OreSettings(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Block TIN_ORE = new OreSettings(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Block ALUMINUM_ORE = new OreSettings(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Block COPPER_BLOCK = new OreSettings(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Block LEAD_BLOCK = new OreSettings(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Block LITHIUM_BLOCK = new OreSettings(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Block SILVER_BLOCK = new OreSettings(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Block TIN_BLOCK = new OreSettings(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Block ALUMINUM_BLOCK = new OreSettings(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));


    //item
    public static final Item honey_apple = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().saturationModifier(6).hunger(6).build()));
    public static final Item copper_ingot = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item lead_ingot = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item lithium_ingot = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item silver_ingot = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item tin_ingot = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item aluminum_ingot = new Item(new Item.Settings().group(ItemGroup.MISC));

    //armor
    public static final Item WOOL_HELMET = new ArmorItem(CustomArmorMaterial.WOOL, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item WOOL_CHESTPLATE = new ArmorItem(CustomArmorMaterial.WOOL, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item WOOL_LEGGINGS = new ArmorItem(CustomArmorMaterial.WOOL, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item WOOL_BOOTS = new ArmorItem(CustomArmorMaterial.WOOL, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));

    //generation ore
        private void handleBiome(Biome biome) {
        if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
            biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE,
                            beetech.COPPER_ORE.getDefaultState(),
                    8 //Ore vein size
               )).createDecoratedFeature(
                Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
                    8, //Number of veins per chunk
                    0, //Bottom Offset
                    0, //Min y level
                    64 //Max y level
            ))));
            biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE,
                            beetech.TIN_ORE.getDefaultState(),
                    8 //Ore vein size
               )).createDecoratedFeature(
                Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
                    8, //Number of veins per chunk
                    0, //Bottom Offset
                    0, //Min y level
                    64 //Max y level
            ))));
            biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE,
                            beetech.LEAD_ORE.getDefaultState(),
                    8 //Ore vein size
               )).createDecoratedFeature(
                Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
                    8, //Number of veins per chunk
                    0, //Bottom Offset
                    0, //Min y level
                    64 //Max y level
            ))));
            biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE,
                            beetech.ALUMINUM_ORE.getDefaultState(),
                    8 //Ore vein size
               )).createDecoratedFeature(
                Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
                    8, //Number of veins per chunk
                    0, //Bottom Offset
                    0, //Min y level
                    64 //Max y level
            ))));
            biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE,
                            beetech.LITHIUM_ORE.getDefaultState(),
                    24 //Ore vein size
               )).createDecoratedFeature(
                Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
                    8, //Number of veins per chunk
                    44, //Bottom Offset
                    0, //Min y level
                    64 //Max y level
            ))));
            biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE,
                            beetech.SILVER_ORE.getDefaultState(),
                    8 //Ore vein size
               )).createDecoratedFeature(
                Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
                    8, //Number of veins per chunk
                    0, //Bottom Offset
                    0, //Min y level
                    64 //Max y level
            ))));
        }
    }
    
    //chest STORAGE_BOX
    public static final Identifier STORAGE_BOX = new Identifier("beetech", "storage_box");
    public static final Block STORAGE_BOX_BLOCK = new StorageBoxBlock(FabricBlockSettings.of(Material.WOOD).build());
    public static final String STORAGE_BOX_TRANSLATION_KEY = Util.createTranslationKey("container", STORAGE_BOX);
 
    public static BlockEntityType<StorageBoxBlockEntity> STORAGE_BOX_ENTITY_TYPE;

    @Override
    public void onInitialize(){

        //chest
        Registry.register(Registry.BLOCK, STORAGE_BOX, STORAGE_BOX_BLOCK);
        Registry.register(Registry.ITEM, STORAGE_BOX, new BlockItem(STORAGE_BOX_BLOCK, new Item.Settings().group(ItemGroup.REDSTONE)));
        STORAGE_BOX_ENTITY_TYPE = Registry.register(Registry.BLOCK_ENTITY_TYPE, STORAGE_BOX, BlockEntityType.Builder.create(StorageBoxBlockEntity::new, STORAGE_BOX_BLOCK).build(null));
        ContainerProviderRegistry.INSTANCE.registerFactory(STORAGE_BOX, (syncId, identifier, player, buf) -> {
            final BlockEntity blockEntity = player.world.getBlockEntity(buf.readBlockPos());
            return((StorageBoxBlockEntity) blockEntity).createContainer(syncId, player.inventory);
        });

        //item
        Registry.register(Registry.ITEM, new Identifier("beetech", "honey_apple"), honey_apple);
        Registry.register(Registry.ITEM, new Identifier("beetech", "copper_ingot"), copper_ingot);
        Registry.register(Registry.ITEM, new Identifier("beetech", "lead_ingot"), lead_ingot);
        Registry.register(Registry.ITEM, new Identifier("beetech", "lithium_ingot"), lithium_ingot);
        Registry.register(Registry.ITEM, new Identifier("beetech", "silver_ingot"), silver_ingot);
        Registry.register(Registry.ITEM, new Identifier("beetech", "tin_ingot"), tin_ingot);
        Registry.register(Registry.ITEM, new Identifier("beetech", "aluminum_ingot"), aluminum_ingot);
        Registry.register(Registry.ITEM, new Identifier("beetech", "copper_ore"), new BlockItem(COPPER_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("beetech", "lead_ore"), new BlockItem(LEAD_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("beetech", "lithium_ore"), new BlockItem(LITHIUM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("beetech", "silver_ore"), new BlockItem(SILVER_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("beetech", "tin_ore"), new BlockItem(TIN_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("beetech", "aluminum_ore"), new BlockItem(ALUMINUM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("beetech", "copper_block"), new BlockItem(COPPER_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("beetech", "lead_block"), new BlockItem(LEAD_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("beetech", "lithium_block"), new BlockItem(LITHIUM_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("beetech", "silver_block"), new BlockItem(SILVER_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("beetech", "tin_block"), new BlockItem(TIN_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("beetech", "aluminum_block"), new BlockItem(ALUMINUM_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        //block
        Registry.register(Registry.BLOCK, new Identifier("beetech", "copper_ore"), COPPER_ORE);
        Registry.register(Registry.BLOCK, new Identifier("beetech", "lead_ore"), LEAD_ORE);
        Registry.register(Registry.BLOCK, new Identifier("beetech", "lithium_ore"), LITHIUM_ORE);
        Registry.register(Registry.BLOCK, new Identifier("beetech", "silver_ore"), SILVER_ORE);
        Registry.register(Registry.BLOCK, new Identifier("beetech", "tin_ore"), TIN_ORE);
        Registry.register(Registry.BLOCK, new Identifier("beetech", "aluminum_ore"), ALUMINUM_ORE);
        Registry.register(Registry.BLOCK, new Identifier("beetech", "copper_block"), COPPER_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("beetech", "lead_block"), LEAD_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("beetech", "lithium_block"), LITHIUM_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("beetech", "silver_block"), SILVER_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("beetech", "tin_block"), TIN_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("beetech", "aluminum_block"), ALUMINUM_BLOCK); 

        //armor
        Registry.register(Registry.ITEM,new Identifier("beetech","wool_helmet"), WOOL_HELMET);
        Registry.register(Registry.ITEM,new Identifier("beetech","wool_chestplate"), WOOL_CHESTPLATE);
        Registry.register(Registry.ITEM,new Identifier("beetech","wool_leggings"), WOOL_LEGGINGS);
        Registry.register(Registry.ITEM,new Identifier("beetech","wool_boots"), WOOL_BOOTS);

        //generation
        Registry.BIOME.forEach(this::handleBiome);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));

    }

}

