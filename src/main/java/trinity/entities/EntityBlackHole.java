package trinity.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class EntityBlackHole extends Entity {
	
    public static final DataParameter<Float> SCALE = EntityDataManager.<Float>createKey(EntityBlackHole.class, DataSerializers.FLOAT);
    public static final DataParameter<Integer> X = EntityDataManager.<Integer>createKey(EntityBlackHole.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> Y = EntityDataManager.<Integer>createKey(EntityBlackHole.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> Z = EntityDataManager.<Integer>createKey(EntityBlackHole.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> DIM = EntityDataManager.<Integer>createKey(EntityBlackHole.class, DataSerializers.VARINT);
    
    private final static Random random = new Random();
    
	public EntityBlackHole(World worldIn) {
		super(worldIn);
		this.ignoreFrustumCheck = true;
		this.isImmuneToFire = true;
	}
	
	public EntityBlackHole(World w, float scale, int dim, int x, int y, int z){
		this(w);
		this.getDataManager().set(SCALE, scale);
		this.getDataManager().set(X, x);
		this.getDataManager().set(Y, y);
		this.getDataManager().set(Z, z);
		this.getDataManager().set(DIM, dim);
	}

	
    @Override
	public void onUpdate() {
    	float scale = this.getDataManager().get(SCALE);
	    gravity(world, (int)this.posX, (int)this.posY, (int)this.posZ, (int)Math.ceil(scale * 15));
    }
    
    public static void gravity(World world, int x, int y, int z, int radius) {
		int i;
		int j;
		int k;
		double d5;
		double d6;
		double d7;
		double wat = radius;

		// bombStartStrength *= 2.0F;
		i = MathHelper.floor(x - wat - 1.0D);
		j = MathHelper.floor(x + wat + 1.0D);
		k = MathHelper.floor(y - wat - 1.0D);
		int i2 = MathHelper.floor(y + wat + 1.0D);
		int l = MathHelper.floor(z - wat - 1.0D);
		int j2 = MathHelper.floor(z + wat + 1.0D);
		List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(i, k, l, j, i2, j2));

		for (int i1 = 0; i1 < list.size(); ++i1) {
			Entity entity = (Entity) list.get(i1);
			
			if(entity instanceof EntityBlackHole)
				continue;
			
			double d4 = entity.getDistance(x, y, z) / radius;

			if (d4 <= 1.0D) {
				d5 = entity.posX - x;
				d6 = entity.posY + entity.getEyeHeight() - y;
				d7 = entity.posZ - z;
				double d9 = MathHelper.sqrt(d5 * d5 + d6 * d6 + d7 * d7);
				if (d9 < wat && !(entity instanceof EntityPlayer)) {// && ArmorUtil.checkArmor((EntityPlayer) entity, ModItems.euphemium_helmet, ModItems.euphemium_plate, ModItems.euphemium_legs, ModItems.euphemium_boots))) {
					d5 /= d9;
					d6 /= d9;
					d7 /= d9;
					
					if (!(entity instanceof EntityPlayer && ((EntityPlayer) entity).capabilities.isCreativeMode)) {
						double d8 = 0.125 + (random.nextDouble() * 0.25);
						entity.motionX -= d5 * d8;
						entity.motionY -= d6 * d8;
						entity.motionZ -= d7 * d8;
					}
				}
			}
		}
	}

	@Override
	protected void entityInit() {
		this.dataManager.register(SCALE, Float.valueOf(0));
		this.dataManager.register(DIM, Integer.valueOf(0));
		this.dataManager.register(X, Integer.valueOf(0));
		this.dataManager.register(Y, Integer.valueOf(0));
		this.dataManager.register(Z, Integer.valueOf(0));
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		setScale(p_70037_1_.getFloat("scale"));
		setScale(p_70037_1_.getInteger("dimension"));
		setScale(p_70037_1_.getInteger("X"));
		setScale(p_70037_1_.getInteger("Y"));
		setScale(p_70037_1_.getInteger("Z"));
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		p_70014_1_.setFloat("scale", getScale());
		p_70014_1_.setInteger("dimension", getDimension());
		p_70014_1_.setInteger("X", getX());
		p_70014_1_.setInteger("Y", getY());
		p_70014_1_.setInteger("Z", getZ());

	}
	public void setScale(float i) {

		this.dataManager.set(SCALE, Float.valueOf(i));
	}

	public float getScale() {

		float scale = this.dataManager.get(SCALE);
		
		return scale == 0 ? 1 : scale;
	}
	
	public void setDimension(int i) {

		this.dataManager.set(DIM, Integer.valueOf(i));
	}

	public int getDimension() {

		int dim = this.dataManager.get(DIM);
		
		return dim == 0 ? 1 : dim;
	}
	
	public void setX(int i) {

		this.dataManager.set(X, Integer.valueOf(i));
	}

	public int getX() {

		int x = this.dataManager.get(X);
		
		return x == 0 ? 1 : x;
	}
	
	public void setY(int i) {

		this.dataManager.set(Y, Integer.valueOf(i));
	}

	public int getY() {

		int y = this.dataManager.get(Y);
		
		return y == 0 ? 1 : y;
	}
	
	public void setZ(int i) {

		this.dataManager.set(Z, Integer.valueOf(i));
	}

	public int getZ() {

		int z = this.dataManager.get(Z);
		
		return z == 0 ? 1 : z;
	}
}
