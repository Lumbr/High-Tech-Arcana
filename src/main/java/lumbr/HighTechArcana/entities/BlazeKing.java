package lumbr.HighTechArcana.entities;


import lumbr.HighTechArcana.lists.EntityList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;

import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class BlazeKing extends MonsterEntity 
{


	
	public BlazeKing(EntityType<? extends MonsterEntity> blazeKing, World worldIn)
	{
		super(blazeKing, worldIn);
		
	}
	@Override
	protected void registerGoals()
	{
		this.goalSelector.addGoal(0, new SwimGoal(this));
		//this.goalSelector.addGoal(0, new RandomWalkingGoal(this, 1.2d));
		this.goalSelector.addGoal(0, new LookRandomlyGoal(this));
		
		
	}

	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes()
    {
		
        return MonsterEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 100.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
        
    }
	
}
