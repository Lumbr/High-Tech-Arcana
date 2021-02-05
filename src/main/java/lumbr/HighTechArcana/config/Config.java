package lumbr.HighTechArcana.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import lumbr.HighTechArcana.HighTechArcana;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config
{
	private static final ForgeConfigSpec.Builder client_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec client_config;
	
	private static final ForgeConfigSpec.Builder server_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec server_config;
	
	static
	{
		client_config = client_builder.build();
		server_config = server_builder.build();
		
	}
	public static void loadConfig(ForgeConfigSpec config, String path)
	{
		HighTechArcana.logger.info("Loading config: " + path);
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		HighTechArcana.logger.info("Build config: " + path);
		file.load();
		HighTechArcana.logger.info("Loaded config: " + path);
		config.setConfig(file);
	}

}
