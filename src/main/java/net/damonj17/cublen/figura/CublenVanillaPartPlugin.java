package net.damonj17.cublen.figura;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.ModelPart;
import org.figuramc.figura.entries.FiguraVanillaPart;
import org.figuramc.figura.entries.annotations.FiguraVanillaPartPlugin;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
 * Cublen Vanilla Part Plugin
 *  Annotation required for Forge to Locate and Load the Plugin
 *  Entrypoint in fabric.mod.json: figura_vanilla_part
 */
@FiguraVanillaPartPlugin
public class CublenVanillaPartPlugin implements FiguraVanillaPart {
    @Override
    public String getID() {
        return CublenPlugin.PLUGIN_ID;
    }

    /**
     *  Available so that other mods can add in Model Parts to figura, you'd obviously do something different here.
     */
    @Override
    public Collection<Pair<String, Function<EntityModel<?>, ModelPart>>> getParts() {
        return List.of(new Pair<>("cublen_part", entityModel -> entityModel instanceof HorseModel<?> ? (ModelPart) ((HorseModel) entityModel).headParts().iterator().next() : null));
    }
}
