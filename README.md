# Better Combat Vanillas

A small server-side NeoForge mod that restores vanilla combat behavior for selected vanilla items while using Better Combat. It removes exact item IDs from Better Combat's `WeaponRegistry` after weapon attributes and fallback compatibility load, immediately before Better Combat encodes the registry for its normal client sync. The Better Combat JAR is not modified.

## Compatibility

- Minecraft 1.21.1
- NeoForge 21.1.225 or newer in the 1.21.1 line
- Better Combat `2.4.0+1.21.1` (NeoForge)
- Java 21

## Installation

Install Better Combat and its required dependencies on both the server and clients. Put the Better Combat Vanillas JAR in the **server's** `mods` directory only. Clients do not need this additional mod. Its NeoForge metadata uses `displayTest="IGNORE_SERVER_VERSION"` so its absence on clients does not cause a version mismatch.

Currently only the vanilla Mace is excluded. More vanilla items may be supported later. The list lives in `VanillaItemExclusions`; IDs include the `minecraft` namespace, so modded maces, hammers, flails, and other items are not matched by name.

## Build

Run `./gradlew build` with Java 21. The output is `build/libs/bettercombat_vanillas-1.0.0.jar`.

Gradle downloads Better Combat `2.4.0+1.21.1-neoforge` from Modrinth Maven for compilation. That JAR is not bundled into the output or committed to this repository.

For a development server, run `./gradlew runServer` after supplying Better Combat and its required dependencies in the run environment and accepting the Minecraft EULA.

## How it works

The Mixin hooks `BetterCombatMod.loadWeaponAttributes(MinecraftServer)` at its call to `WeaponRegistry.encodeRegistry()`. At that point Better Combat has loaded both resource-defined weapon attributes and fallback registrations. The exclusion helper removes `minecraft:mace` from both the `containers` and `registrations` maps. Better Combat then encodes and syncs the filtered registry to clients. The exclusion list is kept in one place for future additions or a future config file.

## License

MIT. See [LICENSE](LICENSE).
