package ram.talia.moreiotas.forge

import at.petrak.hexcasting.api.HexAPI
import at.petrak.hexcasting.api.PatternRegistry
import at.petrak.hexcasting.api.spell.Action
import at.petrak.hexcasting.api.spell.iota.PatternIota
import at.petrak.hexcasting.api.spell.math.HexDir
import at.petrak.hexcasting.api.spell.math.HexPattern
import at.petrak.hexcasting.common.casting.operators.eval.OpEval
import at.petrak.hexcasting.common.casting.operators.lists.OpIndex
import at.petrak.hexcasting.common.casting.operators.lists.OpSplat
import at.petrak.hexcasting.common.casting.operators.math.logic.OpBoolIf
import at.petrak.hexcasting.common.casting.operators.spells.OpPrint
import at.petrak.hexcasting.common.casting.operators.stack.OpDuplicate
import at.petrak.hexcasting.common.casting.operators.stack.OpSwap
import net.minecraft.resources.ResourceLocation
import ram.talia.moreiotas.api.MoreIotasAPI

object Patterns {
	@JvmField
	val REVEAL = patternOf(OpPrint)

	@JvmField
	val COMPASS = patternOf(HexAPI.modLoc("entity_pos/foot"))

	@JvmField
	val DROP = PatternIota(HexPattern.fromAngles("a", HexDir.SOUTH_EAST))
	@JvmField
	val SWAP = patternOf(OpSwap)

	@JvmField
	val EQUALITY = patternOf(HexAPI.modLoc("equals"))
	@JvmField
	val INEQUALITY = patternOf(HexAPI.modLoc("not_equals"))
	@JvmField
	val AUGERS = patternOf(OpBoolIf)

	@JvmField
	val NULLARY = patternOf(HexAPI.modLoc("const/null"))

	@JvmField
	val ZERO = PatternIota(HexPattern.fromAngles("aqaa", HexDir.EAST))
	@JvmField
	val ONE = PatternIota(HexPattern.fromAngles("aqaaw", HexDir.EAST))
	@JvmField
	val FOUR = PatternIota(HexPattern.fromAngles("aqaawaa", HexDir.EAST))

	@JvmField
	val GEMINIS_DISINTEGRATION = patternOf(OpDuplicate)
	@JvmField
	val FLOCKS_DISINTEGRATION = patternOf(OpSplat)

	@JvmField
	val SELECTION_DISTILLATION = patternOf(OpIndex)

	@JvmField
	val HERMES = patternOf(OpEval)

	@JvmField
	val INTRO = PatternIota(HexPattern.fromAngles("qqq", HexDir.WEST))
	@JvmField
	val RETRO = PatternIota(HexPattern.fromAngles("eee", HexDir.EAST))


	private fun patternOf(op: Action): PatternIota = PatternIota(PatternRegistry.lookupPattern(PatternRegistry.lookupPattern(op)!!).prototype)
	private fun patternOf(loc: ResourceLocation): PatternIota = PatternIota(PatternRegistry.lookupPattern(loc).prototype)
}