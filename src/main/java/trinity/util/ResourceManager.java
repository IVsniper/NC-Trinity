package trinity.util;

import net.minecraft.util.ResourceLocation;
import trinity.Global;
import trinity.render.AdvancedModelLoader;
import trinity.render.IModelCustom;

public class ResourceManager {
	
	// Sphere
	public static final IModelCustom sphere_ruv = AdvancedModelLoader.loadModel(new ResourceLocation(Global.MOD_ID, "models/sphere_ruv.obj"));
	public static final IModelCustom sphere_iuv = AdvancedModelLoader.loadModel(new ResourceLocation(Global.MOD_ID, "models/sphere_iuv.obj"));
	public static final IModelCustom sphere_uv = AdvancedModelLoader.loadModel(new ResourceLocation(Global.MOD_ID, "models/sphere_uv.obj"));
	public static final IModelCustom sphere_uv_anim = AdvancedModelLoader.loadModel(new ResourceLocation(Global.MOD_ID, "models/sphere_uv.hmf"));
	public static final ResourceLocation objTesterModelRL = new ResourceLocation(/*"/assets/" + */Global.MOD_ID, "models/mush.hmf");
	public static final ResourceLocation ringModelRL = new ResourceLocation(/*"/assets/" + */Global.MOD_ID, "models/Ring.obj");
	public static final ResourceLocation ringBigModelRL = new ResourceLocation(/*"/assets/" + */Global.MOD_ID, "models/RingBig.obj");
	public static final ResourceLocation sphere = new ResourceLocation(/*"/assets/" + */Global.MOD_ID, "models/sphere.obj");
	// Blast
	public static final ResourceLocation fireball = new ResourceLocation(Global.MOD_ID, "textures/models/fireball2.png");
	public static final ResourceLocation balefire = new ResourceLocation(Global.MOD_ID, "textures/models/balefire.png");
	public static final ResourceLocation blackhole = new ResourceLocation(Global.MOD_ID, "textures/models/black.png");
	public static final ResourceLocation whitehole = new ResourceLocation(Global.MOD_ID, "textures/models/white.png");
	// public static final ResourceLocation shockwave = new ResourceLocation(Global.MOD_ID, "textures/models/shockwave.png");
	public static final ResourceLocation disk = new ResourceLocation(Global.MOD_ID, "textures/models/disk.png");
	
	public static void init() {}
}
