# Smart Item Highlight

Smart Item Highlight is a lightweight client-side Fabric mod that makes finding matching items inside storage screens easier.

When you pick up an item with your cursor, every other occurrence of that item is covered with a translucent light-green overlay. Matching items are highlighted in both the open container and your own inventory.

## Features

* Highlights every matching occurrence of the held item
* Highlights items in both the container and player inventory
* Works with the hotbar
* Activates automatically when an item is attached to the cursor
* Uses a subtle translucent light-green overlay
* Matches items by item type
* Fully client-side
* No commands, configuration or keybinds required

## Supported Screens

Smart Item Highlight works with standard Minecraft container screens, including:

* Chests
* Double chests
* Barrels
* Shulker boxes
* Hoppers
* Dispensers
* Droppers
* Other standard inventory-based container screens

Support for modded storage screens may depend on how those screens are implemented.

## Requirements

* Minecraft 1.21.11, 26.1.x or 26.2.x
* Fabric Loader
* Fabric API

The mod only needs to be installed on the player's client. It does not need to be installed on the server.

## Installation

1. Install Fabric Loader for your Minecraft version.
2. Download and install Fabric API.
3. Download the Smart Item Highlight `.jar` whose filename matches your Minecraft version.
4. Place the `.jar` file inside your Minecraft `mods` folder.
5. Launch Minecraft using the Fabric profile.

On Windows, the default Minecraft mods folder is usually:

```text
%appdata%\.minecraft\mods
```

## Usage

1. Open a supported container.
2. Pick up an item so it is attached to your cursor.
3. Every other slot containing the same item will be highlighted.
4. Place the item back into a slot to remove the highlights.

No setup is required.

## Item Matching

Items are matched by their item type.

This means the mod currently ignores differences such as:

* Stack size
* Durability
* Custom names
* Enchantments
* Other item data

For example, holding one diamond pickaxe will highlight other diamond pickaxes, even when they have different durability or enchantments.

## Building From Source

### Requirements

* Java Development Kit 25 (also produces Java 21 bytecode for the 1.21.11 build)
* Git

Clone the repository:

```bash
git clone https://github.com/YOUR-USERNAME/smart-item-highlight.git
cd smart-item-highlight
```

Build all supported versions on Windows:

```bat
gradlew.bat buildAllVersions
```

Build all supported versions on Linux or macOS:

```bash
./gradlew buildAllVersions
```

Running the regular `build` task builds the default Minecraft 26.2 artifact only.

The compiled mod will be created inside:

```text
build/libs
```

The versioned release JARs are:

* `smart-item-highlight-1.21.11-<mod-version>.jar`
* `smart-item-highlight-26.1-<mod-version>.jar` (supports the 26.1.x line)
* `smart-item-highlight-26.2-<mod-version>.jar` (supports the 26.2.x line)

Use the `.jar` files that do not include `-sources` in their filenames.

## Project Structure

```text
smart-item-highlight
├── src
│   ├── client
│   │   ├── java
│   │   │   └── com
│   │   │       └── haittorr
│   │   │           └── smartitemhighlight
│   │   │               └── client
│   │   │                   ├── SmartItemHighlightClient.java
│   │   │                   ├── mixin
│   │   │                   │   └── AbstractContainerScreenAccessor.java
│   │   │                   └── render
│   │   │                       └── SlotHighlightRenderer.java
│   │   └── resources
│   │       └── smartitemhighlight.client.mixins.json
│   └── main
│       └── resources
│           └── fabric.mod.json
│   └── legacy12111
│       └── java
│           └── com/haittorr/smartitemhighlight/client
│               ├── SmartItemHighlightClient.java
│               ├── mixin/AbstractContainerScreenAccessor.java
│               └── render/SlotHighlightRenderer.java
├── build.gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
├── LICENSE
├── README.md
└── settings.gradle
```

## Development

Run the development client on Windows:

```bat
gradlew.bat runClient
```

Run a clean build:

```bat
gradlew.bat clean build
```

Generated development folders such as `build`, `run`, `.gradle` and `.idea` should not be committed to the repository.

## Issues

Report bugs or compatibility problems through the repository's Issues page.

When reporting an issue, include:

* Minecraft version
* Fabric Loader version
* Fabric API version
* Smart Item Highlight version
* Steps needed to reproduce the problem
* Any relevant logs or screenshots

## Licence

This project is distributed under the licence included in the [`LICENSE`](LICENSE) file.

## Credits

Smart Item Highlight was developed by **@haittorrs** with the assistance of AI tools.
