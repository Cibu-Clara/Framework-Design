# 💧 Hydration Glass Component

A reusable, visual hydration tracker built with Jetpack Compose, Android's framework for building UIs. This component displays a glass that fills up based on a user's water intake, designed to represent hydration progress towards a daily goal.

## ✨ Features

- Visual representation of water intake as a filling glass
- Configurable: goal, quantity, glass width & height
- Customizable: units and color
- Easy to integrate into any Compose screen
- Includes preview support for design visualization

## 📂 Content

```plaintext
├── glasscomponent/
│   ├── FilledGlass.kt            // The reusable component
│   ├── HydrationUtils.kt         // Hydration math helpers
│   └── preview/
│       └── FilledGlassPreview.kt // Standalone preview
├── resources/
│   ├── glass_filled.png          // Mask image used for clipping
│   └── glass_empty.png           // Top-layer overlay
├── README.md
```

## 🔧 Setup

1. Clone or Download the repo

```bash
git clone https://github.com/Cibu-Clara/Framework-Design.git
```

2. Copy the `FilledGlass.kt` into your project's ui components package. You can also make use of the functions in `HydrationUtils.kt`.

3. Make sure you import the resources (`glass_empty.png`, `glass_filled.png`) into your res/drawable directory.

## 🚀 Usage Example

```kotlin 
FilledGlass(
    dailyGoal = 2000f, // Total target intake
    quantity = 1500f,  // Amount consumed so far
    units = "ml",      // Display unit ("ml", "oz")
    fillColor = Color.Cyan // Color used to fill the water inside the glass
)
```

This will render a hydration glass filled to 75%, with a white overlay showing the intake value at the bottom of the glass, as below:

![Hydration Glass Preview](https://github.com/user-attachments/assets/2d3463fa-b7d6-4a98-a19e-e25e4b3d7e25)

You can also modify the size of the glass:

```kotlin
// Default values
const val GLASS_HEIGHT = 230
const val GLASS_WIDTH = 172  
```

## ⚙️ Technical Aspects

- Built entirely using Jetpack Compose
- Uses custom canvas drawing through `drawWithContent`, allowing low-level rendering control
- Image masking done using `BlendMode.DstIn`
- Responsively updates fill level and text
- Layout uses `Box` layers to simulate the fill and glass overlay
- Utility functions handle hydration computations: `computeHydrationPercent()`, `computeHydrationLevel()`

## 🧩 Use Cases

- Personal wellness or fitness apps
- Gamified habit trackers
- Hydration reminders
- Any Compose-based UI that visualizes progress towards a liquid goal

Proof of Concept:

![image](https://github.com/user-attachments/assets/c2b12e63-1330-4dfe-907b-0443fecb82ce)

## 🪄 Future Ideas

- Animate the water rising when quantity increases
- Add bubble or wave effects and sounds for a more realistic fill
- Allow user-defined image assets for glass style

‼️ Make sure to install the required dependencies
