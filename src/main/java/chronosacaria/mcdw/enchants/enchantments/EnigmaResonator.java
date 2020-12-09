package chronosacaria.mcdw.enchants.enchantments;

import chronosacaria.mcdw.Mcdw;
import chronosacaria.mcdw.configs.McdwConfig;
import chronosacaria.mcdw.enchants.types.DamageBoostEnchantment;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnigmaResonator extends DamageBoostEnchantment {
    McdwConfig config = AutoConfig.getConfigHolder(McdwConfig.class).getConfig();

    public EnigmaResonator(Rarity rarity, EnchantmentTarget enchantmentTarget, EquipmentSlot[] equipmentSlots) {
        super(rarity, enchantmentTarget, equipmentSlots);
        Registry.register(Registry.ENCHANTMENT, new Identifier(Mcdw.MOD_ID, "enigma_resonator"), this);

    }

    @Override
    public int getMaxLevel(){
        return 3;
    }

    @Override
    protected boolean canAccept (Enchantment other){
        return config.enableAOEMixing || !(other instanceof Leeching);
    }
}
