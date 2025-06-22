package com.example.examplemod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(MySkibidiMod.MOD_ID)
public class MySkibidiMod {
    public static final String MOD_ID = "lalala";
    private static final Logger LOGGER = LogUtils.getLogger();

    public final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public final RegistryObject<Block> SKIBIDI_BLOCK = BLOCKS.register("skibidi_block",
            () -> new Block(BlockBehaviour.Properties
                    .of()
                    .strength(4.0F, 6.0F)
                    .sound(SoundType.STONE)));

    public final RegistryObject<Item> SKIBIDI_BLOCK_ITEM = ITEMS.register("skibidi_block",
            () -> new BlockItem(SKIBIDI_BLOCK.get(), new Item.Properties()));

    public MySkibidiMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);

        LOGGER.info("Skibidi mod is loading!");
    }
}