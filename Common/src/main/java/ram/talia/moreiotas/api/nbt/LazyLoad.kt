package ram.talia.moreiotas.api.nbt

import net.minecraft.nbt.Tag

@Suppress("UNCHECKED_CAST")
abstract class LazyLoad<L, U : Tag> private constructor(private var isLoaded: Boolean) {
	private var loaded: L? = null
	private var unloaded: U? = null

	constructor(default: L) : this(true) {
		loaded = default
	}

	constructor(default: U) : this(false) {
		unloaded = default
	}

	abstract fun load(unloaded: U): L?
	abstract fun unload(loaded: L): U

	fun set(it: L) {
		loaded = it
		unloaded = null
		isLoaded = true
	}

	fun set(it: U) {
		loaded = null
		unloaded = it
		isLoaded = false
	}

	// casts used here to get rid of problems with loaded/unloaded being null. The way I've got set written, one of them is guaranteed to be non-null (*unless U or L is
	// a nullable type*), meaning the conversion to U/L will work fine.
	open fun get(): L? = if (isLoaded) loaded else { loaded = load(unloaded as U) ; unloaded = null ; isLoaded = true ; loaded }
	open fun getUnloaded(): U = if (isLoaded) unload(loaded as L) else unloaded as U
}