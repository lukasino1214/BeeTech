package net.lukasino1214.beetech;

import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.container.Container;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class StorageBoxBlock extends BlockWithEntity {
    public StorageBoxBlock(Settings settings) {
        super(settings);
    }

    // We need to explicitly return a MODEL render type because BlockWithEntity has a side-effect of not showing the model.
    // You can also implement BlockEntityProvider Type to avoid this side-effect.
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    // We will create the BlockEntity later.
    public BlockEntity createBlockEntity(BlockView view) {
        return new StorageBoxBlockEntity();
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (itemStack.hasCustomName()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof StorageBoxBlockEntity) {
                ((StorageBoxBlockEntity)blockEntity).setCustomName(itemStack.getName());
            }
        }
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof StorageBoxBlockEntity) {
                ContainerProviderRegistry.INSTANCE.openContainer(beetech.STORAGE_BOX, player, buf -> buf.writeBlockPos(pos));
            }
        }
        return ActionResult.SUCCESS;
    }

    // Scatter the items in the chest when it is removed.
    public void onBlockRemoved(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof StorageBoxBlockEntity) {
                ItemScatterer.spawn(world, (BlockPos)pos, (Inventory)((StorageBoxBlockEntity)blockEntity));
                world.updateHorizontalAdjacent(pos, this);
            }
            super.onBlockRemoved(state, world, pos, newState, moved);
        }
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return Container.calculateComparatorOutput(world.getBlockEntity(pos));
    }
}